package com.sample.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sample.qa.base.TestBase;
import com.sample.qa.pages.AlertPage;


public class AlertPageTest extends TestBase{
	
	AlertPage alertPage;
	AlertPageTest()
	{
		super();
	}
	
@BeforeClass
@Parameters("url")
public void setup(String url)
{
	initialization(url);
	
	alertPage=new AlertPage();
}
@Test(priority=1)
public void AlertwithOKTest() {
	
	
	alertPage.alertOKfunction();
	
	
	
}

@Test(priority=2)
public void AlertPageConfTest() {
	
	
	alertPage.alertConfunction();
	String okMsg=alertPage.Okmessage;
	String cancelMsg=alertPage.Cancelmessage;
	
	//Assertion for both Alert function OK & Cancel
	Assert.assertEquals(okMsg, "You pressed Ok");
	Assert.assertEquals(cancelMsg, "You Pressed Cancel");
	
	
}


@Test(priority=3)
public void AlertPageTextboxTest() {
	
	
	alertPage.alertTextboxfunction();
	String textmsg=alertPage.txtmsg;
	
	
	//Assertion for both Alert function OK & Cancel
	Assert.assertEquals(textmsg, "Hello Amiya How are you today");
	
	
	
	
}



}
