package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String testName =
                result.getName();

        ScreenshotUtil.captureScreenshot(
                BaseTest.driver,
                testName
        );

        System.out.println(
                "Screenshot captured for failed test: "
                        + testName);

    }

}