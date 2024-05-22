package extentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.baseClassutility.BaseClass;
import com.vtiger.listenerutility.ListenerImplementationClass;

@Listeners(com.vtiger.listenerutility.ListenerImplementationClass.class)
public class SampleExtentReportTest extends BaseClass {

	ExtentReports report;

	
	
	@Test
	public void toCreateContact() {

		ExtentTest test = report.createTest("toCreateContact");

		test.log(Status.INFO, "Login to the application");
		test.log(Status.INFO, "Navigated to contact Page");
		test.log(Status.INFO, "Contact is created");
		if ("VTIGERCRM".equals("VTIGERCRMhh")) {
			test.log(Status.PASS, "Contact is created successfully");
		} else {
			test.log(Status.FAIL, "Contact is not created successfully");
		}
		test.log(Status.INFO, "Logout of the application");
	}

//	@Test
//	public void toCreateOrganization() {
//		
//		ExtentTest test = report.createTest("toCreateOrganization");
//		
//		test.log(Status.INFO, "Login to the application");
//		test.log(Status.INFO, "Navigated to organization Page");
//		test.log(Status.INFO, "Organization is created");
//		if ("VTIGERCRM".equals("VTIGERCRM")) {
//			test.log(Status.PASS, "Organization is created successfully");
//		} else {
//			test.log(Status.FAIL, "Organization is not created successfully");
//		}
//		test.log(Status.INFO, "Logout of the application");
//	}
//
//	@Test
//	public void toCreateOrganizationWithPhoneNumber() {
//		ExtentTest test = report.createTest("toCreateOrganizationWithPhoneNumber");
//		
//		test.log(Status.INFO, "Login to the application");
//		test.log(Status.INFO, "Navigated to Organization Page");
//		test.log(Status.INFO, "OrganizationwithContact is created");
//		if ("VTIGERCRM".equals("VTIGERCRM")) {
//			test.log(Status.PASS, "OrganizationwithContact is created successfully");
//		} else {
//			test.log(Status.FAIL, "OrganizationwithContact is not created successfully");
//		}
//		test.log(Status.INFO, "Logout of the application");
//	}

}
