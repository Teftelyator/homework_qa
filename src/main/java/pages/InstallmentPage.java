package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstallmentPage extends BasePage {
    private final By installment = By.xpath("//*[@id=\"pay-section\"]//p[text()='Рассрочка']");
    private final By scoreInstalmentNumberField = By.id("score-instalment");
    private final By installmentSumField = By.id("instalment-sum");
    private final By installmentEmailField = By.id("instalment-email");

    public InstallmentPage(WebDriver driver) {
        super(driver);
    }

    public String installmentFieldNumber() {
        return definingTab(installment, scoreInstalmentNumberField);
    }

    public String installmentFieldSum() {
        return definingTab(installment, installmentSumField);
    }

    public String installmentFieldEmail() {
        return definingTab(installment, installmentEmailField);
    }
}
