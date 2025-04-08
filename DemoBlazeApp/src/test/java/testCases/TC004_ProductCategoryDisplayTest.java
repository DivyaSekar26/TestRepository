package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC004_ProductCategoryDisplayTest extends BaseClass {

	HomePage hp;
	ProductPage pp;
	CartPage cp;
	
	

	@BeforeClass
	public void setUp() throws InterruptedException, IOException {
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties pr = new Properties();
		pr.load(fr);
		hp = new HomePage(BaseClass.driver);
		pp=new ProductPage(BaseClass.driver);
		cp=new CartPage(BaseClass.driver);
		hp.clickLogin(pr.getProperty("USERNAME"), pr.getProperty("PASSWORD"));
		Thread.sleep(3000);
		
	}
	
	

	@Test(priority=1)
	public void verifyClickProduct() {
		logger.info("Inside verifyClickProduct test method");
		List<WebElement> products=hp.products;
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", products.get(2));
		hp.clickProduct(products, 2);
		if(driver.getCurrentUrl().contains("prod.html"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void verifyProductdetails()
	{
		logger.info("Inside verifyProductdetails test method");
		logger.info("pp.price.getText()"+pp.price.getText());
		logger.info("pp.prodDescription.getText()"+pp.prodDescription.getText());
		if(pp.price.getText()!=null && pp.prodDescription.getText()!=null)
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
		
	}
	
	@Test(priority=3)
	public void verifyAddToCart()
	{
		logger.info("Inside verifyAddToCart test method");
		hp.lnkCart.click();
	    int cartSize=cp.list.size();
	    hp.lnkHome.click();
	    List<WebElement> products=hp.products;
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", products.get(2));
		products.get(2).click();
		pp.clickAddtocart();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.alertIsPresent());
		
		logger.info(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		hp.lnkCart.click();
		if(cp.list.size()== (cartSize+1))
		{
			//takeScreenshot();
			Assert.assertTrue(true);
		}
		else
		{
			
			takeScreenshot();
			Assert.assertTrue(false);
		}
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
