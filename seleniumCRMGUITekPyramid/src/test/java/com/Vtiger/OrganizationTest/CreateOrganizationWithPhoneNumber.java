package com.Vtiger.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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

public class CreateOrganizationWithPhoneNumber extends BaseClass {

	@Test
	public void toCreateOrganizationWithPhone() throws Throwable {

//
//		// To Create an object of property and excel file
//		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
//		WebDriverUtility wutil=new WebDriverUtility();
//
//		String BROWSER = putil.ToReadDataFromPropertyFile("browser");
//		String URL = putil.ToReadDataFromPropertyFile("url");
//		String USERNAME = putil.ToReadDataFromPropertyFile("username");
//		String PASSWORD = putil.ToReadDataFromPropertyFile("password");

		// To Read the data from the excel file
		String ORGNAME = eutil.ToReadDataFromExcelFile("org", 1, 2).toString()+jutil.getRandomNumber();
		String PHONENUM = eutil.ToReadDataFromExcelFile("org", 7, 3).toString();

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

		// click on the organization link
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();

		// click on the organization look up image
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrganizationLookUpImage().click();

		// enter the organization name from excel file
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.getOrganizationName().sendKeys(ORGNAME);
		
		// enter the phone number
		cop.getPhoneNumberTextField().sendKeys(PHONENUM);

		// click on save button
		cop.getSaveButton().click();
		
		// verify the phone number to expected condition
		String contact = driver.findElement(By.id("dtlview_Phone")).getText();
		if(contact.equals(PHONENUM)) {
			System.out.println(PHONENUM +"is created successfully==> pass");
		}else {
			System.out.println(PHONENUM + " is not created successfully==>Fail");
		}
		Thread.sleep(3000);

//		// move to administrator icon
//		WebElement logoutbutton = hp.getAdministrator();
//		wutil.toMouseHover(driver, logoutbutton);
//
//		// click on logout button
//		hp.getSignOutButton().click();
//		driver.quit();
	}

}
