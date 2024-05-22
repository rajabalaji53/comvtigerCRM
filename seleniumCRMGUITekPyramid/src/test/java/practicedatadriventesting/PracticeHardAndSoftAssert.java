package practicedatadriventesting;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeHardAndSoftAssert {
	
	@Test
	public void toVerifyHomepage(Method mtd) {
		System.out.println(mtd.getName()+"Test Starts");
		SoftAssert sa=new SoftAssert();
		
		String ExpectedName="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		Assert.assertEquals("Home-1", "Home");
		driver.findElement(By.linkText("Contacts")).click();
		driver.close();
		//sa.assertAll();
		
	}
	
	@Test
	public void toVerifyHomePageLogo(Method mtd) {
		SoftAssert sa=new SoftAssert();
		
		System.out.println(mtd.getName()+ "Test Starts");
		System.out.println("Step-1");
		System.out.println("Step-2");
		sa.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		sa.assertAll();
		
	}

}
