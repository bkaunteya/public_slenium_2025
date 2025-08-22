package com.base.qa;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	// ThreadLocal ensures that each thread gets its own, independent WebDriver instance.
	private static ThreadLocal<WebDriver> driver = new ThreadLocal();
	
    private static Set<WebDriver> allDrivers = ConcurrentHashMap.newKeySet();

	
	// Private constructor to prevent instantiation.
	private DriverFactory() { }
		
	// Method to initialize the WebDriver for the current thread.
    // It takes a browser name as a parameter from the testng.xml file.
	
	public static void setDriver(String browser) {
		//String browser = ConfigReader.getProperty("browser"); // read from config
		//int timeout = Integer.parseInt(ConfigReader.getProperty("timeout", "20"));
		
		String url = ConfigReader.getProperty("baseURL");
		
		
			WebDriver webdriver = null;
			
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				
				
				ChromeOptions options = new ChromeOptions();
	        	options.addArguments("--disable-infobars");
	        	options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	        	
	        	webdriver = new ChromeDriver(options);
				
			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				webdriver = new FirefoxDriver();
				
			} else if(browser.equalsIgnoreCase("edge")) {
				//io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
				System.setProperty("webdriver.edge.driver", "C:\\Users\\bkkau\\Downloads\\edgedriver_win64\\msedgedriver.exe");
				webdriver = new EdgeDriver();
			} else {
				throw new IllegalArgumentException("Browser not supported: " + browser);
			}
			
			webdriver.manage().window().maximize();
			webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
			// Navigate to URL from config.properties
			if (url != null && !url.isEmpty()) {
			    webdriver.get(url);
			} else {
			    System.err.println("⚠️ baseURL is missing in config.properties");
			}
			
			// Store the new WebDriver instance in the ThreadLocal variable.
			driver.set(webdriver);
			allDrivers.add(webdriver);
			
		}
	
	// Method to get the WebDriver instance for the current thread.
	public static WebDriver getDriver() {
		return driver.get();
	}
		
	// Method to quit the driver and remove the ThreadLocal instance.
	public static void quitdriver() {
		WebDriver drv = driver.get();
		if (drv != null) {
            drv.quit();
            driver.remove();
            allDrivers.remove(drv);
        }
//		if(getDriver()!=null) {
//			getDriver().quit();
//			
//			driver.remove(); // This is crucial to clean up the thread's local instance.
		
	}
	
	public static void quitAllDrivers() {
        for (WebDriver drv : allDrivers) {
            if (drv != null) {
                drv.quit();
            }
        }
        allDrivers.clear();
    }

}
