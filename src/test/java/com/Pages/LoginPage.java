package com.Pages;

import Utils.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    // Constructor to initialize WebElements using PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='app']//button[@type='submit']")
    private WebElement loginButton;

    // Action method for logging in
    public void login(String username, String password) {
        LoggerUtility.logInfo("Entered username");
        usernameField.sendKeys(username);
        LoggerUtility.logInfo("Entered passwrod");

        passwordField.sendKeys(password);
        LoggerUtility.logInfo("Clicked logim");

        loginButton.click();
    }
}
