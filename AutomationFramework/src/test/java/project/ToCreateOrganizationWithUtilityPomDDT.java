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

public class ToCreateOrganizationWithUtilityPomDDT {

	public static void main(String[] args) throws IOException {

		// Step 1:- Create object of all the utility classes
		WebDriverUtility wutil=new WebDriverUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
		
		// Step 2:- Read the common data from property file
		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		// Step 3:- To Read data from excel file
		String ORGNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2);
		
		// Step 4:- To launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		wutil.maximizeBrowser(driver);
		wutil.waitForElements(driver);
		driver.get(URL);
		
		// Step 5:- To perform login action
		LoginPage lp=new LoginPage(driver);
		lp.getUserNameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		
		// Step 6:- To click on organization link home page
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();
		
		// Step 7:- To click on Organization look up image
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganization().click();
		
		// Step 8:- To generate random numbers
		int random = jutil.toCreateRandomNumber();
		
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.getOrgName().sendKeys(ORGNAME+random);
		cop.getSaveButton().click();
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String organizationName = oip.getOrganizationInfo().getText();
		if(organizationName.contains(ORGNAME+random)) {
			System.out.println(organizationName + " passed ");
		}else {
			System.out.println(organizationName + " Failed ");
		} 
		WebElement logoutButton = hp.getAdministrator();
		wutil.toMouseHover(driver, logoutButton);
		hp.getAdministrator().click();
		hp.getSignOutButton().click();
		
		
	}

}
