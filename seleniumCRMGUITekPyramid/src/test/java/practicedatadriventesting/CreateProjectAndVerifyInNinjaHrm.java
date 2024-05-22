package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyInNinjaHrm {

	public static void main(String[] args) throws SQLException {
		
		// Create a project with selenium GUI
		String projectName = "twitter_1";
		boolean flag=false;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://106.51.90.215:8084/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("Balaji");
		WebElement dropdwon = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		Select select=new Select(dropdwon);
		select.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		// Verify the same project name in db
		// load/register the driver
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		
		// connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		
		// Create sql statement
		Statement stat = conn.createStatement();
		
		// Execute select query
		ResultSet resultset = stat.executeQuery("select * from project");
		while(resultset.next()) {
			String actdata = resultset.getString(4);
			if(projectName.equals(actdata)) {
				flag=true;
				System.out.println(projectName +" is present in DB==> PASS");
			}
		}
		if(flag=false) {
			System.out.println(projectName +" is not present in DB==> FAIL");
		}
		
		// Close the connection
		conn.close();
		
	}

}
