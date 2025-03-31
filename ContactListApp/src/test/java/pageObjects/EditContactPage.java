package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditContactPage extends BasePage{

	public EditContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//@FindBy(id="firstName")
		@FindBy(xpath="//input[@id='firstName']")
		public WebElement txtFirstName;
		
		@FindBy(id="lastName")
		public WebElement txtLastName;
		
		@FindBy(id="birthdate")
		public WebElement txtBirthDate;
		
		@FindBy(id="phone")
		public WebElement txtPhone;
		
		@FindBy(id="email")
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
		
		@FindBy(id="submit")
		public WebElement btnSubmit;
		
		@FindBy(id="cancel")
		public WebElement btnCancel;
		
		@FindBy(id="logout")
		public WebElement btnLogout;
		
		//@FindBy(id="error")
		@FindBy(xpath="//span[@id='error']")
		public WebElement errorMsg;
		

}
