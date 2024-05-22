package vtigerContactTest;

import java.io.FileInputStream;
import java.io.IOException;
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

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {

		// To Read the data from the property file
		FileInputStream fis = new FileInputStream("C:\\Users\\rajak\\Desktop\\commondatas.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");

//		// To Create a Random Number
//		Random random = new Random();
//		int randomint = random.nextInt(1000);

		// To Read the data from the excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\rajak\\OneDrive\\RB\\vtigerTestScript.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		String LASTNAME = workbook.getSheet("contact").getRow(1).getCell(2).toString();

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

		// click on the contact link
		driver.findElement(By.linkText("Contacts")).click();

		// click on the contact look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		// enter the lastname in the textfield
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// verify the header message
		String actlastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actlastname.contains(LASTNAME)) {
			System.out.println(LASTNAME + " is created ==> pass");
		}else {
			System.out.println(LASTNAME +" is not created ==> Fail");

		}
		
		

		// move to administrator icon
		WebElement logoutbutton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutbutton).perform();
		// Thread.sleep(3000);

		// click on logout button
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
//		System.out.println("Closed successfully");
//		driver.close();
		

	}

}
