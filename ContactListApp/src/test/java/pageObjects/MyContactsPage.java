package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyContactsPage extends BasePage {

	public MyContactsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h1[text()='Contact List']")
	public WebElement contactPageHeader;
	
	@FindBy(id="add-contact")
	public WebElement btnAddNewContact;
	
	@FindBy(xpath="//table/tr")
	public List<WebElement> rowofContactList;
	
	@FindBy(id="logout")
	public WebElement btnLogout;
	
	public void clickAddNewContact()
	{
		btnAddNewContact.click();
	}

}
