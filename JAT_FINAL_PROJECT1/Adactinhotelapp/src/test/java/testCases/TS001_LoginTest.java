package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TS001_LoginTest extends BaseClass {
	HomePage hp;
	
	@BeforeMethod
	public void setUp()
	{
		 hp=new HomePage(BaseClass.driver);	
	}
	
    @Test(priority=1)
	public void verifyLoginBtnVisible()
	{
		if(hp.btnLogin.isDisplayed())
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
    public void verifyValidCredentials()
    {
    	hp.passCredentials("divyasekar1234", "divya26");
    	hp.clickLogin();
    	if(driver.getCurrentUrl().contains("SearchHotel.php"))
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
    public void verifyInvalidCredentials()
    {
    	hp.passCredentials("divya123", "divya2");
    	hp.clickLogin();
    	
    	if(hp.getErrorMsg().contains("Invalid Login details or Your Password might have expired. "))
    	{
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		takeScreenshot();
    		Assert.fail();
    	}
    }
    
    @AfterMethod
    public void tearDown()
    {
    	driver.quit();
    }
	
}
