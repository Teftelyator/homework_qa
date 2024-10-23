package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static constants.Constant.TimeoutVariable.*;
import static constants.Constant.Urls.MTS_HOME_PAGE;

public class ReplenishmentWithoutCommissionTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MTS_HOME_PAGE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_VALUE));

        WebElement cookie = driver.findElement(By.id("cookie-agree"));
        cookie.click();
    }

    @Test(priority = 2)
    public void blockTitleTest() {
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div//*[@class=\"pay__wrapper\"]/h2"));
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        String actualName = blockTitle.getText();

        Assert.assertEquals(actualName, expectedTitle, "Название блока не совпадает");
    }

    @Test(priority = 1)
    public void logoPaymentTest() {
        WebElement logos = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        if (logos.isDisplayed()) {
            System.out.println("Логотипы платежных систем проверены");
        } else {
            System.out.println("Логотипы отсутствуют");
        }
    }

    @Test(priority = 3)
    public void checkingTheLink() {
        WebElement moreAboutTheService = driver.findElement(By.xpath("//*[@id=\"pay-section\"]//*[@class=\"pay__wrapper\"]//a[text()='Подробнее о сервисе']"));
        moreAboutTheService.click();

        System.out.println("Ссылка 'Подробнее о сервисе' ведет на страницу:  " + driver.getCurrentUrl());
        driver.navigate().back();
    }

    @Test(priority = 4)
    public void continueButtonTest() {
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys(TEST_NUMBER);

        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.sendKeys(TEST_SUM);

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]//button[text()='Продолжить']"));//
        continueButton.click();

        WebElement bepaidIframe = driver.findElement(By.className("bepaid-iframe"));
        bepaidIframe.isDisplayed();

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.close();
        }
    }
}
