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
		Assert.assertTrue(btnStatus1);
	}

	@Test(priority = 2)
	public void verifySignUpEnabled() {
		boolean btnStatus2 = hp.btnSignUp.isEnabled();
		Assert.assertTrue(btnStatus2);
		takeScreenshot();
	}

	@Test(priority = 3)
	public void verifySignUpClick() {
		hp.clickSignUp();
		String title = driver.getTitle();
		Assert.assertEquals("Add User", title);
		takeScreenshot();

	}
	
	@AfterClass
	public void tearDown() {
	driver.close();		
	}

}
