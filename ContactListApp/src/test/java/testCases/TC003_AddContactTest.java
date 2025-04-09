package testCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AddContact;
import pageObjects.HomePage;
import pageObjects.MyContactsPage;
import testBase.BaseClass;

public class TC003_AddContactTest extends BaseClass {
	AddContact ac;
	MyContactsPage mcp;
	HomePage hp;

	@BeforeClass
	public void setup() {
		hp = new HomePage(BaseClass.driver);
		hp.clickSubmit("xyz_test@gmail.com", "Divya1234"); 
		ac = new AddContact(BaseClass.driver);
		mcp = new MyContactsPage(BaseClass.driver);
	}

	@BeforeMethod
	public void navigateToAddContact() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		mcp.clickAddNewContact();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(priority = 1)
	public void verifyAddAllFields() {

		ac.setName("Neha", "S");
		ac.setBirthDate("1990-09-26");
		ac.setEmail("neha123@gmail.com");
		ac.setPhoneNumber("+919080356790");
		ac.setStreets("No.5", "Chennai");
		ac.setCity("Chennai");
		ac.setStateProvince("TamilNadu");
		ac.setPostalCode("999888");
		ac.setCountry("India");
		ac.clickSubmit();
		takeScreenshot();
		if( mcp.contactPageHeader.getText().equals("Contact List"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}

	}

	@Test(priority = 4)
	public void verifyAddWoOptionalFields() {
		ac.setBirthDate("1990-09-26");
		ac.setEmail("neha123@gmail.com");
		ac.setPhoneNumber("+919080356790");
		ac.setStreets("No.5", "Chennai");
		ac.setCity("Chennai");
		ac.setStateProvince("TamilNadu");
		ac.setPostalCode("999888");
		ac.setCountry("India");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		ac.clickSubmit();
		waitForElement(ac.errorMsg);
		if(ac.errorMsg.getText().equals( "Contact validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required."))
		{
			Assert.assertTrue(true);
		}
		else {
		takeScreenshot();
		Assert.fail();
		}
		ac.btnCancel.click();

		
	}

	@Test(priority = 2)
	public void verifyAddDuplicateFields() {
		waitForElement(ac.txtLastName);
		ac.setName("Neha", "S");
		waitForElement(ac.txtBirthDate);
		ac.setBirthDate("1990-09-26");
		ac.setEmail("neha123@gmail.com");
		ac.setPhoneNumber("+919080356790");
		ac.setStreets("No.5", "Chennai");
		ac.setCity("Chennai");
		ac.setStateProvince("TamilNadu");
		ac.setPostalCode("999888");
		ac.setCountry("India");
		ac.clickSubmit();
		if( mcp.contactPageHeader.getText().equals("Contact List"))
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
	public void verifyInvalidDOBFormat() {

		waitForElement(ac.txtFirstName);
		ac.setName("Neha", "Raman");
		ac.setBirthDate("08-07-1998");
		waitForElement(ac.txtEmail);
		ac.setEmail("venky009@gmail.com");
		ac.setPhoneNumber("+916789543567");
		waitForElement(ac.txtStreet1);
		ac.setStreets("No.8", "Erode");
		ac.setCity("Erode");
		waitForElement(ac.txtStateProvince);
		ac.setStateProvince("TN");
		ac.setPostalCode("601148");
		ac.setCountry("INDIA");
		waitForElement(ac.btnSubmit);
		ac.clickSubmit();
		waitForElement(ac.errorMsg);
		// Assert.assertEquals("Contact validation failed: birthdate: Birthdate is
		// invalid", ac.errorMsg.getText());
		if(ac.errorMsg.getText().equals("Contact validation failed: birthdate: Birthdate is invalid"))
		{
			Assert.assertTrue(true);
		}
		else
		{
		takeScreenshot();
		Assert.fail();
		}
		ac.btnCancel.click();
		

	}
	

	private void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}
	
	
	
	@AfterClass
	public void tearDown() {
	driver.quit();		
	}

}
