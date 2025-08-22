import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/p/page7.html");

//		driver.findElement(By.className("dropdown")).click();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//
//		// element facebook button appears after delay of 3 seconds
//		WebElement dropdown  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
//		dropdown.click();

		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(9));

		WebElement timerbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("timerButton")));
		timerbutton.click();

		System.out.println("button got clicked");
		driver.quit();
	}

}
