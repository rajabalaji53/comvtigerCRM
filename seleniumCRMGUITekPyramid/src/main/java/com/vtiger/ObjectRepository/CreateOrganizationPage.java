package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(id="phone")
	private WebElement phoneNumberTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="search_text")
	private WebElement searchBarTextField;
	
	@FindBy(name="search_field")
	private WebElement searchInDropDown;
	
	@FindBy(name="submit")
	private WebElement searchNowButton;

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

	public WebElement getSearchInDropDown() {
		return searchInDropDown;
	}

	public WebElement getSearchBarTextField() {
		return searchBarTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}
	

}
