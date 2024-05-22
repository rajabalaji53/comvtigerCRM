package project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class ToCreateContactWithOrganizationWithUtility {

	public static void main(String[] args) throws IOException {

		WebDriverUtility wutil=new WebDriverUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		
		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		wutil.maximizeBrowser(driver);
		wutil.waitForElements(driver);
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// Step 3 :- To click on contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		// Step 4 :- To click on create account image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		// Step 5:- To enter the data in the mandatory field
		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		wutil.toSwitchWindow(driver, "Accounts");
		driver.findElement(By.linkText("vtiger")).click();
		wutil.toSwitchWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		// Step 6:- To verify the created contact
		String contactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactName.contains(LASTNAME)) {
			System.out.println("Contact creation done");
		}else {
			System.out.println("Contact creation failed");
		}
		
		// Step 8:- To logout the application
		WebElement logoutButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.toMouseHover(driver, logoutButton);
		driver.findElement(By.linkText("Sign Out")).click();
		
		// Step 9:- To close the browser
		driver.quit();
		

	}

}
