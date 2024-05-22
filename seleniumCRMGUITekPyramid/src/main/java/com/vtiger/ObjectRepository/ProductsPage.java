package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productLookUpImage;

	public WebElement getProductLookUpImage() {
		return productLookUpImage;
	}
	
	@FindBy(name="search")
	private WebElement searchfieldele2;

	public WebElement getSearchfield() {
		return searchfieldele2;
	}

	@FindBy(name="search")
	private WebElement searchbtnele3;

	public WebElement getSearchbtnele3() {
		return searchbtnele3;
	}

}
