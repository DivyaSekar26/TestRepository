package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC005_CartTest extends BaseClass {
	CartPage cp;
	HomePage hp;

	@BeforeClass
	public void setUp() throws InterruptedException, IOException {
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties pr = new Properties();
		pr.load(fr);
		hp = new HomePage(BaseClass.driver);
		cp = new CartPage(BaseClass.driver);
		hp.clickLogin(pr.getProperty("USERNAME"), pr.getProperty("PASSWORD"));
		Thread.sleep(3000);
		hp.lnkCart.click();

	}

	@Test(priority = 1)
	public void verifyDelete() throws InterruptedException {
		logger.info("Inside verifyDelete test method");
		List<WebElement> list = fetchProductList(cp.list);
		int sizeBefore = list.size();
		if (sizeBefore > 0) {
		cp.lnkdelete.get(sizeBefore - 1).click();
		List<WebElement> list1 = fetchProductList(cp.list);
		int sizeAfter = list1.size();
		if(sizeAfter==( sizeBefore - 1))
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
		}
		else
		{
			logger.info("there are no products in Cart and cannot execute this testcase verifyDelete");
		}

	}

	@Test(priority = 2)
	public void verifyPrice() throws InterruptedException {
		logger.info("Inside verifyPrice test method");
		List<WebElement> list=fetchPricetList(cp.valPrice);
		int size=list.size();
		int sum = 0;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				String priceValue = list.get(i).getText();
				sum = sum + Integer.parseInt(priceValue);
			}

			if(sum== Integer.parseInt(cp.totPrice.getText()))
			{
				Assert.assertTrue(true);
			}
			else
			{
				takeScreenshot();
				Assert.fail();
			
			}
		} else {
			logger.info("there are no products in Cart and cannot execute this testcase verifyPrice");
		}

	}

	public List<WebElement> fetchProductList(List<WebElement> ele) throws InterruptedException {
		int prevCount = 0;
		List<WebElement> elements;
		while (true) {
			elements = ele;
			int currentCount = elements.size();
			if (currentCount == prevCount) {
				break;
			}
			prevCount = currentCount;
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000);");
			Thread.sleep(1000); // rude but sometimes necessary
		}
		return elements;
	}
	
	public List<WebElement> fetchPricetList(List<WebElement> ele) throws InterruptedException {
		int prevCount = 0;
		List<WebElement> elements;
		while (true) {
			elements = ele;
			int currentCount = elements.size();
			if (currentCount == prevCount) {
				break;
			}
			prevCount = currentCount;
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000);");
			Thread.sleep(1000); 
		}
		return elements;
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
