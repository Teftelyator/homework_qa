package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Duration;
import java.util.Locale;

public class PayDetailPage extends BasePage {

    private final By bepaidIframe = By.className("bepaid-iframe");
    private final By place = By.xpath("//*[@class='card-page__card']/button");
    private final By subTitle = By.xpath("//*[@class='pay-description__cost']");

    public PayDetailPage(WebDriver driver) {
        super(driver);
    }

    public String buttonTextOutput() {
        driver.switchTo().frame(driver.findElement(bepaidIframe));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(place)));
        return driver.findElement(place).getText();
    }

    public String subTitleOutput() {
        return driver.findElement(subTitle).getText();
    }

    public String generateValue(double value) {
        DecimalFormatSymbols simb = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.00", simb);
        return decimalFormat.format(value);
    }

    public String generateText(double value) {
        return (generateValue(value) + " BYN");
    }
}
