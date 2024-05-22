package com.Vtiger.ContactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.ObjectRepository.ContactInformationPage;
import com.vtiger.ObjectRepository.ContactPage;
import com.vtiger.ObjectRepository.CreateContactPage;
import com.vtiger.ObjectRepository.CreateContactWithOrganization;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import com.vtiger.baseClassutility.BaseClass;
import com.vtiger.generic.fileutility.ExcelFileUtility;
import com.vtiger.generic.fileutility.PropertyFileUtility;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test
	public void toCreateContactWithOrganization() throws Throwable {


//		// Create an object of file and excel utility and java utility
//		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
//
//		String BROWSER = putil.ToReadDataFromPropertyFile("browser");
//		String URL = putil.ToReadDataFromPropertyFile("url");
//		String USERNAME = putil.ToReadDataFromPropertyFile("username");
//		String PASSWORD = putil.ToReadDataFromPropertyFile("password");


		// To Read the data from the excel file
		String LASTNAME = eutil.ToReadDataFromExcelFile("contact", 7, 2)+jutil.getRandomNumber();

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
//		LoginPage lp=new LoginPage(driver);
//		lp.getUserNameTextField().sendKeys(USERNAME);
//		lp.getPasswordTextField().sendKeys(PASSWORD);
//		lp.getLoginButton().click();
//		System.out.println("Login to the application sucessfully");

		// click on the contact link
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();

		// click on the contact look up image
		ContactPage cp=new ContactPage(driver);
		cp.getContactLookUpImage().click();
		
		// enter the lastname in the textfield
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastNameTextField().sendKeys(LASTNAME);
		String parentid = driver.getWindowHandle();
		
		// Click on the organization lookup image
		ccp.getContactWithOrganizationLookUp().click();
		
		wutil.switchToWindow(driver, parentid);
		
//		Set<String> allids = driver.getWindowHandles();
//		allids.remove(parentid);
//		for(String s:allids) {
//			driver.switchTo().window(s);
//			String childTilte = driver.getTitle();
//			if(childTilte.contains("Accounts")) {
//				break;
//			}
//		}
		CreateContactWithOrganization cco=new CreateContactWithOrganization(driver);
		cco.getAcccountsAction().click();
		driver.switchTo().window(parentid);
		
		// click on save button
		ccp.getSaveButton().click();
		
		// verify the header message
		ContactInformationPage cip=new ContactInformationPage(driver);
		String actlastname = cip.getContactInformationPage().getText();
		//Assert.assertTrue(actlastname.contains(LASTNAME));
		Assert.fail();
		
		
//		// move to administrator icon
//		WebElement logoutbutton = hp.getAdministrator();
//		wutil.toMouseHover(driver, logoutbutton);
//
//		// click on logout button
//		hp.getSignOutButton().click();
//		driver.quit();


	}

}
