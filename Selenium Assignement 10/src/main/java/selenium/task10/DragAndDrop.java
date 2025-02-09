package selenium.task10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		Thread.sleep(3000);
		driver.switchTo().frame(0);

		WebElement toDrag = driver.findElement(By.id("draggable"));
		WebElement toDrop = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(toDrag, toDrop);
		actions.build().perform();

		String dropText = driver.findElement(By.id("droppable")).getText();
		System.out.println(dropText);
		String color=driver.findElement(By.id("droppable")).getCssValue("color");
		System.out.println(color);
        driver.close();
        
        
	}

}
