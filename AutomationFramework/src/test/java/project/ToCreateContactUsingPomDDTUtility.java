package project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class ToCreateContactUsingPomDDTUtility {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		wutil.maximizeBrowser(driver);
		wutil.waitForElements(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.getUserNameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContact().click();

		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastName().sendKeys(LASTNAME);
		ccp.getSaveButton().click();
		
		ContactInformationPage cip=new ContactInformationPage(driver);
		String lastname = cip.getContactInfo().getText();
		if(lastname.contains(LASTNAME)) {
			System.out.println(lastname + " passed ");
		}else {
			System.out.println(lastname + " failed ");
		}
		
		WebElement logout = hp.getAdministrator();
		wutil.toMouseHover(driver, logout);
		hp.getAdministrator().click();
		hp.getSignOutButton().click();
			
				
	}
}
