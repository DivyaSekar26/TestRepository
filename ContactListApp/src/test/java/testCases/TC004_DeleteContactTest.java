package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.ContactDetails;
import pageObjects.HomePage;
import pageObjects.MyContactsPage;
import testBase.BaseClass;

public class TC004_DeleteContactTest extends BaseClass {

	MyContactsPage mcp;
	HomePage hp;
	ContactDetails cd;

	@BeforeClass
	public void setup() {
		hp = new HomePage(BaseClass.driver);
		hp.clickSubmit("divya26998@gmail.com", "Divyasekar26@"); 
		mcp = new MyContactsPage(BaseClass.driver);
		cd = new ContactDetails(BaseClass.driver);
	}

	@Test(priority = 1)
	public void isAlertComingForDelete() {

		driver.findElement(By.xpath("//table/tr[1]")).click();
		cd.clickDeleteButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			takeScreenshot();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			logger.info("No Alert appeared");
		}
		driver.navigate().back();

	}

	@Test(priority = 2)
	public void verifyDeleteContact() throws InterruptedException {

		List<WebElement> list = mcp.rowofContactList;
		int size = list.size();

		logger.info("Initial SIze: "+ size);
		driver.findElement(By.xpath("//table/tr[1]")).click();
		cd.clickDeleteButton();
		cd.confirmDelete();
		
        logger.info("After size: "+list.size());
		Assert.assertEquals(list.size(), size - 1); // checking whether it impacts any other contacts by confirming count
		takeScreenshot();
	}
	
	@AfterClass
	public void tearDown() {
	driver.close();		
	}

}
