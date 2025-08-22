import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/p/page7.html");

		driver.findElement(By.linkText("Open a popup window")).click();

//		String defaultwindow = driver.getWindowHandle();
//		System.out.println("Orginal window handle: " +defaultwindow);
//		Set<String> allwindows =  driver.getWindowHandles();
//
//		Iterator<String> it = allwindows.iterator();
//		it.next(); //focused window handle
//		String childwindow = it.next(); //child windows handle
//
//		System.out.println("new window got open");
//
//		driver.switchTo().window(childwindow); //switch to childwindow
//
//		System.out.println("focused switched to Child window" + childwindow );
//
//		driver.close();
//
//		driver.switchTo().window(defaultwindow);
//
//		System.out.println("Focus switched to default window :" + defaultwindow);
//		driver.close();

		String originalWindowHandle = driver.getWindowHandle();

        System.out.println("Original Window Handle: " + originalWindowHandle);
        System.out.println("Original Window Title: " + driver.getTitle());
        Thread.sleep(2000);

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All Window Handles: " + allWindowHandles);

        String newWindowHandle = null;

        for(String handle : allWindowHandles) {
        	if(!handle.equals(originalWindowHandle)) {
        		newWindowHandle = handle;
        		break;
        	}

        }

        if (newWindowHandle != null) {
        	driver.switchTo().window(newWindowHandle);
            System.out.println("Switched to New Window Handle: " + newWindowHandle);
            System.out.println("New Window Title: " + driver.getTitle());

	        driver.close();

	        driver.switchTo().window(originalWindowHandle);

	        System.out.println("Switched back to Original Window Handle: " + driver.getWindowHandle());
	        System.out.println("Original Window Title (after switching back): " + driver.getTitle());

        } else {
            System.out.println("Could not find a new window.");
        }

        Thread.sleep(2000);
        driver.quit();

	}

}
