package com.base.qa;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration; // Import Duration for implicit waits
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
    // Properties should ideally be loaded once and then accessed.
    // Making them static is fine for a common config.
    private static Properties props; // It's good practice to make fields private if not directly accessed from outside
    // No need for 'inputstream' as a static field if used in a try-with-resources block.

    // A static block is often used to load properties once when the class is loaded.
    static {
        props = new Properties();
        String propFileName = "config.properties";
        try (InputStream input = BaseTest.class.getClassLoader().getResourceAsStream(propFileName)) {
            // Check if the input stream is found
            if (input == null) {
                System.err.println("Sorry, unable to find " + propFileName + ". Please ensure it's in the resources folder.");

            } else {
                props.load(input);
            }
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
            e.printStackTrace(); // Print full stack trace for debugging
        }
    }

    // This main method is typically used for simple execution or debugging a single flow.
    // For proper test execution, you'd integrate with TestNG or JUnit.
    //public static void main(String[] args) {
    @BeforeSuite
    public void setup() {
        //WebDriver driver = null; // Initialize driver to null for proper handling in finally block

        try {
            //Use WebDriverManager to setup ChromeDriver
            // This line will download the correct driver if not present and set the system property
    		WebDriverManager.chromedriver().setup();
    		ChromeOptions options = new ChromeOptions();
        	options.addArguments("--disable-infobars");
        	options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        	
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Good practice for waits

            // Access properties loaded in the static block
            String url = props.getProperty("baseURL"); // Assuming you'll have a baseURL in config.properties
            if (url == null) {
                //url = "https://auth.geeksforgeeks.org/"; // Fallback if property is not found
                System.out.println("Property 'baseURL' not found in config.properties. Using default URL.");
            }
            driver.get(url);

            System.out.println("Successfully opened: " + driver.getCurrentUrl());


        } catch (Exception exp) {
            System.err.println("An error occurred during test execution: " + exp.getMessage());
            exp.printStackTrace(); // Print stack trace for any runtime exceptions
            throw new org.testng.SkipException("WebDriver setup failed, skipping tests.", exp);
        } 
//        finally {
//            // Ensure the driver is closed even if an exception occurs
//            if (driver != null) {
//                driver.quit();
//                System.out.println("Browser closed.");
//            }
//        }
    }
	
    @AfterSuite
    public void tearDownSuite()  {
    	System.out.println("--- Tearing down WebDriver in BaseTest ---");
        if (driver != null) {
            driver.quit();
            driver = null; // Set to null to explicitly release resource
        } else {
            System.out.println("WebDriver instance was already null or not initialized.");
        }
	}

    // You can add a method to get properties if needed externally
//    public static String getConfigProperty(String key) {
//        return props.getProperty(key);
//    }
}