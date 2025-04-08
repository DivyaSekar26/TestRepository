package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h3[@class='price-container']")
	public WebElement price;
	
	@FindBy(xpath="//div[@class='tab-pane fade active in']/p")
	public WebElement prodDescription;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	public WebElement btnAddToCart;
	
	public void clickAddtocart()
	{
		btnAddToCart.click();
	}
}
