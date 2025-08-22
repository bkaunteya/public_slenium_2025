import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Random {

	public static void main(String[] args) {


		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.id("uploadfile")).sendKeys("C:\\Users\\bkkau\\Downloads\\upload_test.png");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
//		assert successMessage.getText().contains("uploaded successfully");
//
		System.out.println("windown handle: " + driver.getWindowHandle());

		//WebElement uploadedFileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFileName")));
		//assert uploadedFileName.getText().contains("upload_test.png");


		//2nd option:

//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement uploadedFilesContainer = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilesList")));
//		List<WebElement> fileItems = uploadedFilesContainer.findElements(By.tagName("li")); // Or By.className("file-item")
//		boolean fileFound = false;
//		for (WebElement item : fileItems) {
//		    if (item.getText().contains("upload_test.png")) {
//		        fileFound = true;
//		        break;
//		    }
//		}
//		assert fileFound : "Uploaded file 'upload_test.png' not found in the list.";

	}

}
