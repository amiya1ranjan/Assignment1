package com.sample.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sample.qa.base.TestBase;
import com.sample.qa.pages.SelectPage;
import com.sample.qa.pages.framesPage;

public class framePageTest extends TestBase {
	framesPage framesPageref;
	
	public framePageTest() {
		super();
	}
	
	@BeforeClass
	@Parameters("url")
	public void setup(String url)
	{
		initialization(url);
		framesPageref=new framesPage();
		}
	
	@Test
	public void FramePageTest()
	{
		framesPageref.frameTest();
		
		//verifying first frame text entered
		Assert.assertEquals(framesPageref.textFrame1, "TestSingleFrame");
		
		//verifying first frame within frame text entered
		Assert.assertEquals(framesPageref.textFrame2, "Test Iframe with in an Iframe");
		
		
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
