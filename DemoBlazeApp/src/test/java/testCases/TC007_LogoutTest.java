package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC007_LogoutTest extends BaseClass{
	
	HomePage hp;
	
	@BeforeClass
	public void setUp() throws InterruptedException, IOException
	{
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties pr = new Properties();
		pr.load(fr);
		hp=new HomePage(BaseClass.driver);
		hp.clickLogin(pr.getProperty("USERNAME"), pr.getProperty("PASSWORD"));
		Thread.sleep(3000);
	}

	@Test(priority=1)
	public void verifyLogOutvisible()
	{
		logger.info("Inside verifyLogOutvisible test method");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(hp.lnkLogout));
		
		if(hp.lnkLogout.isDisplayed())
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
	public void verifyLogoutRedirect()
	{
		logger.info("Inside verifyLogoutRedirect test method");
		hp.lnkLogout.click();
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
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
