package project;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToWorkOnParentChildBrowserInContactLink {

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
				
				// Step 3 :- To click on contacts
				driver.findElement(By.linkText("Contacts")).click();
				
				// Step 4 :- To click on create account image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				// Step 5:- To enter the data in the mandatory field
				driver.findElement(By.name("lastname")).sendKeys("Balaji SVRB");
				
				
				// Step 6:- To select organization lookup and work on window ids
				String ParentID = driver.getWindowHandle();
				driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
				Set<String> allWindowId = driver.getWindowHandles();
				allWindowId.remove(ParentID);
				for(String windowId:allWindowId) {
					driver.switchTo().window(windowId);
				}
				driver.findElement(By.linkText("vtiger")).click();
				driver.switchTo().window(ParentID);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				// Step 7:- To verify the created contact
				String contactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(contactName.contains("Balaji SV")) {
					System.out.println("Contact creation done");
				}else {
					System.out.println("Contact creation failed");
				}
				
				// Step 8:- To logout the application
				WebElement logoutButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions action=new Actions(driver);
				action.moveToElement(logoutButton).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				
				// Step 9:- To close the browser
				driver.quit();
				
	}

}
