package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetails extends BasePage {

	public ContactDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "delete")
	public WebElement btnDelete;

	@FindBy(id = "edit-contact")
	public WebElement btnEdit;
	
	@FindBy(xpath="//h1[text()='Contact Details']")
	public WebElement headerContactDtls;
	
	@FindBy(id="return")
	public WebElement btnReturn;
	
	@FindBy(xpath="//input[@id='firstName']")
	public WebElement txtFirstName;
	
	@FindBy(id="lastName")
	public WebElement txtLastName;
	
	@FindBy(id="birthdate")
	public WebElement txtBirthDate;
	
	@FindBy(id="phone")
	public WebElement txtPhone;
	
	@FindBy(xpath="//span[@id='email']")
	public WebElement txtEmail;
	
	@FindBy(id="street1")
	public WebElement txtStreet1;
	
	@FindBy(id="street2")
	public WebElement txtStreet2;
	
	@FindBy(id="city")
	public WebElement txtCity;
	
	@FindBy(id="stateProvince")
	public WebElement txtStateProvince;
	
	@FindBy(id="postalCode")
	public WebElement txtPostalCode;
	
	@FindBy(id="country")
	public WebElement txtCountry;
	

	public void clickDeleteButton() {
		btnDelete.click();
	}

	public void confirmDelete() {
		driver.switchTo().alert().accept();

	}

	public void clickEditContactButton() {
		btnEdit.click();
	}

	public void clickReturnBtn()
	{
		btnReturn.click();
	}
}
