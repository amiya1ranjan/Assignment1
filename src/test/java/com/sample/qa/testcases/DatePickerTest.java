package com.sample.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sample.qa.base.TestBase;
import com.sample.qa.pages.DatePickerPage;


public class DatePickerTest extends TestBase{
	
	
	
	DatePickerPage datePickerPage;
	
	public DatePickerTest() {
		super();
	}
	
	@BeforeClass
	@Parameters("url")
	public void setup(String url)
	{
		initialization(url);
		datePickerPage=new DatePickerPage();
		}
	
	@Test
	public void DatePickerfunctionTest()
	{
		
		datePickerPage.selectDatePicker1();
		
		// Assert the date entered in datepicker
		
		datePickerPage.selectDatePicker2();
		
		// Assert the date entered in datepicker
		Assert.assertEquals(datePickerPage.currentActualDate2, "07/22/2020");
	}

}
