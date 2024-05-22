package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import org.testng.xml.XmlTest;

public class ReadDataFromXmlTest {
	
	
	@Test
	public void readfromxml(XmlTest test) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		
			// Read data from json file
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:\\Users\\rajak\\Desktop\\commondata.json"));

			JSONObject map = (JSONObject) obj;

			String BROWSER = test.getParameter("browser");
			String URL = test.getParameter("url");
			String USERNAME = test.getParameter("username");
			String PASSWORD = test.getParameter("password");

			// Read data from excel file
			FileInputStream fis1 = new FileInputStream("C:\\Users\\rajak\\OneDrive\\RB\\testscript.xlsx");
			Workbook workbook = WorkbookFactory.create(fis1);
			String ORGNAME = workbook.getSheet("Org").getRow(1).getCell(2).toString();

			// random number generation
			Random random = new Random();
			int randomint = random.nextInt(1000);

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
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			// login the application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();

			// click on the organization link
			driver.findElement(By.linkText("Organizations")).click();

			// click on the organization look up image
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

			// enter the organization name from excel file
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME + randomint);

			// click on save button
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
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
