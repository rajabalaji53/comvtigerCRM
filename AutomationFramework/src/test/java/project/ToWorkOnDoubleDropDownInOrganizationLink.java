package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToWorkOnDoubleDropDownInOrganizationLink {

	public static void main(String[] args) {

		// Step 1 :- To Launch the browser
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("http://localhost:8888/");
				
				
				// Step 2:- To login to the application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("password");
				driver.findElement(By.id("submitButton")).click();
				
				// Step 3:- To Navigate Organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				// Step 4:- To click on Organization Lookup image
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				// Step 5:- To enter the data with mandatory field
				driver.findElement(By.name("accountname")).sendKeys("Qspiders OAR2");
				
				
				
				// Step 6:- To Select "Chemicals in industry dropdown"
				 WebElement industryDropDown = driver.findElement(By.name("industry"));
				 Select select=new Select(industryDropDown);
				 select.selectByIndex(10);
				 WebElement typeDropDown = driver.findElement(By.name("accounttype"));
				 Select select1 =new Select(typeDropDown);
				 select1.selectByIndex(3);
				 driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
				
				
				
				// Step 7:- To verify the created organizations
				String organizationName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(organizationName.contains("Qspiders OAR")) {
					System.out.println("Organization name created successfully");
				}else {
					System.out.println("Organization name creation failed");
				}
				
				// Step 8:- To Logout Application
				WebElement logoutButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions action=new Actions(driver);
				action.moveToElement(logoutButton).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				
				// Step 9:- To close the browser
				driver.quit();
	}

}
