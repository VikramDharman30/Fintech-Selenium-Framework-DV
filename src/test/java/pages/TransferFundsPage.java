package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class TransferFundsPage {

    WebDriver driver;

    public TransferFundsPage(WebDriver driver) {
        this.driver = BaseTest.getDriver();
    }

    // Locators

    By transferFundsLink =
            By.linkText("Transfer Funds");

    By amountField =
            By.id("amount");

    By fromAccountDropdown =
            By.id("fromAccountId");

    By toAccountDropdown =
            By.id("toAccountId");

    By transferButton =
            By.xpath("//input[@value='Transfer']");

    By transferSuccessMessage =
            By.xpath("//h1[contains(text(),'Transfer Complete')]");

    // Actions

    public void navigateToTransferFunds() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions
                        .elementToBeClickable(transferFundsLink))
                .click();

    }

    public void enterAmount(String amount) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(amountField))
                .sendKeys(amount);

    }

    public void selectFromAccount() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(driver -> {
            Select fromAccountSelect =
                    new Select(driver.findElement(fromAccountDropdown));
            return !fromAccountSelect.getOptions().isEmpty();});

        Select select =
                new Select(driver.findElement(fromAccountDropdown));

        select.selectByIndex(0);

    }

    public void selectToAccount() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(toAccountDropdown));
        wait.until(driver -> {
            Select fromAccountSelect =
                    new Select(driver.findElement(toAccountDropdown));
            return !fromAccountSelect.getOptions().isEmpty();});

        Select select =
                new Select(driver.findElement(toAccountDropdown));

        if (select.getOptions().size() > 1) {

            select.selectByIndex(1);

        } else {

            select.selectByIndex(0);

        }

    }

    public void clickTransferButton() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions
                        .elementToBeClickable(transferButton))
                .click();

    }

    public boolean isTransferSuccessful() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(transferSuccessMessage));

        return driver.findElement(transferSuccessMessage)
                .isDisplayed();

    }

}