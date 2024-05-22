package dataProviderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.generic.fileutility.ExcelFileUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class ToLearnDataProviderInEcommerceTest {

	@Test(dataProvider = "getData")
	public void getProductRate(String brandname, String Productname) {
		WebDriver driver = new ChromeDriver();

		WebDriverUtility wutil = new WebDriverUtility();
		wutil.maximizeBrowser(driver);
		wutil.waitForPageToLoad(driver);

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys(brandname, Keys.ENTER);

		// capture the product rate
		String path = "(//a[text()='"+Productname+"'])[1]/../a[2]/div/div[1]";
		String price = driver.findElement(By.xpath(path)).getText();
		System.out.println(price);

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable {

		ExcelFileUtility eutil = new ExcelFileUtility();
		int rowCount = eutil.ToGetRowCount("product");
		System.out.println(rowCount);

		Object[][] obj = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {

			obj[i][0] = eutil.ToReadDataFromExcelFile("product",i+1, 0);
			obj[i][1] = eutil.ToReadDataFromExcelFile("product", i+1, 1);
		}

		return obj;
	}

}



