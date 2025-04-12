package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(className = "reg_success")
	public WebElement msgLogout;

	@FindBy(xpath="//a[text()='Click here to login again']")
	public WebElement lnkLogin;
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	public String getLogoutMsg()
	{
		return msgLogout.getText();
	}
}
