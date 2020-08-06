package com.sample.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sample.qa.base.TestBase;

public class DatePickerPage extends TestBase{
	
	
	//Page Factory-OR
	
	@FindBy(xpath="//a[text()='Widgets']")
	WebElement Widgets;
	
	@FindBy(xpath="//a[text()=' Datepicker ']")
	WebElement datepicker;
	
	@FindBy(xpath="//img[@class='imgdp']")
	WebElement DatePicker1;
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-highlight ui-state-hover']")
	//@FindBy(xpath="//a[@class='ui-state-default ui-state-highlight']")
	
	WebElement currentDate1;
	
	@FindBy(xpath="//input[@id='datepicker2']")
	WebElement DatePicker2;
		
	@FindBy(xpath="//a[contains(@class,'datepick-today')]")
	//@FindBy(xpath="//a[(text()='21')]")
	////div[@class='datepick']//following::table/tbody/tr/*/a[(text()='21')]
	WebElement currentDate2;
	
	//a[text()='Clear']
	@FindBy(xpath="//a[text()='Clear']")
	WebElement clear;
	
	@FindBy(xpath="Close")
	WebElement close;

	//public String currentActualDate1;

	public String currentActualDate2;
	
	
	
	
	//initializing the Page objects
	public DatePickerPage()
	{			PageFactory.initElements(driver, this);
		
	}
	
	public void selectDatePicker1()
	{
		Widgets.click();
		datepicker.click();
		DatePicker1.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentDate1.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String currentActualDate1=DatePicker1.getAttribute("value");
		
		
		//System.out.println("current date is :"+ currentActualDate1);
		//this.currentActualDate1=currentActualDate1;
		
		
	}

	public void selectDatePicker2()
	{
		Widgets.click();
		datepicker.click();
		DatePicker2.click();
		currentDate2.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DatePicker2.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		DatePicker2.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentActualDate2=DatePicker2.getAttribute("value");
		this.currentActualDate2=currentActualDate2;
		System.out.println("current date is :"+ currentActualDate2);
		//Actions act=new Actions(driver);
		//act.moveToElement(DatePicker2).doubleClick().build().perform();
		
		
		
	}

}
