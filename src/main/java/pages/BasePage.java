package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;
    private final By selectWrapper = By.className("select__now");

    private final By blockTitle = By.xpath("//*[@id=\"pay-section\"]/div/div//*[@class=\"pay__wrapper\"]/h2");
    private final By cookie = By.id("cookie-agree");
    private final By logoBlock = By.xpath("//*[@id=\"pay-section\"]//div[@class='pay__partners']/ul/li");

    private final By moreAboutTheService = By.xpath("//*[@id=\"pay-section\"]//*[@class=\"pay__wrapper\"]//a[text()='Подробнее о сервисе']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String definingTab(By service, By field) {
        driver.findElement(selectWrapper).click();
        driver.findElement(service).click();
        return driver.findElement(field).getAttribute("placeholder");
    }

    public void enterField(By field, String value) {
        driver.findElement(field).sendKeys(value);
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

    public void clickMoreAboutService() {
        driver.findElement(moreAboutTheService).click();
    }
}
