package com.sample.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sample.qa.base.TestBase;

public class framesPage extends TestBase{
	
	
	//Page Factory-OR
	@FindBy(xpath="//a[text()='SwitchTo']")
	WebElement switchtab;
	
	@FindBy(xpath="//a[text()='Frames']")
	WebElement Frameoption;
	
	@FindBy(xpath="//a[text()='Single Iframe ']")
	WebElement SingleFrameBtn;
	
	@FindBy(xpath="//a[text()='Iframe with in an Iframe']")
	WebElement FrameWithinBtn;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement SingleFrameTxtB;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement FrameWithinTxtB;
	
	@FindBy(xpath="/html/body/section/div/div/iframe")
	WebElement FrameWithinElement;
	
	
	@FindBy(xpath="//iframe[@src='MultipleFrames.html']")
	WebElement multiframe;

	public String textFrame1;

	public String textFrame2;
	
	
	
	
	
	//initializing the Page objects
	public framesPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	// listing out all selectable elements name
	public void frameTest()
	{
		switchtab.click();
		Frameoption.click();
		SingleFrameBtn.click();
		driver.switchTo().frame("singleframe");
		SingleFrameTxtB.sendKeys("TestSingleFrame");
		
		driver.switchTo().defaultContent();
		FrameWithinBtn.click();
		//driver.switchTo().frame("Iframe with in an Iframe");
		
		List<WebElement> f = driver.findElements(By.xpath("//iframe"));
		int k=f.size();
		System.out.println("frame size is:"+ k);
		
		driver.switchTo().frame(multiframe);
		System.out.println("After multi");
		driver.switchTo().frame(0);
		FrameWithinTxtB.sendKeys("Test Iframe with in an Iframe");
		
		System.out.println("after input for 2nd frame");
		
		//verify text entered in first frame
		driver.switchTo().defaultContent();
		SingleFrameBtn.click();
		driver.switchTo().frame("singleframe");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SingleFrameTxtB.click();
		
		String textFrame1=SingleFrameTxtB.getText();
		this.textFrame1=textFrame1;
		System.out.println("single Frame Text is :"+textFrame1);
		
		//verify text entered in  frame within frame
		driver.switchTo().defaultContent();
		FrameWithinBtn.click();
		
		//driver.switchTo().frame("Iframe with in an Iframe");
		driver.switchTo().frame(0);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FrameWithinTxtB.click();
		String textFrame2=FrameWithinTxtB.getText();
		this.textFrame2=textFrame2;
		System.out.println("Frame within Frame Text is :"+textFrame2);
		
		
		
		
		
		
	}
	
	
	
	}
	
	

