package Homework0603;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private CustomerAndManagerLogIn customerAndManagerLogin;
    private Manager manager;
    private AddingCustomer addCustomer;
    private Customer customer;
    private OpenAccount openAccount;
    private Account account;
    private final String customerFirstName = "Jovan";
    private final String customerLastName = "Jovanovic";
    private final String customerPostCode = "3525454";
    private final String currency = "Dollar";
    private final String deposit = "10000";
    private final String withdrawal = "5000";

    @BeforeClass
    public void BeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jovan\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        customerAndManagerLogin = new CustomerAndManagerLogIn(driver,driverWait);
        manager = new Manager(driver, driverWait);
        addCustomer = new AddingCustomer(driver, driverWait);
        customer = new Customer(driver, driverWait);
        openAccount = new OpenAccount(driver, driverWait);
        account = new Account(driver, driverWait);

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test(priority = 1)
    public void managerLogIn() {
        customerAndManagerLogin.managerLogin();
        driverWait.until(ExpectedConditions.urlContains("manager"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }

    @Test(priority = 2)
    public void createCustomer() {
        manager.addCustomerButtonClick();
        addCustomer.customerFillInputData(customerFirstName, customerLastName, customerPostCode);
        addCustomer.addCustomerClick();
        Assert.assertEquals(driver.switchTo().alert().getText().substring(0, 27), "Customer added successfully");
        driver.switchTo().alert().accept();
    }

    @Test(priority = 3)
    public void createCustomerAccount() {
        addCustomer.openAccountButtonClick();
        openAccount.openAccount(customerFirstName + " " + customerLastName, currency);
        Assert.assertEquals(driver.switchTo().alert().getText().substring(0, 28), "Account created successfully");
        driver.switchTo().alert().accept();
    }

    @Test(priority = 5)
    public void customerLogIn() {
        customerAndManagerLogin.customerLogin();
        customer.loginCustomer(customerFirstName + " " + customerLastName);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/strong/span")).getText(),
                customerFirstName + " " + customerLastName);
    }

    @Test(priority = 6)
    public void addDeposit() {
        account.depositButtonClick();
        account.addDeposit(deposit);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).getText(),
                "Deposit Successful");
    }

    @Test(priority = 7)
    public void addWithdrawal() {

        account.withdrawlButtonClick();
        account.addDeposit(withdrawal);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).getText(),
                "Transaction successful");
    }

    @Test(priority = 4)
    public void testManagerLoginLogout() {
        manager.homeButtonClick();
        driverWait.until(ExpectedConditions.urlContains("login"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test(priority = 8)
    public void testCustomerLogout() {
        account.logoutButtonClick();
        driverWait.until(ExpectedConditions.urlContains("customer"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
