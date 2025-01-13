package com.selenium.package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*1. Write a Selenium script that opens the Firefox browser, maximizes the browser window,
 *  navigates to "http://google.com", prints the URL of the current page,
 *   reloads the page, and closes the browser.*/


import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicProgram1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://google.com");
		System.out.println(driver.getCurrentUrl());
	    driver.navigate().refresh();
	    driver.close();
		

	}

}
