package selenium.task10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		Thread.sleep(3000);
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

		for (WebElement date : dates) {
			if (date.getText().equals("22")) {
				date.click();
			}
		}

		Thread.sleep(5000);

		/*
		 * WebElement datepicker =
		 * driver.findElement(By.xpath("//input[@id='datepicker']"));
		 */

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String dateValue = (String) js.executeScript("return document.getElementById('datepicker').value;");
		System.out.println(dateValue + " Selected");
		driver.close();

	}

}
