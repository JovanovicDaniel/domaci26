package Homework0603;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingCustomer extends BasePage {


    private By inputCustomerFirstNameTextBox = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By inputCustomerLastNameTextBox = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By inputCustomerPostalCodeTextBox = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
    private By openAccountButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");



    public AddingCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void inputCustomerFirstName(String customerFirstName) {
        getDriver().findElement(inputCustomerFirstNameTextBox).sendKeys(customerFirstName);
    }

    public void inputCustomerLastName(String customerLastName) {
        getDriver().findElement(inputCustomerLastNameTextBox).sendKeys(customerLastName);
    }

    public void inputCustomerPostCode(String customerPostalCode) {
        getDriver().findElement(inputCustomerPostalCodeTextBox).sendKeys(customerPostalCode);
    }

    public void customerFillInputData(String customerFirstName, String customerLastName, String customerPostalCode) {
        inputCustomerFirstName(customerFirstName);
        inputCustomerLastName(customerLastName);
        inputCustomerPostCode(customerPostalCode);
    }

    public void addCustomerClick() {
        getDriver().findElement(addCustomer).click();
    }

    public void openAccountButtonClick() {
        getDriver().findElement(openAccountButton).click();
    }
}
