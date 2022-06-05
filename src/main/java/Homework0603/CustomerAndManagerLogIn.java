package Homework0603;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerAndManagerLogIn extends BasePage {


    private By managerLoginButton = By.xpath("//*[contains(text(),'Bank Manager Login')]");
    private By cutomerLoginButton = By.xpath("//*[contains(text(),'Customer Login')]");

    public CustomerAndManagerLogIn(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void managerLogin() {
        getDriver().findElement(managerLoginButton).click();
    }

    public void customerLogin() {
        getDriver().findElement(cutomerLoginButton).click();
    }
}
