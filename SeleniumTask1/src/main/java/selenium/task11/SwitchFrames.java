package selenium.task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement top = driver.findElement(By.xpath("//frame[@src='/frame_top']"));
		driver.switchTo().frame(top);
		int frameCount = driver.findElements(By.tagName("frame")).size();

		if (frameCount == 3) {
			System.out.println("Yes. Frame count is 3 inside top Frame");
		} else {
			System.out.println("No. Frame Count is not 3 inside top frame");
		}
		WebElement left = driver.findElement(By.xpath("//frame[@src='/frame_left']"));
		driver.switchTo().frame(left);
		if (driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText().equals("LEFT")) {
			System.out.println("Text Verified in Left frame");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(top);
		WebElement middle = driver.findElement(By.xpath("//frame[@src='/frame_middle']"));
		driver.switchTo().frame(middle);
		if (driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText().equals("MIDDLE")) {
			System.out.println("Text Verified in Middle frame");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(top);
		WebElement right = driver.findElement(By.xpath("//frame[@src='/frame_right']"));
		driver.switchTo().frame(right);
		if (driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText().equals("RIGHT")) {
			System.out.println("Text Verified in Right frame");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(top);
		driver.switchTo().defaultContent();
		WebElement bottom = driver.findElement(By.xpath("//frame[@src='/frame_bottom']"));
		driver.switchTo().frame(bottom);
		if (driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText().equals("BOTTOM")) {
			System.out.println("Text Verified in Bottom frame");
		}

	}

}
