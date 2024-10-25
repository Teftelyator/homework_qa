package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.Constant.TimeoutVariable.*;
import static constants.Constant.Urls.MORE_ABOUT_SERVICE;
import static constants.Constant.Urls.MTS_HOME_PAGE;

public class ReplenishmentWithoutCommissionTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MTS_HOME_PAGE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_VALUE));

        WebElement cookie = driver.findElement(By.id("cookie-agree"));
        cookie.click();
    }

    @Test
    public void blockTitleTest() {
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div//*[@class=\"pay__wrapper\"]/h2"));
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        String actualName = blockTitle.getText();

        Assert.assertEquals(actualName, expectedTitle, "Название блока не совпадает");
    }

    @Test
    public void logoPaymentTest() throws NoSuchElementException {

        Map<String, String> expectedLogos = new HashMap<>();
        expectedLogos.put("Visa", "//div[@class='pay__partners']//*[@alt='Visa']");
        expectedLogos.put("Verified By Visa", "//div[@class='pay__partners']//*[@alt='Verified By Visa']");
        expectedLogos.put("MasterCard", "//div[@class='pay__partners']//*[@alt='MasterCard']");
        expectedLogos.put("MasterCard Secure Code", "//div[@class='pay__partners']//*[@alt='MasterCard Secure Code']");
        expectedLogos.put("Белкарт", "//div[@class='pay__partners']//*[@alt='Белкарт']");

        List<WebElement> logoBlock = driver.findElements(By.xpath("//*[@id=\"pay-section\"]//div[@class='pay__partners']/ul/li"));
        Assert.assertEquals(logoBlock.size(), expectedLogos.size(), "Количество логотипов платежных систем не соответсвует заявленной!");


        for (Map.Entry<String, String> entry : expectedLogos.entrySet()) {
            String key = entry.getKey();
            try {
                WebElement logo = driver.findElement(By.xpath(entry.getValue()));
                if (logo.isDisplayed()) {
                    System.out.println("Логотип: " + key + " присутствует");
                } else {
                    System.out.println("Логотип:" + key + " не найден");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Логотип: " + key + " не найден");
            }
        }
    }

    @Test
    public void checkingTheLink() {
        WebElement moreAboutTheService = driver.findElement(By.xpath("//*[@id=\"pay-section\"]//*[@class=\"pay__wrapper\"]//a[text()='Подробнее о сервисе']"));
        moreAboutTheService.click();
        Assert.assertEquals(driver.getCurrentUrl(), MORE_ABOUT_SERVICE);
        driver.navigate().back();
    }

    @Test
    public void continueButtonTest() {
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys(TEST_NUMBER);

        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.sendKeys(TEST_SUM);

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]//button[text()='Продолжить']"));//
        continueButton.click();

        WebElement bepaidIframe = driver.findElement(By.className("bepaid-iframe"));
        bepaidIframe.isEnabled();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
