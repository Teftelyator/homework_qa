package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ArrearsPage;
import pages.CommunicationServicePage;
import pages.HomeInternetPage;
import pages.InstallmentPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static constants.Constant.Placeholders.*;
import static constants.Constant.TimeoutVariable.IMPLICIT_VALUE;
import static constants.Constant.Urls.MORE_ABOUT_SERVICE;
import static constants.Constant.Urls.MTS_HOME_PAGE;

public class ReplenishmentWithoutCommissionTest {
    private WebDriver driver;
    private CommunicationServicePage communicationServicePage;
    private HomeInternetPage homeInternetPage;
    private InstallmentPage installmentPage;
    private ArrearsPage arrearsPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MTS_HOME_PAGE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_VALUE));

        communicationServicePage = new CommunicationServicePage(driver);
        homeInternetPage = new HomeInternetPage(driver);
        installmentPage = new InstallmentPage(driver);
        arrearsPage = new ArrearsPage(driver);
        communicationServicePage.agreeCookies();
    }

    @Test
    public void blockTitleTest() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        String actualName = communicationServicePage.getBlockTitle();
        Assert.assertEquals(actualName, expectedTitle, "Название блока не совпадает");
    }

    @Test
    public void logoPaymentTest() {
        Map<String, String> expectedLogos = new HashMap<>();
        expectedLogos.put("Visa", "Visa");
        expectedLogos.put("Verified By Visa", "Verified By Visa");
        expectedLogos.put("MasterCard", "MasterCard");
        expectedLogos.put("MasterCard Secure Code", "MasterCard Secure Code");
        expectedLogos.put("Белкарт", "Белкарт");

        Assert.assertEquals(communicationServicePage.getLogoCount(), expectedLogos.size(), "Количество логотипов платежных систем не соответствует заявленной!");

        for (String key : expectedLogos.keySet()) {
            try {
                WebElement logo = communicationServicePage.getLogo(key);
                Assert.assertTrue(logo.isDisplayed(), "Логотип: " + key + " не найден");
                System.out.println("Логотип: " + key + " присутствует");
            } catch (NoSuchElementException e) {
                System.out.println("Логотип: " + key + " не найден");
            }
        }
    }

    @Test
    public void checkingTheLink() {
        communicationServicePage.clickMoreAboutService();
        Assert.assertEquals(driver.getCurrentUrl(), MORE_ABOUT_SERVICE);
    }

    @Test
    public void continueButtonTest() {
        communicationServicePage.enterPhoneNumber();
        communicationServicePage.enterSum();
        communicationServicePage.clickContinue();
        Assert.assertTrue(communicationServicePage.isBepaidIframeEnabled(), "Переход на страницу оплаты не был произведен!");
    }

    @Test
    public void communicationServiceTest() {
        Assert.assertEquals(communicationServicePage.communicationServiceFieldPhone(), PLACEHOLDER_NUMBER_PHONE_FIELD);
    }

    @Test
    public void communicationServiceFieldSumTest() {
        Assert.assertEquals(communicationServicePage.communicationServiceFieldSum(), PLACEHOLDER_SUM_FIELD);
    }

    @Test
    public void communicationServiceFieldEmailTest() {
        Assert.assertEquals(communicationServicePage.communicationServiceFieldEmail(), PLACEHOLDER_EMAIL_FIELD);
    }

    @Test
    public void homeInternetFieldPhoneTest() {
        Assert.assertEquals(homeInternetPage.homeInternetFieldPhone(), PLACEHOLDER_INTERNET_PHONE_FIELD);
    }

    @Test
    public void homeInternetFieldSumTest() {
        Assert.assertEquals(homeInternetPage.homeInternetFieldSum(), PLACEHOLDER_SUM_FIELD);
    }

    @Test
    public void homeInternetFieldEmailTest() {
        Assert.assertEquals(homeInternetPage.homeInternetFieldEmail(), PLACEHOLDER_EMAIL_FIELD);
    }

    @Test
    public void installmentFieldPhoneTest() {
        Assert.assertEquals(installmentPage.installmentFieldNumber(), PLACEHOLDER_SCORE_INSTALMENT_NUMBER);
    }

    @Test
    public void installmentFieldSumTest() {
        Assert.assertEquals(installmentPage.installmentFieldSum(), PLACEHOLDER_SUM_FIELD);
    }

    @Test
    public void installmentFieldEmailTest() {
        Assert.assertEquals(installmentPage.installmentFieldEmail(), PLACEHOLDER_EMAIL_FIELD);
    }

    @Test
    public void scoreArrearsFieldNumberTest() {
        Assert.assertEquals(arrearsPage.scoreArrearsFieldNumber(), PLACEHOLDER_SCORE_ARREARS_NUMBER);
    }

    @Test
    public void scoreArrearsSumTest() {
        Assert.assertEquals(arrearsPage.scoreArrearsSum(), PLACEHOLDER_SUM_FIELD);
    }

    @Test
    public void scoreArrearsEmailTest() {
        Assert.assertEquals(arrearsPage.scoreArrearsEmail(), PLACEHOLDER_EMAIL_FIELD);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
