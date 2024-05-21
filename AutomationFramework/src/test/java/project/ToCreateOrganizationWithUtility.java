package project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class ToCreateOrganizationWithUtility {

	public static void main(String[] args) throws IOException {

		WebDriverUtility wutil = new WebDriverUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtility jutil = new JavaUtility();

		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		wutil.maximizeBrowser(driver);
		wutil.waitForElements(driver);
		driver.get(URL);

		// Step 2:- To login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 3:- To Navigate Organization link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 4:- To click on Organization Lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		// Step 5:- To generate random Numbers
		int randomNumber = jutil.toCreateRandomNumber();
		
		String orgName = eutil.toReadDataFromExcelFile("Organization", 1, 2);
		driver.findElement(By.name("accountname")).sendKeys(orgName + randomNumber);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		// Step 6:- To verify the created organizations
		String organizationName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(organizationName.contains(orgName+randomNumber)) {
			System.out.println("Organization name created successfully");
		}else {
			System.out.println("Organization name creation failed");
		}
		
		// Step 7:- To Logout Application
		WebElement logoutButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.toMouseHover(driver, logoutButton);
		driver.findElement(By.linkText("Sign Out")).click();
		
		// Step 8:- To close the browser
		driver.quit();

	}

}
