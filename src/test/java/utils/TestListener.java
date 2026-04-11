package utils;

import base.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getName()
        );

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver =
                BaseTest.driver;

        String testName =
                result.getName();

        ScreenshotUtil.captureScreenshot(
                driver,
                testName
        );

    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extent.flush();

    }

}