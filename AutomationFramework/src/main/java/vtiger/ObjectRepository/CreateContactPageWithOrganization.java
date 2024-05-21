package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPageWithOrganization {

	//Constructor
	public CreateContactPageWithOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="vtiger")
	private WebElement acccountsAction;

	public WebElement getAcccountsAction() {
		return acccountsAction;
	}
	
	
}
