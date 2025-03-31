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
		Assert.assertTrue(loginBtnStatus1);
		takeScreenshot();
	}

	@Test(priority=2)
	public void isLoginBtnClickable() {
		boolean loginBtnStatus2 = hp.btnSubmit.isEnabled();
		Assert.assertTrue(loginBtnStatus2);
		takeScreenshot();

	}

	@Test(priority=4)
	public void verifyLogin() {

		hp.clickSubmit("divya26998@gmail.com", "Divyasekar26@");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String header=cp.contactPageHeader.getText();
	
		System.out.println(header);
		Assert.assertEquals("Contact List", header);
	}
	
	@Test(priority=3)
	public void verifyInvalidLogin()
	{
		hp.clickSubmit("divya26998@gmail.com", "divya");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		String errorText=hp.txtError.getText();
		logger.info(errorText);
		Assert.assertEquals("Incorrect username or password", errorText);
		takeScreenshot();
		
	}
	
	@AfterClass
	public void tearDown() {
	driver.close();		
	}


}
