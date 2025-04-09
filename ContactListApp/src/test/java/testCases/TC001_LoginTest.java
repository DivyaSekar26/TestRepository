package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyContactsPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {

	HomePage hp;
	MyContactsPage cp;

	@BeforeClass
	public void initElements() {
		hp = new HomePage(BaseClass.driver);
		cp=new MyContactsPage(BaseClass.driver);
		
	}

	@Test(priority=1)
	public void isLoginBtnVisible() {
		boolean loginBtnStatus1 = hp.btnSubmit.isDisplayed();
		if(loginBtnStatus1) 
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
	public void isLoginBtnClickable() {
		boolean loginBtnStatus2 = hp.btnSubmit.isEnabled();
		if(loginBtnStatus2)
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}

	}

	@Test(priority=4)
	public void verifyLogin() {

		hp.clickSubmit("xyz_test@gmail.com", "Divya1234");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String header=cp.contactPageHeader.getText();
	
		logger.info(header);
		if( header.equals("Contact List"))
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
	public void verifyInvalidLogin()
	{
		hp.clickSubmit("xyz_test@gmail.com", "divya");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		String errorText=hp.txtError.getText();
		logger.info(errorText);
		if( errorText.equals("Incorrect username or password"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
		takeScreenshot();
		
	}
	
	@AfterClass
	public void tearDown() {
	driver.quit();		
	}


}
