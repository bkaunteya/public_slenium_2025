package com.base.qa;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	 private static Properties properties; // It's good practice to make fields private if not directly accessed from outside
	 
	    // Static block loads config.properties only once

	    static {
	    	properties = new Properties();
	        String propFileName = "config.properties";
	        
	        try (InputStream input = BaseTest.class.getClassLoader().getResourceAsStream(propFileName)) {
	            // Check if the input stream is found
	            if (input == null) {
	                System.err.println("Sorry, unable to find " + propFileName + ". Please ensure it's in the resources folder.");

	            } else {
	            	properties.load(input);
	            }
	        } catch (IOException e) {
	            System.err.println("Error loading properties file: " + e.getMessage());
	            e.printStackTrace(); // Print full stack trace for debugging
	        }
	    }
	    
	    public static String getProperty(String key) {
	    	return properties.getProperty(key);
	    }
	    
	 // Optional: Overloaded method with default value
	    public static String getProperty(String key, String defaultValue) {
	        return properties.getProperty(key, defaultValue);
	    }
}
