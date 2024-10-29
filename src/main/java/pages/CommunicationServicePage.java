package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constant.TimeoutVariable.TEST_NUMBER;
import static constants.Constant.TimeoutVariable.TEST_SUM;

public class CommunicationServicePage extends BasePage {
    private final By blockTitle = By.xpath("//*[@id=\"pay-section\"]/div/div//*[@class=\"pay__wrapper\"]/h2");
    private final By cookie = By.id("cookie-agree");
    private final By logoBlock = By.xpath("//*[@id=\"pay-section\"]//div[@class='pay__partners']/ul/li");

    private final By moreAboutTheService = By.xpath("//*[@id=\"pay-section\"]//*[@class=\"pay__wrapper\"]//a[text()='Подробнее о сервисе']");

    private final By phoneNumberField = By.id("connection-phone");
    private final By communicationServiceSumField = By.id("connection-sum");
    private final By communicationServiceEmailField = By.id("connection-email");
    private final By continueButton = By.xpath("//*[@id=\"pay-connection\"]//button[text()='Продолжить']");

    private final By bepaidIframe = By.className("bepaid-iframe");
    private final By communicationServices = By.xpath("//*[@id=\"pay-section\"]//p[text()='Услуги связи']");

    public CommunicationServicePage(WebDriver driver) {
        super(driver);
    }

    public void agreeCookies() {
        driver.findElement(cookie).click();
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

    public int getLogoCount() {
        return driver.findElements(logoBlock).size();
    }

    public WebElement getLogo(String logoName) {
        return driver.findElement(By.xpath("//div[@class='pay__partners']//*[@alt='" + logoName + "']"));
    }

    public void clickMoreAboutService() {
        driver.findElement(moreAboutTheService).click();
    }

    public void enterPhoneNumber() {
        enterField(phoneNumberField, TEST_NUMBER);
    }

    public void enterSum() {
        enterField(communicationServiceSumField, TEST_SUM);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isBepaidIframeEnabled() {
        return driver.findElement(bepaidIframe).isEnabled();
    }

    public String communicationServiceFieldPhone() {
        return definingTab(communicationServices, phoneNumberField);
    }

    public String communicationServiceFieldSum() {
        return definingTab(communicationServices, communicationServiceSumField);
    }

    public String communicationServiceFieldEmail() {
        return definingTab(communicationServices, communicationServiceEmailField);
    }
}
