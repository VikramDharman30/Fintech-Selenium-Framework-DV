package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = BaseTest.driver;

        String testName =
                result.getName();

        ScreenshotUtil.captureScreenshot(
                driver,
                testName
        );

        System.out.println(
                "Screenshot captured for failed test: "
                        + testName);

    }

}