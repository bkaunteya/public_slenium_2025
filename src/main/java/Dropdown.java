import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");

		// 1. Locate the  element
		WebElement dropdownelement =  driver.findElement(By.id("dropdown"));

		// 2. Create a Select object
		Select dropdown = new Select(dropdownelement);

		// 3. Get all the options from the dropdown
		List<WebElement> options = dropdown.getOptions();
		System.out.println("number of element found in drop down : " + options.size());
		
		System.out.println("First Selected element is: " + dropdown.getFirstSelectedOption());

		for(WebElement option : options) {

			System.out.println("Text: " + option.getText() + " Value is: " + option.getDomAttribute("value"));

		}

		// Select by visible text
		dropdown.selectByVisibleText("Option 1");
		System.out.println("Selected by visible text: Option 1" );
        Thread.sleep(1000); // For demonstration, to see the change

        dropdown.selectByValue("2");
        System.out.println("Selected by value: 2 (Option 2)");
        Thread.sleep(1000);
        
        dropdown.selectByIndex(1);
        System.out.println("Selected by index  as Option 2" );


		driver.quit();
	}

}
