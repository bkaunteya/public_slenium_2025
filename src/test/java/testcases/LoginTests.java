package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.qa.BaseTest;

import seleniumtests.LoginPage;


public class LoginTests extends BaseTest {

	LoginPage loginpage;
	
	@BeforeClass
	public void setupLoginPage() {
		loginpage = new LoginPage(driver);
	}
	
	@Test
	public void testLogin() {
		loginpage.setUserName("bkkaunteya@gmail.com");
		loginpage.setPassword("FuckOff@@1");
		loginpage.clickSignInButton();
	}
	
}
