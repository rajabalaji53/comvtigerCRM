package genericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {

	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	ExcelFileUtility eutil = new ExcelFileUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite(groups= {"smoke","regression"})
	public void beforeSuiteConfiguration() {
		Reporter.log("Database Connection Established", true);
	}

	//@Parameters("browser")	// only used when user want to perform cross browser testing
	//@BeforeTest
  	@BeforeClass(groups={"smoke","regression"})
	public void beforeClassConfiguration(/*String BROWSER*/) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver;

		wutil.maximizeBrowser(driver);
		wutil.waitForElements(driver);
		driver.get(URL);

	}

	@BeforeMethod(groups={"smoke","regression"})
	public void beforeMethodConfiguration() throws EncryptedDocumentException, IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
	}

	@AfterMethod(groups={"smoke","regression"})
	public void afterMethodConfiguration() {
		HomePage hp = new HomePage(driver);
		wutil.toMouseHover(driver, hp.getAdministrator());
		hp.getSignOutButton().click();
	}

	@AfterClass(groups={"smoke","regression"})
	public void afterClassConfiguration() {
		driver.quit();
	}

}
