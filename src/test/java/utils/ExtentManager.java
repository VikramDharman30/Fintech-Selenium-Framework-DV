package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    public static ExtentReports getExtent() {

        if (extent == null) {

            String reportPath =
                    System.getProperty("user.dir")
                            + "/reports/ExtentReport.html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setReportName(
                    "FinTech Automation Report"
            );

            spark.config().setDocumentTitle(
                    "Test Results"
            );

            extent = new ExtentReports();
            extent.attachReporter(spark);

        }

        return extent;
    }

    public static void setTest(ExtentTest extentTest) {

        test.set(extentTest);

    }

    public static ExtentTest getTest() {

        return test.get();

    }

}