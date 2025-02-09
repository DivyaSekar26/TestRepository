package selenium.task11;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindlowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> Ids = driver.getWindowHandles();
		ArrayList<String> Id = new ArrayList(Ids);
		String childId = Id.get(1);
		driver.switchTo().window(childId);
		String contentChild = driver.findElement(By.className("example")).getText();
		if (contentChild.equals("New Window")) {
			System.out.println("Text Matched in New Window");
		}
		driver.close();
		String parentId = Id.get(0);
		Set<String> windowIds = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList(windowIds);
		if (list.get(0) != null) {
			System.out.println("Parent Window is Active");
		}

		driver.close();

	}

}
