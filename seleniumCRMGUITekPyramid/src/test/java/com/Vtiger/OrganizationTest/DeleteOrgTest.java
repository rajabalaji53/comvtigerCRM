package com.Vtiger.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.ObjectRepository.CreateOrganizationPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import com.vtiger.ObjectRepository.OrganizationPage;
import com.vtiger.baseClassutility.BaseClass;
import com.vtiger.generic.fileutility.ExcelFileUtility;
import com.vtiger.generic.fileutility.PropertyFileUtility;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class DeleteOrgTest extends BaseClass {
	
	@Test
	public void toDeleteOrg() throws Throwable {

//		// Create an object of property and excel file
//		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility wutil = new WebDriverUtility();
//
//		String BROWSER = putil.ToReadDataFromPropertyFile("browser");
//		String URL = putil.ToReadDataFromPropertyFile("url");
//		String USERNAME = putil.ToReadDataFromPropertyFile("username");
//		String PASSWORD = putil.ToReadDataFromPropertyFile("password");

		// To Read the data from the excel file
		String ORGNAME = eutil.ToReadDataFromExcelFile("org", 10, 2) + jutil.getRandomNumber();
		String ORGDDNAME = eutil.ToReadDataFromExcelFile("org", 10, 3);

//		WebDriver driver = null;
//		if (BROWSER.contains("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.contains("edge")) {
//			driver = new EdgeDriver();
//		} else if (BROWSER.contains("firefox")) {
//			driver = new FirefoxDriver();
//		}
//
//		// navigate to the application
//		driver.get(URL);
//		System.out.println("Url got launched successfully");
//		wutil.maximizeBrowser(driver);
//		System.out.println("Browser maximized successfully");
//		wutil.waitForPageToLoad(driver);
//
//		// login the application
//		LoginPage lp = new LoginPage(driver);
//
//		lp.getUserNameTextField().sendKeys(USERNAME);
//		lp.getPasswordTextField().sendKeys(PASSWORD);
//		lp.getLoginButton().click();
//		System.out.println("Login to the application sucessfully");

		// click on the organization link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		System.out.println("Clicked on Organization link successfully");

		// click on the organization look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationLookUpImage().click();

		// enter the organization name from excel file
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getOrganizationName().sendKeys(ORGNAME);
		
		// click on save button
		cop.getSaveButton().click();
		System.out.println("Clicked on save button successfully");
		
		// Again click on organization link
		Thread.sleep(2000);
		hp.getOrganizationLink().click();
		System.out.println("Clicked on organization link successfully");
		
		// click on the search textfield
		cop.getSearchBarTextField().sendKeys(ORGNAME);
		cop.getSearchInDropDown().sendKeys(ORGDDNAME);
		cop.getSearchNowButton().click();
		System.out.println("Searched for the entered organization name");
		
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']/../../td[8]/a[text()='del']")).click();
		
		// to handle alert
		wutil.toSwitchToAlertAndAcceptIt(driver);
		
		// to move to logout button
		WebElement logoutbutton = hp.getAdministrator();
		wutil.toMouseHover(driver, logoutbutton);
		
		// to click on sign out
		hp.getSignOutButton().click();
		driver.quit();

	}

}
