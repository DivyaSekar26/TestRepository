package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyContactsPage;
import testBase.BaseClass;

public class TC007_LogoutTest extends BaseClass {

	MyContactsPage mcp;
	HomePage hp;

	@BeforeClass
	public void setup() {
		hp = new HomePage(BaseClass.driver);
		hp.clickSubmit("xyz_test@gmail.com", "Divya1234"); 
		mcp = new MyContactsPage(BaseClass.driver);

	}
	
	@Test(priority=1)
	public void verifyBtnLogoutVisible()
	{
		if(mcp.btnLogout.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
	}
	
	@Test(priority=2 , dependsOnMethods= {"verifyBtnLogoutVisible"})
	public void verifyBtnLogout()
	{
		mcp.btnLogout.click();
		if(driver.getTitle().equals("Contact List App"))
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
	public void tearDown() {
	driver.quit();		
	}
	

}
