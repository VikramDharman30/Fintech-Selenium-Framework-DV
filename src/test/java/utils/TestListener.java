package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        ExtentManager.getExtent();

    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                ExtentManager
                        .getExtent()
                        .createTest(
                                result.getName()
                        );

        ExtentManager.setTest(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        WebDriver driver = BaseTest.driver;

        try {

            String base64Screenshot =
                    ScreenshotUtil
                            .captureScreenshotBase64(driver);

            ExtentManager
                    .getTest()
                    .pass(
                            "Test Passed",
                            MediaEntityBuilder
                                    .createScreenCaptureFromBase64String(
                                            base64Screenshot,
                                            result.getName()
                                    )
                                    .build()
                    );

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = BaseTest.driver;

        try {

            String base64Screenshot =
                    ScreenshotUtil
                            .captureScreenshotBase64(driver);

            ExtentManager
                    .getTest()
                    .fail(
                            result.getThrowable(),
                            MediaEntityBuilder
                                    .createScreenCaptureFromBase64String(
                                            base64Screenshot
                                    )
                                    .build()
                    );

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager
                .getExtent()
                .flush();

    }

}