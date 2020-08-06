package com.sample.qa.pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sample.qa.base.TestBase;

public class RegisterPage extends TestBase{
	
	public String expectedmail="test";
	public String num;
	
	//Page Factory-OR
				
		@FindBy(xpath="//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]/input[@type=\"text\" and @placeholder=\"First Name\"]")
		WebElement firstname;
		
		@FindBy(xpath="//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]/input[@type=\"text\" and @placeholder=\"Last Name\"]")
		WebElement lastname;
		
		@FindBy(xpath="//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]/input[@type=\"email\" ]")
		WebElement email;
		
		@FindBy(xpath="//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]/input[@type=\"tel\" ]")
		WebElement phone;
		
		@FindBy(xpath="//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]/label/input[@value='Male']")
		WebElement gender;
		
		@FindBy(xpath="//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]/select[@type='text' and @id='countries']")
		WebElement country;
		
		
		
		@FindBy(xpath="//div[@class=\"col-md-3 col-xs-3 col-sm-3\"]/select[@id='yearbox']")
		WebElement year;
		
		@FindBy(xpath="//div[@class=\"col-md-3 col-xs-3 col-sm-3\"]/select[@placeholder='Month']")
		WebElement month;
		
		@FindBy(xpath="//div[@class=\"col-md-3 col-xs-3 col-sm-3\"]/select[@id='daybox']")
		WebElement day;
		
		@FindBy(xpath="//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]/input[@id='firstpassword']")
		WebElement pwd;
		
		@FindBy(xpath="//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]/input[@id='secondpassword']")
		WebElement confpwd;
		
		@FindBy(xpath="//button[@id=\"submitbtn\"]")
		WebElement submit;
		
		//@FindBy(xpath="//div[@id=\"1594990788019-0-uiGrid-0005-cell\"]")
		@FindBy(xpath="//div[@class=\"ui-grid-canvas\"]/div/div[1]/div[@class=\"ui-grid-cell ng-scope ui-grid-coluiGrid-0005\"]")
		WebElement validatemail;
		
		//div[@ui-grid='gridoptions']
		@FindBy(xpath="//div[@ui-grid='gridoptions']")
		WebElement webtable;
		
		
		//div[@class="ui-grid-canvas"]/div/div[1]/div[@class="ui-grid-cell ng-scope ui-grid-coluiGrid-0005"]
		
		
		
		
		
		
			
		
		
		
		//initializing the Page objects
		public RegisterPage()
		{			PageFactory.initElements(driver, this);
			
		}
		
		public String submitform(String pwds,String fname,String lname,String mid,String pnum,String nation,String yr,String dy,String cpwd)
		{
			
			Random rand = new Random();
			
			firstname.clear();
			//firstname.sendKeys("testusera");
			firstname.sendKeys(fname);
			
			lastname.clear();
			//lastname.sendKeys("testuserb");
			lastname.sendKeys(lname);
			
			
			email.clear();
			//email.sendKeys(expectedmail+rand.nextInt(88888)+"@test.com");
			email.sendKeys(mid);
			phone.clear();
			
			
			//String num2="99999"+ (rand.nextInt(11111)+11111);
			
			//phone.sendKeys(num2);
			
			phone.sendKeys(pnum);
			
			
			
			gender.click();
			
			country.click();
			String num1=phone.getText();
			
			
			
			Select countrySel=new Select(country);
			
			//countrySel.selectByValue("India");
			countrySel.selectByValue(nation);
			
			year.click();
			Select yearsel=new Select(year);
			//yearsel.selectByVisibleText("1987");
			yearsel.selectByVisibleText(yr);
			
			month.click();
			Select monthsel=new Select(month);
			monthsel.selectByVisibleText("January");
			
			day.click();
			Select daysel=new Select(day);
			//daysel.selectByVisibleText("7");
			daysel.selectByVisibleText(dy);
			
			pwd.clear();
			pwd.sendKeys(pwds);
			
			confpwd.clear();
			//confpwd.sendKeys("Aa1234");
			confpwd.sendKeys(cpwd);
			
			
			
			
			submit.click();
			
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 //driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			String title=driver.getTitle();
			return title;
				
			
		}
		
		
		public String getMailid()
		{
			
			//get the list
			//List<WebElement> list=driver.findElements(By.)
			String emailidInserted=validatemail.getText();
			return emailidInserted;
			
			//contact.click();
			
		}
		public String getTitle()
		{
			
			//get the list
			//List<WebElement> list=driver.findElements(By.)
			String title=driver.getTitle();
			return title;
			
			//contact.click();
			
		}
		
		public WebElement elementtype(WebElement element)
		{
			return element;
		}
		
		
		

}
