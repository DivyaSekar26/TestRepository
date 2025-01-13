package com.selenium.package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Write a Selenium script that opens the chrome browser, navigates 
 * to "https://www.wikipedia.org/", maximizes the browser window, 
 * searches for the query "Artificial Intelligence", clicks on the "History" 
 * section in the search results, and prints the title of the section.*/

public class BasicProgram3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Artificial Intelligence");
		driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@id='toc-History']")).click();
        String tit=driver.getTitle();
        System.out.println("Title of the Page: "+ tit);
	}

}
