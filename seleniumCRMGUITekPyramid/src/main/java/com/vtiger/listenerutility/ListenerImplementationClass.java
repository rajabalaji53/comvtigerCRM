package com.vtiger.listenerutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.baseClassutility.BaseClass;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {
	
	public ExtentReports report;
	public ExtentSparkReporter htmlreport;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");

		// Spark Report Configuration
		JavaUtility jutil=new JavaUtility();
		htmlreport = new ExtentSparkReporter("./extentReports/report" +jutil.SystemDateAndTime()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Application Result");
		htmlreport.config().setReportName("Vtiger Report");
		htmlreport.config().setTheme(Theme.DARK);

		// Add Environment information
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println("====>" + methodname + "=====> START====>");
		test= report.createTest(methodname);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, "===>Start");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===>" + result.getMethod().getMethodName() + "====>END====>");
		test.log(Status.INFO, result.getMethod().getMethodName()+" ==>Completed<== ");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
//		JavaUtility jutil = new JavaUtility();
//		String sysDate = jutil.SystemDateAndTime();
		test.addScreenCaptureFromBase64String(temp,testname);
		
		//File temp = new File("./screenshots/" + testname + " " + sysDate + ".jpeg");
//		try {
//			FileUtils.copyFile(src, temp);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		test.log(Status.FAIL, result.getMethod().getMethodName()+" ==>Failed<== ");


	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
