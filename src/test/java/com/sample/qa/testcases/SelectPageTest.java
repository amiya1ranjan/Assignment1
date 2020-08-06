package com.sample.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sample.qa.base.TestBase;
import com.sample.qa.pages.SelectPage;

public class SelectPageTest extends TestBase {
	SelectPage selectPage;
	
	public SelectPageTest() {
		super();
	}
	
	@BeforeClass
	@Parameters("url")
	public void setup(String url)
	{
		initialization(url);
		selectPage=new SelectPage();
		}
	
	@Test
	public void SelectItemsTest()
	{
		
		selectPage.Selectitems();
		
		// asserting the selection made by user with message after selection
		Assert.assertEquals(selectPage.msgsel, "Functional Testing");
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
