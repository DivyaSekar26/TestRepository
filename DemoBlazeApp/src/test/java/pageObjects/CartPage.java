package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//table/tbody/tr")
	public List<WebElement> list;
	
	
	@FindBy(xpath="//table/tbody/tr/td/a")
	public List<WebElement> lnkdelete;
	
	
	@FindBy(xpath="//table/tbody/tr/td[3]")
	public List<WebElement> valPrice;
	
	@FindBy(xpath="//h3[@id='totalp']")
	public WebElement totPrice;
	
	@FindBy(xpath="//button[text()='Place Order']")
	public WebElement btnPlaceOrder;
	
	@FindBy(xpath="//h5[@id='orderModalLabel']")
	public WebElement titlePlaceOrder;
	
	public void clickPlaceOrderBtn()
	{
		btnPlaceOrder.click();
	}
    
	
}
