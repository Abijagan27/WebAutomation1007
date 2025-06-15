package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() {
        // Initialize the Extent Report before each test
        ExtentReportManager.initReport();

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");

        // Setup ChromeDriver
        WebDriverManager.chromedriver().driverVersion("136.0.7103.93").setup(); // Or specify version if needed
        driver.set(new ChromeDriver(options));

        // Timeouts and navigation
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        getDriver().get("https://testautomationpractice.blogspot.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Quit browser and flush report
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }

        // Flush Extent Report
        ExtentReportManager.flushReport();
    }
}
