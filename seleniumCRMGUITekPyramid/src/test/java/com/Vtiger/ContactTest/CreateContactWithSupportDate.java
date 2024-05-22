package com.Vtiger.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import com.vtiger.baseClassutility.BaseClass;
import com.vtiger.generic.fileutility.ExcelFileUtility;
import com.vtiger.generic.fileutility.PropertyFileUtility;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDate extends BaseClass{

	@Test
	public void toCreateContactWithSupportDate() throws Throwable {
		
//		// Create an object of file and excel utility
//		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
//		WebDriverUtility wutil=new WebDriverUtility();
//
//		String BROWSER = putil.ToReadDataFromPropertyFile("browser");
//		String URL = putil.ToReadDataFromPropertyFile("url");
//		String USERNAME = putil.ToReadDataFromPropertyFile("username");
//		String PASSWORD =putil.ToReadDataFromPropertyFile("password");

		// To Read the data from the excel file
		String LASTNAME = eutil.ToReadDataFromExcelFile("contact", 1, 2)+jutil.getRandomNumber();

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
		String startingDate=jutil.toGetSystemDateYYYYDDMM();
		String endingDate = jutil.getEndDateYYYYDDMM(30);
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastNameTextField().sendKeys(LASTNAME);
		
		// Locate the start date
		WebElement startDate = ccp.getSupportStartDate();
		startDate.clear();
		startDate.sendKeys(startingDate);
		
		// Locate the end date
		WebElement endDate = ccp.getSupportEndDate();
		endDate.clear();
		endDate.sendKeys(endingDate);

		// click on save button
		ccp.getSaveButton().click();

		// verify the start date
		ContactInformationPage cip=new ContactInformationPage(driver);
		String actstartdate = cip.getStartDate().getText();
		Assert.assertEquals(startingDate, actstartdate);
		
		
		// verify the end date
		String actenddate = cip.getEndDate().getText();
		Assert.assertEquals(endingDate, actenddate);
		

//		// move to administrator icon
//		WebElement logoutbutton = hp.getAdministrator();
//		wutil.toMouseHover(driver, logoutbutton);
//
//		// click on logout button
//		hp.getSignOutButton().click();
//		driver.quit();

	}

}
