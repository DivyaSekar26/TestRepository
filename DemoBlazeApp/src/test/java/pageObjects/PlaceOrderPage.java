package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends BasePage {

	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement txtName;
	
	@FindBy(xpath="//input[@id='country']")
	public WebElement txtCountry;
	
	@FindBy(xpath="//input[@id='city']")
	public WebElement txtCity;
	
	@FindBy(xpath="//input[@id='card']")
	public WebElement txtCard;
	
	@FindBy(xpath="//input[@id='month']")
	public WebElement txtMonth;
	
	@FindBy(xpath="//input[@id='year']")
	public WebElement txtYear;
	
	@FindBy(xpath="//button[text()='Close']")
	public WebElement btnClose;
	
	@FindBy(xpath="//button[text()='Purchase']")
	public WebElement btnPurchase;
	
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	public WebElement txtConfirmationMsg;
	
	@FindBy(xpath="//p[@class='lead text-muted ']")
	public WebElement detailsPayment;
	
	public void fillPurchaseDetails(String name, String country, String city, String card, String month, String year)
	{
		txtName.sendKeys(name);
		txtCity.sendKeys(city);
		txtCountry.sendKeys(country);
		txtCard.sendKeys(card);
		txtMonth.sendKeys(month);
		txtYear.sendKeys(year);
		
	}

}
