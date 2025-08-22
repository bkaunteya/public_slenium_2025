import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayed {

	public static void main(String[] args) {

		WebDriver driver;
		driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/p/page7.html");
		driver.manage().window().maximize();
		boolean btnstatus = driver.findElement(By.id("but2")).isDisplayed();
		System.out.println("button2 status by isDisplayed ? " + btnstatus);
		System.out.println("button2 status by isSelected? " + btnstatus);

		boolean chkbox = driver.findElement(By.id("checkbox1")).isSelected();
		System.out.println("Checkbox Orange is selected? " + chkbox);

		boolean chkbox2 = driver.findElement(By.id("checkbox2")).isSelected();
		System.out.println("Checkbox Blue is selected? " + chkbox2);

		//size() to check if element is present or not

		if(driver.findElements(By.id("tb2")).size()!=0) {
			System.out.println("Element is avaiable over the page");
		} else {
			System.out.println("element is not present over the page");
		}

		boolean btnenabled = driver.findElement(By.id("but1")).isEnabled();
		System.out.println("Button1 is enabled ?" + btnenabled);

		//dropdown

		driver.quit();
	}

}
