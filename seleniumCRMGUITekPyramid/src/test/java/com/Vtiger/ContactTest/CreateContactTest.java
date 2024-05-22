package com.Vtiger.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.ObjectRepository.ContactInformationPage;
import com.vtiger.ObjectRepository.ContactPage;
import com.vtiger.ObjectRepository.CreateContactPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import com.vtiger.baseClassutility.BaseClass;
import com.vtiger.generic.fileutility.ExcelFileUtility;
import com.vtiger.generic.fileutility.PropertyFileUtility;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.UtilityClassObject;
import com.vtiger.generic.webdriverutility.WebDriverUtility;
import com.vtiger.listenerutility.ListenerImplementationClass;

public class CreateContactTest extends BaseClass {

	@Test
	public void toCreateContact() throws Throwable {

//		// Create an object of property file and excel file
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
		UtilityClassObject.getTest().log(Status.INFO, "to read the data from Excel file");
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

		// login the application
//		LoginPage lp=new LoginPage(driver);
//		lp.getUserNameTextField().sendKeys(USERNAME);
//		lp.getPasswordTextField().sendKeys(PASSWORD);
//		lp.getLoginButton().click();
//		System.out.println("Login to the application sucessfully");

		
		// click on the contact link
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on the contacts link is done");
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();

		// click on the contact look up image
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on the lookup image successfully");
		ContactPage cp=new ContactPage(driver);
		cp.getContactLookUpImage().click();

		// enter the lastname in the textfield
		UtilityClassObject.getTest().log(Status.PASS, "Contact Created sucessfully");
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastNameTextField().sendKeys(LASTNAME);

		// click on save button
		UtilityClassObject.getTest().log(Status.PASS, "Contact saved successfully");
		ccp.getSaveButton().click();
		
		// verify the header message
		ContactInformationPage cip=new ContactInformationPage(driver);
		String actlastname = cip.getContactInformationPage().getText();
		Assert.assertTrue(actlastname.contains(LASTNAME));
		//Assert.fail();
		
		
		

//		// move to administrator icon
//		WebElement logoutbutton = hp.getAdministrator();
//		wutil.toMouseHover(driver, logoutbutton);
//		


//		// click on logout button
//		hp.getSignOutButton().click();
//		driver.quit();

	}

}
