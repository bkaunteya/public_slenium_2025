
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();


		   // 2. Define the download directory
        String downloadFilePath = System.getProperty("user.dir") + File.separator + "Download_Files";
        File downloadDir = new File(downloadFilePath);
        if (!downloadDir.exists()) {
        	System.out.println("Creating directory");
            downloadDir.mkdirs(); // Create the directory if it doesn't exist
        }

     // 3. Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilePath); // Set the download path
        prefs.put("download.prompt_for_download", false); // Disable the download prompt
        prefs.put("download.directory_upgrade", true); // Important for modern Chrome versions
        prefs.put("safeBrowse.enabled", true); // Optional: Enable safe Browse for better security

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
		driver.get("https://auth.geeksforgeeks.org/");
		
		String title = driver.getTitle();
		System.out.println("your page title is: " + title);
		

		Thread.sleep(500);

		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();



	}

}
