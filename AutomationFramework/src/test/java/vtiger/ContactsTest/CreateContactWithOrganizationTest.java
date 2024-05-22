package vtiger.ContactsTest;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateContactPageWithOrganization;
import vtiger.ObjectRepository.HomePage;

@Listeners(genericUtility.ListnersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test
	public void createContactWithOrganization() throws IOException {

//		// Step 1:- To create object of all utilities
//		WebDriverUtility wutil = new WebDriverUtility();
//		PropertyFileUtility putil = new PropertyFileUtility();
//		ExcelFileUtility eutil = new ExcelFileUtility();
//		
//		// Step 2:- To read common data from the property file
//		String URL = putil.toReadDataFromPropertyFile("url");
//		String BROWSER = putil.toReadDataFromPropertyFile("browser");
//		String USERNAME = putil.toReadDataFromPropertyFile("username");
//		String PASSWORD = putil.toReadDataFromPropertyFile("password");
//
//		// Step 3:- To read the data from the excel file
//		String lastname = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
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
//		// Step 5:- To login the application
//		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameTextField().sendKeys(USERNAME);
//		lp.getPasswordTextField().sendKeys(PASSWORD);
//		lp.getLoginButton().click();

		// Step 6:- Click on the contacts link in the home page
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		Reporter.log("Clicked on contacts link successfully", true);

		// Steps 7:- Click on create contact lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		Reporter.log("Clicked on contact lookup image", true);

		// Step 8:-To read data from excel file
		CreateContactPage ccp = new CreateContactPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String lastname = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		ccp.getLastName().sendKeys(lastname);
		ccp.getContactWithOrganization().click();
		
		// Step 9:- To Click on organization in contact page and select the account name 
		CreateContactPageWithOrganization ccpo=new CreateContactPageWithOrganization(driver);
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.toSwitchWindow(driver, "Accounts");
		ccpo.getAcccountsAction().click();
		wutil.toSwitchWindow(driver, "Contacts");
		
		// Step 10:- To click on save button
		ccp.getSaveButton().click();
		Reporter.log("Clicked on save button", true);

		// step 11:- Validation steps
		ContactInformationPage cip = new ContactInformationPage(driver);
		String name = cip.getContactInfo().getText();
		if (name.contains(lastname)) {
			System.out.println(name + " passed ");
		} else {
			System.out.println(name + " failed ");
		}

//		// Step 12:- To perform logout
//		WebElement logout = hp.getAdministrator();
//		wutil.toMouseHover(driver, logout);
//		hp.getAdministrator().click();
//		hp.getSignOutButton().click();

	}
}
