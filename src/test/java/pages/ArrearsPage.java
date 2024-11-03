package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArrearsPage extends BasePage {
    private final By scoreArrearsField = By.id("score-arrears");
    private final By arrearsSumField = By.id("arrears-sum");
    private final By arrearsEmailField = By.id("connection-email");
    private final By arrears = By.xpath("//*[@id=\"pay-section\"]//p[text()='Задолженность']");

    public ArrearsPage(WebDriver driver) {
        super(driver);
    }

    public String scoreArrearsFieldNumber() {
        return definingTab(arrears, scoreArrearsField);
    }

    public String scoreArrearsSum() {
        return definingTab(arrears, arrearsSumField);
    }

    public String scoreArrearsEmail() {
        return definingTab(arrears, arrearsEmailField);
    }
}
