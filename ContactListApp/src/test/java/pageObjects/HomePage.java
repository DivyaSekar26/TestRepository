package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(id="email")
	public WebElement txtEmail;
	
	@FindBy(id="password")
	public WebElement txtPassword;
	
	@FindBy(id="submit")
	public WebElement btnSubmit;
	
	@FindBy(xpath="//button[@id='signup']")
	public WebElement btnSignUp;
	
	@FindBy(xpath="//span[contains(text(),'Incorrect username or password')]")
	//@FindBy(id="error")
	public WebElement txtError;
	
	public void clickSubmit(String email, String pass)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPassword.clear();
		txtPassword.sendKeys(pass);
		btnSubmit.click();	
	}
	
	public void clickSignUp()
	{
		btnSignUp.click();
	}

}
