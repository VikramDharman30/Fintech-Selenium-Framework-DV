package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AccountsPage {

    WebDriver driver;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    By openNewAccountLink = By.linkText("Open New Account");
    By fromAccountDropdown = By.id("fromAccountId");
    By accountTypeDropdown = By.id("type");

    By openAccountButton =
            By.xpath("//input[@value='Open New Account']");

    By newAccountNumber =
            By.xpath("//a[@id='newAccountId']");

    // Actions

    public void clickOpenNewAccount() {
        waitSeconds(driver, openNewAccountLink, 10);
        driver.findElement(openNewAccountLink).click();
    }

    public void selectAccountType() {

        Select select =
                new Select(driver.findElement(accountTypeDropdown));
        select.selectByVisibleText("SAVINGS");

        // Wait until From Account dropdown gets populated

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver -> {

            Select fromAccountSelect =
                    new Select(driver.findElement(fromAccountDropdown));
            return !fromAccountSelect.getOptions().isEmpty();

        });

    }

    public void clickOpenAccountButton() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(openAccountButton));
        driver.findElement(openAccountButton).click();
    }


    public boolean isAccountCreated() {
        waitSeconds(driver, newAccountNumber, 10);
        return driver.findElement(newAccountNumber).isDisplayed();

    }

    //wait function to reuse
    public void waitSeconds(WebDriver driver, By element, int seconds){
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(element));
    }


}