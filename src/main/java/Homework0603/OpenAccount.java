package Homework0603;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccount extends BasePage {
    private By listOfCustomer = By.id("userSelect");
    private By listOfCurrency = By.id("currency");
    private By processButton = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
    private By homeButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");

    public OpenAccount(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void customerSelectFromList(String customer) {
        Select customerFromList = new Select(getDriver().findElement(listOfCustomer));
        customerFromList.selectByVisibleText(customer);
    }

    public void currencySelectFromList(String currency) {
        Select currencyFromList = new Select(getDriver().findElement(listOfCurrency));
        currencyFromList.selectByVisibleText(currency);
    }

    public void processButtonClick() {
        getDriver().findElement(processButton).click();
    }

    public void openAccount(String customer, String currency) {
        customerSelectFromList(customer);
        currencySelectFromList(currency);
        processButtonClick();
    }

    public void homeButtonClick() {
        getDriver().findElement(homeButton).click();
    }
}