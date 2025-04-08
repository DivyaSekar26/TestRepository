package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_SignUpTest extends BaseClass {
	HomePage hp;

	@BeforeClass
	public void setUp() {
		hp = new HomePage(BaseClass.driver);
	}

	@Test(priority = 1)
	public void btnSignUpVisible() {
		logger.info("Inside btnSignUpVisible test method");
		if (hp.btnSignUp.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			takeScreenshot();
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void btnSignUpClcikable() {
		logger.info("Inside btnSignUpClcikable test method");
		if (hp.btnSignUp.isEnabled()) {
			Assert.assertTrue(true);
		} else {
			takeScreenshot();
			Assert.fail();

		}
	}

	@Test(priority = 3)
	public void verifySignUpBtn() {
		logger.info("Inside verifySignUpBtn test method");
		hp.clickSignUpButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModalLabel")));
		if (element.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			takeScreenshot();
			Assert.fail();
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
