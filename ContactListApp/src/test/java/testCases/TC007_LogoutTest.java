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
		hp.clickSubmit("divya26998@gmail.com", "Divyasekar26@"); 
		mcp = new MyContactsPage(BaseClass.driver);

	}
	
	@Test(priority=1)
	public void verifyBtnLogoutVisible()
	{
		Assert.assertTrue(mcp.btnLogout.isDisplayed());
	}
	
	@Test(priority=2 , dependsOnMethods= {"verifyBtnLogoutVisible"})
	public void verifyBtnLogout()
	{
		mcp.btnLogout.click();
		Assert.assertEquals("Contact List App", driver.getTitle());
	}
	
	@AfterClass
	public void tearDown() {
	driver.close();		
	}
	

}
