package listeners;

import java.nio.file.Files;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.qa.BaseTest;

public class ScreenshotListeners implements ITestListener {
	
	
    @Override
	public void onTestFailure (ITestResult result) {
		Object currentClass = result.getInstance(); // getInstance() returns the actual instance of the test class that failed.
		WebDriver driver = ((BaseTest)currentClass).driver; //The code is type casting the Object to BaseTest. 
															//the test class extends BaseTest, so it inherits its variables/methods.
		// .driver, In BaseTest, there’s probably a public WebDriver driver; field.

		//By casting to BaseTest, we can now access that driver instance from the failed test.
		
		File srcFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("Screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png");
		
		 try {
	            Files.copy(srcFile.toPath(), destFile.toPath());
	            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	
}
