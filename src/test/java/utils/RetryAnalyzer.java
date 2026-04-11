package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int retryCount = 0;
    int maxRetryCount = 2;  // Retry failed test 2 times

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {

            retryCount++;

            System.out.println(
                    "Retrying test: "
                            + result.getName()
                            + " | Attempt: "
                            + retryCount);

            return true;

        }

        return false;

    }

}