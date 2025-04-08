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

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC003_HomeScreenTest extends BaseClass {
	
	HomePage hp;
	@BeforeClass
	public void setUp() throws IOException
	{
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties pr = new Properties();
		pr.load(fr);
		hp=new HomePage(BaseClass.driver);
		hp.clickLogin(pr.getProperty("USERNAME"), pr.getProperty("PASSWORD"));
	}
	
	@Test(priority=1)
	public void verifyAllMenuDisplay()
	{
		logger.info("Inside verifyAllMenuDisplay test method");
		Assert.assertTrue(hp.lnkHome.isDisplayed());
		Assert.assertTrue(hp.lnkContact.isDisplayed());
		Assert.assertTrue(hp.lnkAboutUs.isDisplayed());
		Assert.assertTrue(hp.lnkCart.isDisplayed());
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(hp.lnkLogout));
		if(element.isDisplayed())
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
	public void verifyAllCategories()
	{
		logger.info("Inside verifyAllCategories test method");
		if(hp.lnkPhones.isDisplayed() && hp.lnkMonitors.isDisplayed()&& hp.lnkLaptops.isDisplayed())
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
	public void verifyLogo()
	{
		logger.info("Inside verifyLogo test method");
		if(hp.logo.isDisplayed())
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
