package com.sample.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.qa.base.TestBase;

public class SelectPage extends TestBase{
	
	
	//Page Factory-OR
	
	
	@FindBy(xpath="//a[text()='Interactions ']")
	WebElement inetractionsTab;
	
	@FindBy(xpath="//a[text()='Selectable ']")
	WebElement SelectableOption;
	
	
	@FindBy(xpath="//a[@href='#Default' and @class='analystic']")
	WebElement DefaultFunctionality;
	
	@FindBy(xpath="//*[@id=\"Default\"]/ul/li[1]")
	//@FindBy(xpath="//div[@id='Serialize']")	
	WebElement Readibility;
	
	@FindBy(xpath="//*[@id=\"Default\"]/ul/li[2]")
	WebElement SinglelineCoding;
	
	@FindBy(xpath="//*[@id=\"Default\"]/ul/li[3]")
	WebElement MethodChaining;
	
	@FindBy(xpath="//*[@id=\"Default\"]/ul/li[4]")
	WebElement CrossBrowserTesting;
	
	
	@FindBy(xpath="//*[@id=\"Default\"]/ul/li[5]")
	WebElement ExtentReports;
	
	@FindBy(xpath="//*[@id=\"Default\"]/ul/li[6]")
	WebElement DataDrivenTesting;
	
	@FindBy(xpath="//*[@id=\"Default\"]/ul/li[7]")
	WebElement FunctionalTesting;
	
	@FindBy(xpath="//a[@href='#Serialize' and @class='analystic']")
	WebElement Serialize;
	
	@FindBy(xpath="//span[@id='result']")
	WebElement textmsgselect;
	
	//serialize xpath
	
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[1]")
	//@FindBy(xpath="//div[@id='Serialize']")	
	WebElement SReadibility;
	
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[2]")
	WebElement SSinglelineCoding;
	
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[3]")
	WebElement SMethodChaining;
	
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[4]")
	WebElement SCrossBrowserTesting;
	
	
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[5]")
	WebElement SExtentReports;
	
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[6]")
	WebElement SDataDrivenTesting;
	
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[7]")
	WebElement SFunctionalTesting;

	public String msgsel;
		
	
	//initializing the Page objects
	public SelectPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void Selectitems() {
		
		inetractionsTab.click();
		SelectableOption.click();
		SeletItems();
		
		Serialize.click();
		
		//explicitwait(Readibility);
		//SeletItems();
		SReadibility.click();
		SSinglelineCoding.click();
		SMethodChaining.click();
		SCrossBrowserTesting.click();
		SExtentReports.click();
		SDataDrivenTesting.click();
		SFunctionalTesting.click();
		
		String msgsel=textmsgselect.getText();
		System.out.println(msgsel);
		this.msgsel=msgsel;
		
		
		}
	
	
	public void SeletItems()
	{
		Readibility.click();
		SinglelineCoding.click();
		MethodChaining.click();
		CrossBrowserTesting.click();
		ExtentReports.click();
		DataDrivenTesting.click();
		FunctionalTesting.click();
	}
	
	public void explicitwait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		 
        wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String getPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	}
	
	

