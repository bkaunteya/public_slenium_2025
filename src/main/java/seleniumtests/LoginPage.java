package seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//class variable
	private WebDriver driver;
	
	//constructor
	// driver as local variable
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize WebElements
	}
	

	@FindBy (xpath = "//input[@id='luser']") private WebElement email;
	@FindBy (xpath= "//input[@id='password']") private WebElement password;
	@FindBy (xpath = "//button[normalize-space()='Sign In']") private WebElement siginbutton;

	//Action methods
	
	public void setUserName(String user) {
		if(email!=null) {
			email.sendKeys(user);
		}
		else {
			System.out.println("Email element is not initialized.");
		}
	}
	
	public void setPassword(String pwd) {
		if(password != null) {
			password.sendKeys(pwd);
			
		} else {
			System.out.println("Password element is not initialized.");
		}
	}
	
	public void clickSignInButton() {
		if(siginbutton != null) {
			siginbutton.click();
		} else {
			 System.out.println("Sign In button is not initialized.");
		}
	}
}
