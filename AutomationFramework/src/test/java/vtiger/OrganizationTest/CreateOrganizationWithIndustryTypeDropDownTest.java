package vtiger.OrganizationTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryTypeDropDownTest extends BaseClass {

	@Test
	public void toCreateorganizationWithIndustryTyoeDropDown_003() throws IOException {

//		// Step 1:- Create a object of all utilities
//		WebDriverUtility wutil = new WebDriverUtility();
//		PropertyFileUtility putil = new PropertyFileUtility();
//		ExcelFileUtility eutil = new ExcelFileUtility();
//		JavaUtility jutil = new JavaUtility();
//
//		// Step 2:- To read the Common data from the property file
//		String URL = putil.toReadDataFromPropertyFile("url");
//		String BROWSER = putil.toReadDataFromPropertyFile("browser");
//		String USERNAME = putil.toReadDataFromPropertyFile("username");
//		String PASSWORD = putil.toReadDataFromPropertyFile("password");
//
//		// Step 3:- To read the data from the excel file
//		String ORGNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2);
//
//		// Step 4:- To launch and maximize the browser
//		WebDriver driver = null;
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		}
//
//		wutil.maximizeBrowser(driver);
//		wutil.waitForElements(driver);
//
//		// Step 5:- Launch the url from property file
//		driver.get(URL);
//
//		// Step 6:- Enter the details of the login page
//		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameTextField().sendKeys(USERNAME);
//		lp.getPasswordTextField().sendKeys(PASSWORD);
//		lp.getLoginButton().click();

		// Step 7:- Click on the organization link in the home page
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		// Step 8:- To click on the organization look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganization().click();

		// Step 9:- To create a random number using java utility
		JavaUtility jutil=new JavaUtility();
		int random = jutil.toCreateRandomNumber();

		// Step 10:- Enter the organization name with random numbers
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String ORGNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2);
		cop.getOrgName().sendKeys(ORGNAME + random);

		// Step 11:- To handle Industry drop down
		WebElement indDropDown = cop.getIndustryDropDown();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.toHandleDropDown(indDropDown, 10);

		// Step 12:- To handle type drop down
		WebElement typeDrop = cop.getTypeDropDown();
		wutil.toHandleDropDown(typeDrop, 3);

		// Step 13:- To click on save button
		cop.getSaveButton().click();

		// Step 14:- Verify the organization name
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String organizationName = oip.getOrganizationInfo().getText();
		if (organizationName.contains(ORGNAME + random)) {
			System.out.println(organizationName + " passed ");
		} else {
			System.out.println(organizationName + " Failed ");
		}
//
//		// Step 15:- To perform Logout action
//		WebElement logoutButton = hp.getAdministrator();
//		wutil.toMouseHover(driver, logoutButton);
//		hp.getAdministrator().click();
//		hp.getSignOutButton().click();
//		
//		// Step 16:- To Quit
//		driver.quit();
	}

}
