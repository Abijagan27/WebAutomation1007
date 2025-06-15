package Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumUtils {
    private WebDriver driver;

    public SeleniumUtils(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
    }

    public WebElement waitForElement(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void takeScreenshot(String filePath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickElement(WebElement element) {
        waitForElement(By.xpath(element.getAttribute("xpath")), 10).click();
    }

    public void sendKeys( WebElement element, String keys) {
        try {
            System.out.println("Waiting for element to be visible...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("Clearing existing text...");
            element.clear(); // Clear existing text if any
            System.out.println("Sending keys: " + keys);
            element.sendKeys(keys);
        } catch (Exception e) {
            System.out.println("Error sending keys: " + e.getMessage());
        }  }

    public static void selectDropdownValue(WebDriver driver, By locator, String valueToSelect, String selectBy) {
        try {
            WebElement dropdownElement = driver.findElement(locator);
            Select dropdown = new Select(dropdownElement);

            switch (selectBy.toLowerCase()) {
                case "visibletext":
                    dropdown.selectByVisibleText(valueToSelect);
                    break;
                case "value":
                    dropdown.selectByValue(valueToSelect);
                    break;
                case "index":
                    dropdown.selectByIndex(Integer.parseInt(valueToSelect));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid selectBy type. Use 'visibleText', 'value', or 'index'.");
            }

            System.out.println("Selected '" + valueToSelect + "' from dropdown.");

        } catch (Exception e) {
            System.err.println("Error selecting dropdown value: " + e.getMessage());
        }
    }
}
