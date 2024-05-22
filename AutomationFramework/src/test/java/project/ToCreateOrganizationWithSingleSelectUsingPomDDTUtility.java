package project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationPage;

public class ToCreateOrganizationWithSingleSelectUsingPomDDTUtility {

	public static void main(String[] args) throws IOException {

		WebDriverUtility wutil = new WebDriverUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();

		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		String ORGNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2);

		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		wutil.maximizeBrowser(driver);
		wutil.waitForElements(driver);
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.getUserNameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganization().click();

		int random = jutil.toCreateRandomNumber();
		

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getOrgName().sendKeys(ORGNAME + random);
		
		WebElement indDropDown = cop.getIndustryDropDown();
		wutil.toHandleDropDown(indDropDown, 4);
		cop.getSaveButton().click();
		

		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String organizationName = oip.getOrganizationInfo().getText();
		if (organizationName.contains(ORGNAME + random)) {
			System.out.println(organizationName + " passed ");
		} else {
			System.out.println(organizationName + " Failed ");
		}
		WebElement logoutButton = hp.getAdministrator();
		wutil.toMouseHover(driver, logoutButton);
		hp.getAdministrator().click();
		hp.getSignOutButton().click();

	}

}
