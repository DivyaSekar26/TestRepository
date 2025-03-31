package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContact extends BasePage {
	
	public AddContact(WebDriver driver) {
		super(driver);
		
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
	
	@FindBy(xpath="//h1[text()='Add Contact']")
	public WebElement headerAddContact;
	
	@FindBy(id="error")
	//@FindBy(xpath="//span[@id='error']")
	public WebElement errorMsg;
	
	public void setName(String fname, String lname)
	{
		txtFirstName.sendKeys(fname);
		txtLastName.sendKeys(lname);
	}	
	
	public void setBirthDate(String birthDate)
	{
		txtBirthDate.sendKeys(birthDate);
	}
	
	public void setPhoneNumber(String phoneNum)
	{
		txtPhone.sendKeys(phoneNum);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setStreets(String street1, String street2)
	{
		txtStreet1.sendKeys(street1);
		txtStreet2.sendKeys(street2);
	}
	
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void setStateProvince(String stateProvince)
	{
		txtStateProvince.sendKeys(stateProvince);
	}
	
	public void setPostalCode(String postalCode)
	{
		txtPostalCode.sendKeys(postalCode);
	}
	
	public void setCountry(String country)
	{
		txtCountry.sendKeys(country);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void clcikCancel()
	{
		btnCancel.click();
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}

}
