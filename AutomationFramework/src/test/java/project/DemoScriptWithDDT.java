package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScriptWithDDT {

	public static void main(String[] args) throws IOException {

		// To read data from properties
		
		FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\commonData.Properties");
		Properties prop=new Properties();
		prop.load(pfis);
		
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		// To read data from Excel file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.M3.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		String lastname = workbook.getSheet("Contacts").getRow(1).getCell(2).toString();
	
		//Automation Scripts
		// To launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
		
		// Step 2:- To login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// Step 3 :- To click on contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		// Step 4 :- To click on create account image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		// Step 5:- To enter the data in the mandatory field
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// Step 6:- To verify the created contact
		String contactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactName.contains(lastname)) {
			System.out.println("COntact creation done");
		}else {
			System.out.println("Contact creation failed");
		}
		
		// Step 7:- To logout the application
		WebElement logoutButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(logoutButton).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		// Step 8:- To close the browser
		driver.quit();
		
		
	}

}
