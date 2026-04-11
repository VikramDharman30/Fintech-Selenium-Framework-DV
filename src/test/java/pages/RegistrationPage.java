package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    By registerLink = By.linkText("Register");

    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phoneNumber = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");

    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By confirmPassword = By.id("repeatedPassword");

    By registerButton = By.xpath("//input[@value='Register']");

    // Actions

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void registerUser(String uname, String pwd) {

        clickRegisterLink();

        driver.findElement(firstName).sendKeys("Vikram");
        driver.findElement(lastName).sendKeys("Demo");
        driver.findElement(address).sendKeys("Test Street");
        driver.findElement(city).sendKeys("Chennai");
        driver.findElement(state).sendKeys("TN");
        driver.findElement(zipCode).sendKeys("600001");
        driver.findElement(phoneNumber).sendKeys("9876543210");
        driver.findElement(ssn).sendKeys("12345");

        driver.findElement(username).sendKeys(uname);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(pwd);

        driver.findElement(registerButton).click();

    }

    public boolean isRegistrationSuccessful() {

        return driver.getPageSource()
                .contains("Your account was created successfully");

    }
}