package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactInformationPage;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDate;

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getContactInformationPage() {
		return contactInformationPage;
	}

}
