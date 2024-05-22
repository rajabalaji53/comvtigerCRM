package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkOnDDTInVtigerOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis=new FileInputStream("C:\\Users\\rajak\\Desktop\\commondatas.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		WebDriver driver=null;
		
		if(BROWSER.contains("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.contains("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.contains("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// navigate to the application
		driver.get(URL);
		// login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// Click on organization module
		driver.findElement(By.linkText("Organizations")).click();
		// click on lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// enter the organization name
		driver.findElement(By.name("accountname")).sendKeys("TekPyramid_online");
		// click on save button
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
