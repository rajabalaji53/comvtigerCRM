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
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationWithIndustryTypeDropDown extends BaseClass {
	
	@Test
	public void toCreateContactWithIndustry() throws Throwable {

//		// To Create an object of file and excel utility
//		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
//		
//
//		String BROWSER = putil.ToReadDataFromPropertyFile("browser");
//		String URL = putil.ToReadDataFromPropertyFile("url");
//		String USERNAME = putil.ToReadDataFromPropertyFile("username");
//		String PASSWORD = putil.ToReadDataFromPropertyFile("password");


		// To Read the data from the excel file
		
		String ORGNAME = eutil.ToReadDataFromExcelFile("org", 1, 2).toString()+jutil.getRandomNumber();
		String IndustryDrop = eutil.ToReadDataFromExcelFile("org", 4, 3).toString();
		String Typedrop = eutil.ToReadDataFromExcelFile("org", 4, 4).toString();
//
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
		System.out.println("Organisation name entered successfully");
		Thread.sleep(2000);
		
		// To work on the industry drop down
		WebElement industry = cop.getIndustryDropdown();
		wutil.toHandleDropDown(IndustryDrop, industry);
		
//		Select sel1=new Select(industry);
//		sel1.selectByVisibleText(IndustryDrop);
		
		// To work on type industry drop down
		
		WebElement type = cop.getTypeDropDown();
		wutil.toHandleDropDown(Typedrop, type);
		
//		Select sel2=new Select(type);
//		sel2.selectByVisibleText(Typedrop);
		

		// click on save button
		cop.getSaveButton().click();
		System.out.println("Organization name along with industry and type created sucessfully");
		

		// verify the industry drop down name
		String indusver = driver.findElement(By.id("dtlview_Industry")).getText();
		if(indusver.equals(IndustryDrop)) {
			System.out.println(IndustryDrop + "information is verified==>pass");
		}else {
			System.out.println(IndustryDrop + "information is not verified==>Fail");
		}

		// Verify the Type drop down
		String typver = driver.findElement(By.id("dtlview_Type")).getText();
		if (typver.equals(Typedrop)) {
			System.out.println(Typedrop + " information is verified==>pass");
		} else {
			System.out.println(Typedrop + " information is not verified==>Fail");

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
