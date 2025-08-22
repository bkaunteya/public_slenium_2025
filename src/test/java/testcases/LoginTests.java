package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.qa.BaseTest;
import com.base.qa.DriverFactory;

import listeners.RetryAnalyzer;
import seleniumtests.LoginPage;


public class LoginTests extends BaseTest {

	LoginPage loginpage;
	
	@BeforeMethod
	public void setupLoginPage() {
		loginpage = new LoginPage(driver);
		
	}
	
//	@Test(priority = -1)
//	public void testBack() {
//		System.out.println("Back check method");
//	}
//	 
	//@Test(priority = 0, retryAnalyzer = RetryAnalyzer.class)
	@Test
	public void testCheck() {
		System.out.println("Test check method");
		Assert.assertTrue(false, "Failing intentionally");
		
	}
	
//	@Test(priority = 1)
//	public void testLogin() throws InterruptedException {
//		
//		loginpage.setUserName("Admin");
//		loginpage.setPassword("admin123"); // 
//		loginpage.clickSignInButton();
//		String title = "OrangeHRMm";
//		String originalTitle = driver.getTitle();
//		
//		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        //wait.until(ExpectedConditions.titleContains("OrangeHRM"));
//		
//		Thread.sleep(2);
//		Assert.assertEquals(title, originalTitle);
//		System.out.println("login test completed*********");
//		
//	} 
	
}
