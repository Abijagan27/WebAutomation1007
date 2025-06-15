package com.ContactForm;
import Utils.ExtentReportManager;
import Utils.PropertyLoader;
import Utils.SeleniumUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import Utils.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

import java.io.File;

public class MyStepdefs extends BaseClass {

    private PropertyLoader prop;


    @Before
    public void init() {
        setUp(); // Initialize WebDriver here
        prop=new PropertyLoader(new File("src/test/resources/TestData/RegisterData.properties"));
    }
    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        getDriver().get("https://www.mycontactform.com/signup.php");
    }
    @Then("I should see the title")
    public void i_should_see_the_title() {
        ExtentReportManager.logInfo("Get the Title ");
        getDriver().getTitle();
    }
    @Then("I should see the current url")
    public void i_should_see_the_current_url() {
        ExtentReportManager.logInfo("Get the url ");

        System.out.println(getDriver().getCurrentUrl());
    }
    @Then("I should register")
    public void iShouldRegister() throws InterruptedException {
      //  getDriver().findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(prop.getProperty("Name"));
    getDriver().findElement(By.xpath(prop.getProperty("namePath"))).sendKeys(prop.getProperty("Name"));
    Thread.sleep(3000);
        //registerPage.register();
    }
    @AfterClass
    public void teardown() {
        tearDown(); // Clean up
    }
}
