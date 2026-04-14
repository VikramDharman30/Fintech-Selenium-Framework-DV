package utils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitUtils {

    public static WebElement waitForElementVisible(By locator) {

        WebDriverWait wait =
                new WebDriverWait(
                        BaseTest.getDriver(),
                        Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(locator));
    }

    public static void waitForElementClickable(By locator) {

        WebDriverWait wait =
                new WebDriverWait(
                        BaseTest.getDriver(),
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions
                        .elementToBeClickable(locator));
    }
}
