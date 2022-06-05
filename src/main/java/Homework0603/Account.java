package Homework0603;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account extends BasePage {


    private By depositButton = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By withDrawlButton = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By logoutButton = By.xpath("/html/body/div/div/div[1]/button[2]");
    private By inputDepositWithdrawalTextBox = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By addDepositWithdrawalButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");

    public Account(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void depositButtonClick() {
        getDriver().findElement(depositButton).click();
    }

    public void addDepositToCustomer(String deposit) {
        threadWait();
        getDriver().findElement(inputDepositWithdrawalTextBox).sendKeys(deposit);
    }

    public void addDepositeButtonClick() {
        getDriver().findElement(addDepositWithdrawalButton).click();
    }

    public void addDeposit(String deposit) {
        addDepositToCustomer(deposit);
        addDepositeButtonClick();
    }

    public void withdrawlButtonClick() {
        getDriver().findElement(withDrawlButton).click();
    }

    public void logoutButtonClick() {
        getDriver().findElement(logoutButton).click();
    }
}
