package com.base.qa;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.time.Duration; // Import Duration for implicit waits
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	public WebDriver driver;
	
       
	@BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        

        try {
           
        DriverFactory.setDriver(browser);
        
     // Get the driver instance from DriverManager and assign it to the local variable.
        driver = DriverFactory.getDriver();
        
        } catch (Exception exp) {
            System.err.println("An error occurred during test execution: " + exp.getMessage());
            exp.printStackTrace(); // Print stack trace for any runtime exceptions
            throw new org.testng.SkipException("WebDriver setup failed, skipping tests.", exp);
        } 
}
	
    @AfterSuite
    public void tearDownSuite()  {
    	System.out.println("--- Tearing down WebDriver in BaseTest ---");
    	
    	DriverFactory.quitAllDrivers();
    	
    	System.out.println("--- ALl drivers are executed in BaseTest ---");
	}

}