package testCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AddContact;
import pageObjects.HomePage;
import pageObjects.MyContactsPage;
import testBase.BaseClass;

public class TC005_ContactDisplayTest extends BaseClass{
	
	AddContact ac;
	MyContactsPage mcp;
	HomePage hp;
	
	@BeforeClass
	public void setup() {
		hp = new HomePage(BaseClass.driver);
		hp.clickSubmit("xyz_test@gmail.com", "Divya1234"); 
		ac = new AddContact(BaseClass.driver);
		mcp = new MyContactsPage(BaseClass.driver);
	}

	@Test(priority=1)
	public void verifyAddedContact()
	{
		try
		{
		Assert.assertEquals(driver.findElement(By.xpath("//table/tr[2]/td[2]")).getText(), "Neha S");
		Assert.assertEquals(driver.findElement(By.xpath("//table/tr[2]/td[4]")).getText(), "neha123@gmail.com");
		Assert.assertEquals(driver.findElement(By.xpath("//table/tr[2]/td[5]")).getText(), "+919080356790");
		Assert.assertEquals(driver.findElement(By.xpath("//table/tr[2]/td[6]")).getText(), "No.5 Chennai");
		Assert.assertEquals(driver.findElement(By.xpath("//table/tr[2]/td[7]")).getText(), "Chennai TamilNadu 999888");
		Assert.assertEquals(driver.findElement(By.xpath("//table/tr[2]/td[8]")).getText(), "India");
		}
		catch (Exception e)
		{
			takeScreenshot();
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void verifyPhoneNumberExtensions()
	{
		List<WebElement> list=mcp.rowofContactList;
		int size=list.size();
		for(int i=1;i<=size;i++)
		{
	    
	    	logger.info(i);
	    	String dynamicXpath = String.format("//table/tr[%d]/td[5]", i);
	    	if(!(driver.findElement(By.xpath(dynamicXpath)).getText().isEmpty()))
	    			{
		           if(driver.findElement(By.xpath(dynamicXpath)).getText().startsWith("+91"))
		           {
		        	   Assert.assertTrue(true);
		           }
		           else
		           {
		        	   takeScreenshot();
		        	   Assert.fail();
		           }
	    			}
	    
		}
	}
	
	@Test(priority=3)
	public void verifySortLastName() {
		List<WebElement> list=mcp.rowofContactList;
		int size=list.size();
		ArrayList<String> names=new ArrayList<>();
		
		for(int i=1;i<=size;i++)
		{
	    
	    	logger.info(i);
	    	String dynamicXpath = String.format("//table//tr[%d]/td[2]", i);
	    	String name=driver.findElement(By.xpath(dynamicXpath)).getText().trim();
	    	String[] parts=name.split(" ");
	    	names.add(parts[1]);
	    
		}
		
		ArrayList<String> sortedNames=new ArrayList<>(names);
		Collections.sort(sortedNames);
		
		if(names.equals(sortedNames))
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot();
			Assert.fail();
		}
	}
	
	
	@AfterClass
	public void tearDown() {
	driver.quit();		
	}

}
