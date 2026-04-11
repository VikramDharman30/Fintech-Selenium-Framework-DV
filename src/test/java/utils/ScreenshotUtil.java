package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {
    public static void captureScreenshot(
            WebDriver driver,
            String testName) {

        if (driver == null) {

            System.out.println(
                    "Driver is NULL — Screenshot skipped");

            return;

        }

        try {

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            File source =
                    ts.getScreenshotAs(OutputType.FILE);

            File destination =
                    new File("screenshots/"
                            + testName + ".png");

            destination.getParentFile().mkdirs();

            Files.copy(
                    source.toPath(),
                    destination.toPath()
            );

            System.out.println(
                    "Screenshot saved: "
                            + destination.getAbsolutePath());

        } catch (Exception e) {

            System.out.println(
                    "Screenshot failed: "
                            + e.getMessage());

        }

    }}