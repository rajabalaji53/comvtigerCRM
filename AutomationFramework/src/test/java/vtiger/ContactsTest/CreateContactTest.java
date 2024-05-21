package vtiger.ContactsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

@Listeners(genericUtility.ListnersImplementation.class)
public class CreateContactTest extends BaseClass {
	
	
	@Test
	public void toCreateContact_001() throws IOException{

//		// Step 1:- Create object of all utilities
//		PropertyFileUtility putil = new PropertyFileUtility();
//		ExcelFileUtility eutil = new ExcelFileUtility();
//		WebDriverUtility wutil = new WebDriverUtility();
//
//		// Step 2:- To read common data from property file
//		String URL = putil.toReadDataFromPropertyFile("url");
//		String BROWSER = putil.toReadDataFromPropertyFile("browser");
//		String USERNAME = putil.toReadDataFromPropertyFile("username");
//		String PASSWORD = putil.toReadDataFromPropertyFile("password");
//
//		// Step 3:- To read data from excel file
//		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
//
//		// Step 4:- To launch the browser
//		WebDriver driver = null;
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		}
//
//		wutil.maximizeBrowser(driver);
//		wutil.waitForElements(driver);
//		driver.get(URL);
//
//		// Step 5:- To perform login action
//		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameTextField().sendKeys(USERNAME);
//		lp.getPasswordTextField().sendKeys(PASSWORD);
//		lp.getLoginButton().click();

		// Step 6:- Click on Contacts link in home page
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		Reporter.log("Click on Contacts link successfull ", true);

		// Steps 7:- Click on create contact lookup image 
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		Reporter.log("Clicked on contacts link", true);

		// Step 8:- Click on save 
		CreateContactPage ccp = new CreateContactPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String NAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		ccp.getLastName().sendKeys(NAME);
		ccp.getSaveButton().click();
		Reporter.log("Clicked on save button", true);
		//Assert.fail();

		ContactInformationPage cip = new ContactInformationPage(driver);
		String lastname = cip.getContactInfo().getText();
//		if (lastname.contains(NAME)) {
//			System.out.println(lastname + " passed ");
//		} else {
//			System.out.println(lastname + " failed ");
//		}

		Assert.assertTrue (lastname.contains(NAME)); 
		
//		WebElement logout = hp.getAdministrator();
//		wutil.toMouseHover(driver, logout);
//		hp.getAdministrator().click();
//		hp.getSignOutButton().click();

	}
}
