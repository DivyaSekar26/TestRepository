package com.selenium.package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Write a Selenium script that opens the Chrome browser, navigates 
 * to "https://www.demoblaze.com/", maximizes the browser window, 
 * verifies if the title of the page is "STORE", and prints "Page 
 * landed on correct website" if the title matches, else prints 
 * "Page not landed on correct website".*/

public class BasicProgram2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		if (title.equals("STORE")) {
			System.out.println("Page landed on correct website");
		}
		else
		{
			System.out.println("Page not landed on correct website");
		}

	}

}
