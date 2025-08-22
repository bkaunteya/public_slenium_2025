import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/p/page7.html");
		driver.manage().window().maximize();
		// 1. Locate the  element
		WebElement dropdownelement =  driver.findElement(By.id("multiselect1"));

		// 2. Create a Select object
		Select dropdown = new Select(dropdownelement);

		// 3. Get all the options from the dropdown
		List<WebElement> options = dropdown.getOptions();
		System.out.println("number of element found in drop down : " + options.size());
		
		

		for(WebElement option : options) {

			System.out.println("Text: " + option.getText() + " :: Value is: " + option.getDomAttribute("value"));

		}
		
		dropdown.selectByVisibleText("Hyundai");
		System.out.println("Text selected is : Hyundai");
		Thread.sleep(2000);
		dropdown.selectByValue("swiftx");
		
		driver.findElement(By.id("prompt")).click();
		System.out.println("Click performed on promt");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert box name: " + alertText);
		Thread.sleep(1000);
		String texttoenter = "i am sending the text";
		alert.sendKeys(texttoenter);
		System.out.println("Typed the text: '" + texttoenter + "' into the prompt.");
		Thread.sleep(10000);
		
//		alert.accept();
//		System.out.println("Prompt accepted successfully.");
		
		Thread.sleep(10000);

		driver.quit();
	}

}
