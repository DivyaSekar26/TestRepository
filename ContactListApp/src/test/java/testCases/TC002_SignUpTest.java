package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_SignUpTest extends BaseClass {

	HomePage hp;

	@BeforeClass
	public void initElements() {
		hp = new HomePage(BaseClass.driver);
	}

	@Test(priority = 1)
	public void verifySignUpVisible() {

		boolean btnStatus1 = hp.btnSignUp.isDisplayed();
		if(btnStatus1)
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void verifySignUpEnabled() {
		boolean btnStatus2 = hp.btnSignUp.isEnabled();
		if(btnStatus2)
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
		
	}

	@Test(priority = 3)
	public void verifySignUpClick() {
		hp.clickSignUp();
		String title = driver.getTitle();
		if( title.equals("Add User"))
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
