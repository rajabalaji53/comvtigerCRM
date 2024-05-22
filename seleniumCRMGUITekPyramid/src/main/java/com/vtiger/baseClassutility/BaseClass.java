package com.vtiger.baseClassutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import com.vtiger.generic.databaseutility.DataBaseUtility;
import com.vtiger.generic.fileutility.ExcelFileUtility;
import com.vtiger.generic.fileutility.PropertyFileUtility;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.UtilityClassObject;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

@Listeners(com.vtiger.listenerutility.ListenerImplementationClass.class)
public class BaseClass {
	
	public ExtentTest test;
	public WebDriver driver=null;
	public static WebDriver sdriver;
	DataBaseUtility dutil=new DataBaseUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	JavaUtility jutil=new JavaUtility();

	@BeforeSuite
	public void databaseConnectivity() throws Throwable {
		System.out.println("Connected to database Successfully");
		dutil.ToGetDataBaseConnection();
	}
	
	//@Parameters("BROWSER")
	@BeforeClass
	public void launchTheBrowser(/*String bname*/) throws Throwable {
		
		String BROWSER = putil.ToReadDataFromPropertyFile("browser");
		//bname
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
		System.out.println("Launched the browser successfully");
		wutil.maximizeBrowser(driver);
		System.out.println("Browser maximized successfully");
		wutil.waitForPageToLoad(driver);
	}
	
	@BeforeMethod
	public void toLogin() throws Throwable {
		String URL = putil.ToReadDataFromPropertyFile("url");
		String USERNAME = putil.ToReadDataFromPropertyFile("username");
		String PASSWORD = putil.ToReadDataFromPropertyFile("password");
		
		driver.get(URL);
		System.out.println("URL launched successfully");
		LoginPage lp=new LoginPage(driver);
		lp.getUserNameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		System.out.println("Login to the application successfully");
	}
	
	@AfterMethod
	public void toLogout() {
		HomePage hp=new HomePage(driver);
		wutil.toMouseHover(driver, hp.getAdministrator());
		hp.getSignOutButton().click();
		System.out.println("Logged out the application successfully");
	}
	
	@AfterClass
	public void toCloseBrowser() {
		driver.quit();
		System.out.println("Browser closed successfully");
	}
	
	@AfterSuite
	public void closeDatabaseConnectivity() {
		dutil.CloseDbConnection();
		System.out.println("Database connection closed successfully");
	}
	
	

}
