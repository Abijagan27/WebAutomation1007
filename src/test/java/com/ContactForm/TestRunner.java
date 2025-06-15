package com.ContactForm;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/test/resources/Features/HomePage.feature", // Path to your feature files
            glue = "com.ContactForm",               // Path to your step definitions
            plugin = { "pretty", "html:target/cucumber-reports.html" }, // Reporting options
            monochrome = true, // Makes the console output readable
            publish = true
    )
    public class TestRunner extends AbstractTestNGCucumberTests {
    }


