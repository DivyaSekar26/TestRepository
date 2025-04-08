package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Sign up']")
	public WebElement btnSignUp;

	@FindBy(xpath = "//a[@id='login2']")
	public WebElement btnLoginHome;

	@FindBy(xpath = "//input[@id='loginusername']")
	public WebElement txtUserName;

	@FindBy(xpath = "//input[@id='loginpassword']")
	public WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	public WebElement btnLogin;

	@FindBy(xpath = "//a[@id='nameofuser']")
	public WebElement txtWelcomeuser;
	
	@FindBy(xpath="//a[text()='Home ']")
	public WebElement lnkHome;
	
	@FindBy(xpath="//a[text()='Contact']")
	public WebElement lnkContact;
	
	@FindBy(xpath = "//a[text()='About us']")
	public WebElement lnkAboutUs;
	
	@FindBy(xpath="//a[text()='Cart']")
	public WebElement lnkCart;
	
	@FindBy(xpath="//a[@id='logout2']")
	public WebElement lnkLogout;
	
	@FindBy(xpath="//a[text()='Phones']")
	public WebElement lnkPhones;
	
	@FindBy(xpath="//a[text()='Laptops']")
	public WebElement lnkLaptops;
	
	@FindBy(xpath="//a[text()='Monitors']")
	public WebElement lnkMonitors;
	
	@FindBy(xpath="(//img[@src='bm.png'])[1]")
	public WebElement logo;
	
	@FindBy(xpath="//h4[@class='card-title']/a")
	public List<WebElement> products;

	public void clickSignUpButton() {
		btnSignUp.click();
	}

	public void clickLogin(String userName, String password) {
		btnLoginHome.click();
		txtUserName.sendKeys(userName);	
		txtPassword.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		btnLogin.click();

	}
	
	public void clickProduct(List<WebElement> products , int i)
	{
		products.get(i).click();
	}

}
