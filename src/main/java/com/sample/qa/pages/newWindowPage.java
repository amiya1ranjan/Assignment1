package com.sample.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.qa.base.TestBase;

public class newWindowPage extends TestBase{
	
	//Page Factory-OR
		
	
	@FindBy(xpath="//a[text()='SwitchTo']")
	WebElement switchtab;
	
	@FindBy(xpath="//a[text()='Windows']")
	WebElement Windows;
	
	@FindBy(xpath="//a[text()='Open New Tabbed Windows ']")
	WebElement newTabwindow;
	
	//@FindBy(xpath="//button[text()='click']")
	@FindBy(xpath="//a/button[@class='btn btn-info']")
	WebElement clickBtn;
	
	
	@FindBy(xpath="//a[text()='Open New Seperate Windows']")
	WebElement SepWin;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement clickSepWinBtn;
	
	
	@FindBy(xpath="//span[contains(text(),'Welcome')]")
	WebElement newWinheaderText;
	

	@FindBy(xpath="//a[text()='Open Seperate Multiple Windows']")
	WebElement multiwin;
	
	@FindBy(xpath="//button[@onclick='multiwindow()']")
	WebElement multiwinBtn;
	 

	public String ActualNewwindowTitle;

	public String NewWinheaderTxt;

	public String childwid2;

	public String nxtMultiWinTitle;

	public String nxtMultiWinTitle2;

	public String childwid;
	 
		//initializing the Page objects
		public newWindowPage()
		{
			PageFactory.initElements(driver, this);
			
		}
		public void newWindowfunction() {
			
			switchtab.click();
			Windows.click();
			newTabwindow.click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clickBtn.click();
			
			Set<String> set=driver.getWindowHandles();
			
			
			  Iterator<String> it=set.iterator(); 
			  String parentWid=it.next(); 
			  String childwiddef=it.next(); 
			  String childwid=it.next();
			  System.out.println("from single new win parent:"+parentWid); 
			  System.out.println("from single new win child id:"+childwid);
			 
			
			
			driver.switchTo().window(childwid);
			
			
			
			  WebDriverWait wait = new WebDriverWait(driver,30);
			  wait.until(ExpectedConditions.visibilityOf(newWinheaderText));
			 
			 
			
			String ActualNewwindowTitle=driver.getTitle();
			System.out.println("new Windowid is:" +ActualNewwindowTitle);
			this.ActualNewwindowTitle=ActualNewwindowTitle;
			
			
		}
	
	public void seperateWindow()
	{
		switchtab.click();
		Windows.click();
		SepWin.click();
		clickSepWinBtn.click();
		String currentWinTitle=driver.getTitle();
		System.out.println("current win title:" + currentWinTitle);
		//driver.switchTo().window(getWinId());
		//getWinId();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		String parentid=it.next();
		String childdef=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		
		String ActualNewwindowTitle=driver.getTitle();
		System.out.println("new Windowid is:" +ActualNewwindowTitle);
		String NewWinheaderTxt=newWinheaderText.getText();
		this.NewWinheaderTxt=NewWinheaderTxt;
		System.out.println("new hearder text:"+ NewWinheaderTxt);
		
		
	}
	
	public void multiWindow()
	{
		switchtab.click();
		Windows.click();
		multiwin.click();
		multiwinBtn.click();
		
		String currentWinTitle=driver.getTitle();
		System.out.println("current win title:" + currentWinTitle);
		//driver.switchTo().window(getWinId());
		//driver.switchTo().window(childwid);
		
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		String parentid=it.next();
		String childdef=it.next();
		String childId=it.next();
		String childwid2=it.next();
		driver.switchTo().window(childId);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nxtMultiWinTitle=driver.getTitle();
		System.out.println(nxtMultiWinTitle);
		this.nxtMultiWinTitle=nxtMultiWinTitle;
		
		driver.switchTo().window(childwid2);
		String nxtMultiWinTitle2=driver.getTitle();
		this.nxtMultiWinTitle2=nxtMultiWinTitle2;
		System.out.println("2nd one:"+nxtMultiWinTitle2);
	
		
		
	}
	
	
	
	public void getWinId()
	{
		Set<String> set=driver.getWindowHandles();
		int i=set.size();
		System.out.println(i);
		String winid[]= new String[i];
		for(int j=0;j<i;j++)
		{
			Iterator<String> it=set.iterator();
			winid[j]=it.next();
		}
		
		if(i==3)
		{
			String parentWid=winid[0];
			String childwiddef=winid[1];
			String childwid=winid[2];
			System.out.println("p:"+ parentWid);
			System.out.println("d:"+ childwiddef);
			System.out.println("child:"+ childwid);
			this.childwid=childwid;
		}
		else if(i==4)
		{
			String parentWid=winid[0];
			String childwiddef=winid[1];
			String childwid=winid[2];
			String childwid2=winid[3];
			this.childwid2=childwid2;
			this.childwid=childwid;
			
			
		}
		
		
		
		//return childwid2;
		
	}
	
	
	public void ExplicitWait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOf(element));
	}

}
