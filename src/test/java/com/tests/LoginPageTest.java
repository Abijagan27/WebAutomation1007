package com.tests;

import Utils.BaseClass;
import Utils.ExtentReportManager;
import com.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest extends BaseClass {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPageObject() {
        loginPage = new LoginPage(getDriver());
    }
/*
    @Test
    public void loginTest() {
        ExtentReportManager.logInfo("Login Test Started");

        loginPage.login("Admin", "admin123");

        String actualTitle = getDriver().getTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM", "Login failed or title mismatch.");

        ExtentReportManager.logPass("Login Successful");
    }
    */
    @Test
    public void testAutomation() throws InterruptedException {
//        Thread.sleep(3000);
//        getDriver().findElement(By.xpath("//div[@class='date-picker-box']//input[@id='start-date']")).sendKeys("31-05-2025");
//        Thread.sleep(3000);


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://dummy-tickets.com/buyticket");
        driver.manage().window().maximize();

        //WebElement wait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ui-datepicker-div']")));

        driver.findElement(By.xpath("//a[normalize-space()='Both']")).click();

        driver.findElement(By.xpath("(//input[@name='source[]'])[4]")).sendKeys("new delhi");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'New Delhi')]")).click();

        driver.findElement(By.xpath("(//input[@name='destination[]'])[4]")).sendKeys("London");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[contains(text(),'London')])[2]")).click();

        driver.findElement(By.xpath("(//input[@name='departure[]'])[4]")).click();

        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[3]/a")).click();


    }
}
