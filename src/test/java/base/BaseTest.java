package base;

import java.time.Duration;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Listeners;
import utils.LoggerUtil;
import utils.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    protected static Logger log =
            LogManager.getLogger(BaseTest.class);

    @BeforeMethod (alwaysRun = true)
    public void setup() {

        String browser =
                ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            WebDriver wd = new ChromeDriver();
            driver.set(wd);
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        }

        log.info("Thread ID : " + Thread.currentThread().getId());
        getDriver().manage().window().maximize();
        log.info("Launching Browser");
        getDriver().get(ConfigReader.getProperty("baseUrl"));
        log.info("Navigated to URL: " + ConfigReader.getProperty("baseUrl"));
        LoggerUtil.logInfo("Browser launched");

    }

    @AfterMethod
    public void tearDown() {

            getDriver().quit();
            driver.remove();
            log.info("Browser Closed");

    }
}