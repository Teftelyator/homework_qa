package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeInternetPage extends BasePage {
    private final By internetHomeField = By.id("internet-phone");
    private final By homeInternetSumField = By.id("internet-sum");
    private final By homeInternetEmailField = By.id("internet-email");
    private final By homeInternet = By.xpath("//*[@id=\"pay-section\"]//p[text()='Домашний интернет']");

    public HomeInternetPage(WebDriver driver) {
        super(driver);
    }

    public String homeInternetFieldPhone() {
        return definingTab(homeInternet, internetHomeField);
    }

    public String homeInternetFieldSum() {
        return definingTab(homeInternet, homeInternetSumField);
    }

    public String homeInternetFieldEmail() {
        return definingTab(homeInternet, homeInternetEmailField);
    }
}
