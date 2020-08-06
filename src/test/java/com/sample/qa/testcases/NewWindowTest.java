package com.sample.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sample.qa.base.TestBase;
import com.sample.qa.pages.newWindowPage;

public class NewWindowTest extends TestBase{
	
	newWindowPage newwindowPage;
	NewWindowTest()
	{
		super();
	}
	
	@BeforeClass
	@Parameters("url")
	public void setup(String url)
	{
		initialization(url);
	
	newwindowPage=new newWindowPage();
}
@Test(priority=1)
public void NewWindowtabTest() {
	
	newwindowPage.newWindowfunction();
	
	Assert.assertEquals(newwindowPage.ActualNewwindowTitle, "sakinalium.in");
	
		
	
}

@Test(priority=2)
public void SeperateWinTest() {
	
	newwindowPage.seperateWindow();
	
	// assert new tab/window 
	Assert.assertEquals(newwindowPage.NewWinheaderTxt, "Welcome to sakinalium.in");
	
	
}


@Test(priority=3)
public void MultiWinTest() {
	
	newwindowPage.multiWindow();
	
	//Assert multiple window for sakinalium.in
	Assert.assertEquals(newwindowPage.nxtMultiWinTitle, "sakinalium.in");
		
	//Assert multiple window for index
	Assert.assertEquals(newwindowPage.nxtMultiWinTitle2, "Index");
	
	
}



	
}
