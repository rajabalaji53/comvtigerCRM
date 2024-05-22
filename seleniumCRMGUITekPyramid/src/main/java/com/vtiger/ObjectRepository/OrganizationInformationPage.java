package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationInformation;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgname;

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getOrganizationInformation() {
		return organizationInformation;
	}
	

}
