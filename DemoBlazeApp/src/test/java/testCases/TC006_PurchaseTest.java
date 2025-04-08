package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.PlaceOrderPage;
import testBase.BaseClass;

public class TC006_PurchaseTest extends BaseClass{
	HomePage hp;
	CartPage cp;
	PlaceOrderPage pp;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	
	@BeforeClass
	public void setUp() throws InterruptedException, IOException {
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties pr = new Properties();
		pr.load(fr);
		hp = new HomePage(BaseClass.driver);
		cp = new CartPage(BaseClass.driver);
		pp=new PlaceOrderPage(BaseClass.driver);
		hp.clickLogin(pr.getProperty("USERNAME"), pr.getProperty("PASSWORD"));
		Thread.sleep(3000);
		hp.lnkCart.click();

	}

	@Test(priority=1)
	public void verifyPageRedirect()
	{
		logger.info("Inside verifyPageRedirect test method");
		cp.clickPlaceOrderBtn();	
		WebElement element=wait.until(ExpectedConditions.visibilityOf(cp.titlePlaceOrder));
		if(element.getText().equals( "Place order"))
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
	public void verifyPurchase()
	{
		logger.info("Inside verifyPurchase test method");
		pp.fillPurchaseDetails("Divya", "India", "Chennai", "123456789", "JAN", "2027");
		pp.btnPurchase.click();
		if(pp.txtConfirmationMsg.getText().equals("Thank you for your purchase!")
				&& pp.detailsPayment.getText().contains("123456789")
				&& pp.detailsPayment.getText().contains("Divya"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
