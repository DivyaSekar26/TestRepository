package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BookHotelPage;
import pageObjects.BookingConfirmPage;
import pageObjects.HomePage;
import pageObjects.LogoutPage;
import pageObjects.SearchHotelPage;
import pageObjects.SelectHotelPage;
import testBase.BaseClass;
import utilities.BookingDetailsHelper;

public class TS005_BookingConfirmTest extends BaseClass {

	HomePage hp;
	SearchHotelPage sp;
	SelectHotelPage sl;
	BookHotelPage bp;
	BookingConfirmPage bcp;
	LogoutPage lp;
	BookingDetailsHelper bhp = new BookingDetailsHelper();

	@BeforeMethod
	public void setUp() throws IOException {

		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties pr = new Properties();
		pr.load(fr);
		hp = new HomePage(BaseClass.driver);
		sp = new SearchHotelPage(BaseClass.driver);
		sl = new SelectHotelPage(BaseClass.driver);
		bp = new BookHotelPage(BaseClass.driver);
		bcp = new BookingConfirmPage(BaseClass.driver);
		lp=new LogoutPage(BaseClass.driver);
		hp.passCredentials(pr.getProperty("USERNAME"), pr.getProperty("PASSWORD"));
		hp.clickLogin();

	}

	@DataProvider(name = "bookingdata", indices = 1)
	public Object[][] testData() {
		Object[][] data = {
				{ "Brisbane", "Hotel Hervey", "Deluxe", "2", "2", "1", "Tina", "T", "18 cross st", "1234123412341234",
						"VISA", "1", "2028", "223" },
				{ "Adelaide", "Hotel Cornice", "Super Deluxe", "2", "2", "1", "Lina", "L", "10 cross st",
						"1232123412341234", "MAST", "3", "2030", "111" } };
		return data;
	}

	@Test(priority = 1, dataProvider = "bookingdata")
	public void verifyPopulatedFields(String location, String hotelName, String roomType, String noOfrooms,
			String numOfadults, String noOfChild, String fname, String lname, String address, String ccNum,
			String cardType, String expMonth, String expYear, String cvvNum) {
		bhp.enterHotelDetails(location, hotelName, roomType, noOfrooms, numOfadults, noOfChild);
		sp.clickSubmitBtn();
		sl.selectHotel(0, sl.radioListedHotels);
		sl.clickContinue();
		bhp.enterBookingDetails(fname, lname, address, ccNum, cardType, expMonth, expYear, cvvNum);
		bp.clickBookNowButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Boolean pageLoaded = wait.until(ExpectedConditions.urlContains("BookingConfirm.php"));
		boolean flag = false;
		if (pageLoaded) {
			flag = bhp.validateBookingDetails(fname, lname, address, location, hotelName, roomType, noOfrooms);
		}

		if (flag == true) {
			Assert.assertTrue(true);
		} else {
			takeScreenshot();
			Assert.fail();
		}
	}

	@Test(priority = 2, dataProvider = "bookingdata")
	public void verifyMyItinerary(String location, String hotelName, String roomType, String noOfrooms,
			String numOfadults, String noOfChild, String fname, String lname, String address, String ccNum,
			String cardType, String expMonth, String expYear, String cvvNum) {
		bhp.enterHotelDetails(location, hotelName, roomType, noOfrooms, numOfadults, noOfChild);
		sp.clickSubmitBtn();
		sl.selectHotel(0, sl.radioListedHotels);
		sl.clickContinue();
		bhp.enterBookingDetails(fname, lname, address, ccNum, cardType, expMonth, expYear, cvvNum);
		bp.clickBookNowButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Boolean pageLoaded = wait.until(ExpectedConditions.urlContains("BookingConfirm.php"));
		boolean flag = false;
		if (pageLoaded) {
			bcp.clickBtnMyItenary();
			if (driver.getCurrentUrl().contains("BookedItinerary.php")) {
				Assert.assertTrue(true);
			} else {
				takeScreenshot();
				Assert.fail();
			}
		}

	}

	@Test(priority = 3, dataProvider = "bookingdata")
	public void verifySearchHotelPage(String location, String hotelName, String roomType, String noOfrooms,
			String numOfadults, String noOfChild, String fname, String lname, String address, String ccNum,
			String cardType, String expMonth, String expYear, String cvvNum) {
		bhp.enterHotelDetails(location, hotelName, roomType, noOfrooms, numOfadults, noOfChild);
		sp.clickSubmitBtn();
		sl.selectHotel(0, sl.radioListedHotels);
		sl.clickContinue();
		bhp.enterBookingDetails(fname, lname, address, ccNum, cardType, expMonth, expYear, cvvNum);
		bp.clickBookNowButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Boolean pageLoaded = wait.until(ExpectedConditions.urlContains("BookingConfirm.php"));
		boolean flag = false;
		if (pageLoaded) {
			bcp.clickBtnSearchHotel();
			if (driver.getCurrentUrl().contains("SearchHotel.php")) {
				Assert.assertTrue(true);
			} else {
				takeScreenshot();
				Assert.fail();
			}
		}
	}

	@Test(priority = 4, dataProvider = "bookingdata")
	public void verifyLogoutButton(String location, String hotelName, String roomType, String noOfrooms,
			String numOfadults, String noOfChild, String fname, String lname, String address, String ccNum,
			String cardType, String expMonth, String expYear, String cvvNum) {
		bhp.enterHotelDetails(location, hotelName, roomType, noOfrooms, numOfadults, noOfChild);
		sp.clickSubmitBtn();
		sl.selectHotel(0, sl.radioListedHotels);
		sl.clickContinue();
		bhp.enterBookingDetails(fname, lname, address, ccNum, cardType, expMonth, expYear, cvvNum);
		bp.clickBookNowButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Boolean pageLoaded = wait.until(ExpectedConditions.urlContains("BookingConfirm.php"));
		boolean flag = false;
		if (pageLoaded) {
			bcp.clickBtnLogout();
			if (driver.getCurrentUrl().contains("Logout.php")) {
				Assert.assertTrue(true);
			} else {
				takeScreenshot();
				Assert.fail();
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
