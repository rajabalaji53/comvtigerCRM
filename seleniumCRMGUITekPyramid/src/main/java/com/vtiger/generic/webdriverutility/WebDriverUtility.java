package com.vtiger.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method will maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the browser
	 * @param driver
	 */
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait for until the page is loaded
	 */

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method will wait for until the webelement get loaded
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will select the drop down based on the index value
	 * @param element
	 * @param index
	 */
	public void toHandleDropDown(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will select dropdown based on the string value
	 * @param element
	 * @param value
	 */
	public void toHandleDropDown(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method will select dropdown based o text value
	 * @param Text
	 * @param element
	 */
	public void toHandleDropDown(String Text,WebElement element) {
		Select select =new Select(element);
		select.selectByVisibleText(Text);
	}
	/**
	 * This method will double click anywhere
	 * @param driver
	 */
	public void toDoubleClick(WebDriver driver) {
		Actions action=new Actions(driver);
		action.doubleClick().perform();
	}
	/**
	 * This method will do double click on element
	 * @param driver
	 * @param element
	 */
	public void toDoubleClickOnElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();;
	}
	/**
	 * This method will perform right click anywhere
	 * @param driver
	 */
	public void toRightClick(WebDriver driver) {
		Actions action=new Actions(driver);
		action.contextClick().perform();
	}
	/**
	 * This method will do right click on the element
	 * @param driver
	 * @param element
	 */
	public void toRightClickOnElement(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method will do mouse hover action in web element
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	

	/**
	 * This method will switch the driver control to the new tab based on partial
	 * tilte
	 */

	public void switchToWindow(WebDriver driver, String partialTitle) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			String windowTitle = driver.switchTo().window(id).getTitle();
			if (windowTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	/**
	 * This method will switch frame based on index value
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch frame based on the string name or id
	 * @param driver
	 * @param id_name
	 */
	public void toHandleFrame(WebDriver driver,String id_name) {
		driver.switchTo().frame(id_name);
	}
	
	/**
	 * This method will switch frame based on the webelement passed
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch back to the immediate parent frame
	 * @param driver
	 */
	public void toSwitchBackFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch back to main page
	 * @param driver
	 */
	public void toSwitchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch the driver control to alert popup and click on ok
	 * @param driver
	 */
	
	public void toSwitchToAlertAndAcceptIt(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will switch driver control to alert and capture the text
	 * @param driver
	 * @return
	 */
	
	public String toSwitchToAlertAndCaptureText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * This method will switch driver control to alert and click on cancel 
	 * @param driver
	 */
	
	public void toSwitchAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to take screenshot
	 */
	public String toTakesScreenShot(WebDriver driver,String Screenshotname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./errorshots/"+Screenshotname+".jpeg");
		FileHandler.copy(temp, src);
		return Screenshotname;
	}
}
