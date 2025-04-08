package testCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	HomePage hp;
	@BeforeClass
	public void setUp()
	{
		 hp=new HomePage(BaseClass.driver);
	}
	
	@Test(priority=1)
	public void verifyLoginVisible()
	{
		logger.info("Inside verifyLoginVisible test method");
		if(hp.btnLoginHome.isDisplayed())
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
	public void verifyLoginClickable()
	{
		logger.info("Inside verifyLoginClickable test method");
		if(hp.btnLoginHome.isEnabled()) {
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
	}
	
	@Test(priority=3)
	public void verifyLogin()
	{
		logger.info("Inside verifyLogin test method");
		hp.clickLogin("Divya2609", "Divya26091998@");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement txtWelcomeUser=wait.until(ExpectedConditions.visibilityOf(hp.txtWelcomeuser));
		if(txtWelcomeUser.getText().equals("Welcome Divya2609")) {
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
