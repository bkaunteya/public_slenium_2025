import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptTextAccept {
	@Test
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
		
		WebElement ele = driver.findElement(By.id("promptexample"));
		ele.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		String alertboxname = alert.getText();
		System.out.println("Promt box name is: " + alertboxname);
		driver.switchTo().alert();
		alert.sendKeys("sending my name: Chrome");
		//Thread.sleep(10000);
		alert.accept();
		System.out.println(" your prompt result :: " + driver.findElement(By.id("promptreturn")).getText());
		
		WebElement ele1 = driver.findElement(By.id("confirmexample"));
		ele1.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
		//alert1.accept();
		alert1.dismiss();
		System.out.println("Alert dismissed:");
		System.out.println("your alert acceprted:" + driver.findElement(By.id("confirmreturn")).getText());
		Thread.sleep(2000);
		driver.quit();
		
	}

}
