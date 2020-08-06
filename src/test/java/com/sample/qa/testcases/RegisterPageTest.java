package com.sample.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

import com.sample.qa.base.TestBase;
import com.sample.qa.pages.RegisterPage;
import com.sample.qa.util.excelLib;
import com.sun.tools.sjavac.Log;

public class RegisterPageTest extends TestBase{
	
	
	Logger log = Logger.getLogger(RegisterPageTest.class);
	
	RegisterPage registerPage;
	public RegisterPageTest() {
		super();
	}
	
	
	@BeforeClass
	@Parameters("url")
	public void setup(String url)
	{
		initialization(url);
		
		registerPage=new RegisterPage();
		}
	
	@DataProvider
	public Object[][] getRegData() throws InvalidFormatException, IOException
	{
		Object data[][]=excelLib.getTestData("Sheet1");
		return data;
	}
	
	
	
	@Test(dataProvider="getRegData")
	public  void RegistrationTest(String firstName,String Lastname,String emailID,String phone,String country,String year,String day,String pwd,String confpwd)
	{
		
				
		  String title=registerPage.submitform(pwd, firstName, Lastname, emailID, phone, country, year, day, confpwd);
		  
		  System.out.println(title);
		  Assert.assertEquals(title, "Web Table");
			 
		 
		  
		 
		
				
		//Assert with successful  or Thank You Message
		
	}
	
		
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

	

}
