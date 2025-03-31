package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AddContact;
import pageObjects.ContactDetails;
import pageObjects.EditContactPage;
import pageObjects.HomePage;
import pageObjects.MyContactsPage;
import testBase.BaseClass;

public class TC006_EditContactTest extends BaseClass {

	AddContact ac;
	MyContactsPage mcp;
	HomePage hp;
	ContactDetails cd;
	EditContactPage ecd;

	@BeforeClass
	public void setup() {
		hp = new HomePage(BaseClass.driver);
		hp.clickSubmit("divya26998@gmail.com", "Divyasekar26@"); 
		ac = new AddContact(BaseClass.driver);
		mcp = new MyContactsPage(BaseClass.driver);
		cd = new ContactDetails(BaseClass.driver);
		ecd = new EditContactPage(BaseClass.driver);
	}

	@BeforeMethod()
	public void clickContactDetail() {
		driver.findElement(By.xpath("//table/tr[2]/td[2]")).click();
	}

	@Test(priority = 1)
	public void verifyPageRedirectContact() {
		Assert.assertEquals(cd.headerContactDtls.getText(), "Contact Details");
		cd.clickReturnBtn();
	}

	@Test(priority = 2)
	public void verifyEditContactDetails() {
		cd.clickEditContactButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(ecd.txtFirstName));
		WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(ecd.txtLastName));

		WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(ecd.txtEmail));

		firstName.clear();
		firstName.sendKeys("Sita");

		lastName.clear();
		lastName.sendKeys("Ram");

		emailField.clear();

		emailField.sendKeys("divya988@gmail.com");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('input'));", emailField);
		js.executeScript("arguments[0].click();", ecd.btnSubmit);
		
		WebElement txtEmail=wait.until(ExpectedConditions.visibilityOf(cd.txtEmail));
		
		Assert.assertEquals(txtEmail.getText(), "divya988@gmail.com");
		takeScreenshot();
		cd.clickReturnBtn();
	}
	
	@Test(priority=3)
	public void verifySaveEmptyFields()
	{
		
		cd.clickEditContactButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(ecd.txtFirstName));
		WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(ecd.txtLastName));
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		firstName.clear();
		firstName.sendKeys("");

		lastName.clear();
		lastName.sendKeys("");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();", ecd.btnSubmit);
		waitForElement(ecd.errorMsg);
		Assert.assertEquals(ecd.errorMsg.getText(), "Validation failed: lastName: Path `lastName` is required., firstName: Path `firstName` is required.");
		
	}
	
	private void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}
	
	@AfterClass
	public void tearDown() {
	driver.close();		
	}
	
	
	
	

}
