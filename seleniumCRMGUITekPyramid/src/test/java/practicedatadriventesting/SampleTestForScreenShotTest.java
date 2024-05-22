package practicedatadriventesting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShotTest {
	
	@Test
	public void flipkartTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.flipkart.com/");
		
		// Step 1: Create an object of EventFiringwebdriver
		EventFiringWebDriver driverr=new EventFiringWebDriver(driver);
		
		// Step 2: use Screenshots method to get file type
		File src = driverr.getScreenshotAs(OutputType.FILE);
		
		// Step 3: Store Screen On local Driver
		FileUtils.copyFile(src,new File("./screenshots/homepage.jpeg"));
	}
	

}
