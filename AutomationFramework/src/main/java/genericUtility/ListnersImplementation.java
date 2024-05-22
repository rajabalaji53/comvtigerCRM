package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-- Start");
		test = report.createTest(methodname);
		test.log(Status.PASS, "--start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--Sucesss");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-- Failed");
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String screenshotname = methodname+"-"+jutil.toGetSystemDateAndTime();
		try {
			String path = wutil.toTakesScreenShot(BaseClass.sDriver, screenshotname);
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL, "--Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-- Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution starts");
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtendReports/Report-"+new JavaUtility().toGetSystemDateAndTime()+".html");
		htmlreport.config().setDocumentTitle("VTIGER EXECUTION REPORTS");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTIGER REPORTS");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("BaseUrl", "http://localhost:8888");
		report.setSystemInfo("BaseBrowser", "chrome");
		report.setSystemInfo("ReporterName", "Raja Balaji");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
		report.flush();
	}

	
}
