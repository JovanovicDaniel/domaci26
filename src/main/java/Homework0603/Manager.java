package Homework0603;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manager extends BasePage {
    private By addCustomerButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By openAccountButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By homeButton = By.xpath("/html/body/div/div/div[1]/button[1]");

    public Manager(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void addCustomerButtonClick() {
        getDriver().findElement(addCustomerButton).click();
    }

    public void openAccountButtonClick() {
        getDriver().findElement(openAccountButton).click();
    }

    public void homeButtonClick() {
        getDriver().findElement(homeButton).click();
    }
}
