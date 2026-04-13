package utils;

import base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {
    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String screenshotDir =
                System.getProperty("user.dir")
                        + "/screenshots/";

        File dir = new File(screenshotDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        String screenshotPath =
                screenshotDir
                        + testName
                        + "_"
                        + System.currentTimeMillis()
                        + ".png";

        try {

            File src =
                    ((TakesScreenshot) BaseTest.getDriver())
                            .getScreenshotAs(OutputType.FILE);

            File dest =
                    new File(screenshotPath);

            Files.copy(
                    src.toPath(),
                    dest.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {

            e.printStackTrace();

        }

        return screenshotPath;
    }
    public static String captureScreenshotBase64(WebDriver driver) {

        String base64Screenshot =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BASE64);

        return base64Screenshot;
    }
}