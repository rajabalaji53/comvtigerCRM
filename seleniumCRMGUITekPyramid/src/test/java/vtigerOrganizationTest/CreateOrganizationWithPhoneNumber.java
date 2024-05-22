package vtigerOrganizationTest;

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

public class CreateOrganizationWithPhoneNumber {

	public static void main(String[] args) throws Throwable {


		// To Read the data from the property file
		FileInputStream fis = new FileInputStream("C:\\Users\\rajak\\Desktop\\commondatas.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");

		// To Create a Random Number
		Random random = new Random();
		int randomint = random.nextInt(1000);

		// To Read the data from the excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\rajak\\OneDrive\\RB\\vtigerTestScript.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		String ORGNAME = workbook.getSheet("org").getRow(1).getCell(2).toString()+randomint;
		String PHONENUM = workbook.getSheet("org").getRow(7).getCell(3).getStringCellValue();

		WebDriver driver = null;
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}

		// navigate to the application
		driver.get(URL);
		System.out.println("Url got launched successfully");
		driver.manage().window().maximize();
		System.out.println("Browser maximized successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// login the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login to the application sucessfully");

		// click on the organization link
		driver.findElement(By.linkText("Organizations")).click();

		// click on the organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// enter the organization name from excel file
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		// enter the phone number
		driver.findElement(By.id("phone")).sendKeys(PHONENUM);

		// click on save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		// verify the phone number to expected condition
		String contact = driver.findElement(By.id("dtlview_Phone")).getText();
		if(contact.equals(PHONENUM)) {
			System.out.println(PHONENUM +"is created successfully==> pass");
		}else {
			System.out.println(PHONENUM + " is not created successfully==>Fail");
		}
		Thread.sleep(3000);

		// move to administrator icon
		WebElement logoutbutton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutbutton).perform();
		// Thread.sleep(3000);

		// click on logout button
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}
