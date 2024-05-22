package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	//Constructor
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindAll({@FindBy(name="button"),@FindBy(xpath="//input[@title='Save [Alt+S]']")})
	private WebElement saveButton;
	
	@FindBy(name="button")
	private WebElement cancelButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement contactWithOrganization;

	public WebElement getContactWithOrganization() {
		return contactWithOrganization;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	
}
