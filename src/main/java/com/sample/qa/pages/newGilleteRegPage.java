package com.sample.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.qa.base.TestBase;

public class newGilleteRegPage extends TestBase {

	// Page Factory-OR

	@FindBy(xpath = "//a[@title='REGISTER']")
	WebElement RegisterMenu;

	@FindBy(xpath = "//span[text()='Firstname']/following-sibling::input")
	WebElement firstname;

	@FindBy(xpath = "//span[text()='Last Name']/following-sibling::input")
	WebElement lastname;

	@FindBy(xpath = "//span[text()='Email']/following-sibling::input")
	WebElement emaild;

	@FindBy(xpath = "//span[text()='Password']/following-sibling::input")
	WebElement Pwd;

	@FindBy(xpath = "//span[text()='Confirm Password']/following-sibling::input")
	WebElement ConfPwd;

	@FindBy(xpath = "//select[contains(@data-key,'month')]")
	WebElement Bdmonth;

	@FindBy(xpath = "//select[contains(@data-key,'year')]")
	WebElement Bdyear;

	@FindBy(xpath = "//span[text()='Zip code']/following-sibling::input")
	WebElement pincode;

	// input[@type='submit']

	// @FindBy(xpath="//span[text()='Zip code']/following-sibling::input")

	@FindBy(xpath = "//input[@value='Create your Profile']")
	WebElement submit;

	@FindBy(xpath = "//span/input[@type='checkbox']")
	WebElement chkbox;

	@FindBy(xpath = "//a[@href='#myModal-country']")
	WebElement countrytab;

	@FindBy(xpath = "//a[@title='Austria Deutsch']")
	WebElement SelectAustria;

	@FindBy(xpath = "//a[@title='Austria Deutsch']")
	WebElement AustriaRegmenu;

	//@FindBy(xpath = "//a[@class='responsiveAccountHeader_accountRegister']")
	
	@FindBy(xpath = "//li/a[@class='responsiveAccountHeader_accountRegister']")
	WebElement AustriaReg;
	
	@FindBy(xpath = "//span[text()='KONTO']")
	WebElement Konto;
	
	@FindBy(xpath = "//button[text()='Alle Cookie akzeptieren']")
	WebElement acceptCookies;
	
	
	@FindBy(xpath = "//input[@id='customerName']")
	WebElement cutomerName;
	
	@FindBy(xpath = "//input[@id='customerEmail']")
	WebElement email;
	
	
	@FindBy(xpath = "//input[@id='confirmCustomerEmail']")
	WebElement confemail;
	
	@FindBy(xpath = "//input[@id='customerPassword']")
	WebElement pwd;
	
	
	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement conpwd;
	
	@FindBy(xpath = "//input[@id='referrerCode']")
	WebElement refcode;
	
	
	@FindBy(xpath = "//button[@id='continue']")
	WebElement submitbtn;
	


	// initializing the Page objects
	public newGilleteRegPage() {
		PageFactory.initElements(driver, this);

	}

	public void RegisterIndia(String fname,String lname,String email,String pwd,String confpwd,String month,String year,String pin) {
		RegisterMenu.click();

		
		firstname.sendKeys(fname);
		
		lastname.sendKeys(lname);
		
		emaild.sendKeys(email);
		
		Pwd.sendKeys(pwd);
		
		ConfPwd.sendKeys(confpwd);
		Bdmonth.click();
		Select bmonth = new Select(Bdmonth);
		bmonth.selectByVisibleText(month);

		Bdyear.click();
		Select Year = new Select(Bdyear);
		Year.selectByVisibleText(year); 
		pincode.sendKeys(pin);

		chkbox.click();
		
		Actions act = new Actions(driver);
		act.moveToElement(submit).doubleClick().perform();

		
		

	}

	public void RegisterAustria(String name, String emaild, String confemaild,String apwd, String aconfpwd,String refercode) {
		
		countrytab.click();
		explicitwait(SelectAustria);
		 
		SelectAustria.click();
		Set<String> set=driver.getWindowHandles();
		
		
		  Iterator<String> it=set.iterator(); 
		  String parentWid=it.next(); 
		  String childwiddef=it.next(); 
		  String childwid=it.next();
		  System.out.println("from single new win parent:"+parentWid); 
		  System.out.println("from single new win child id:"+childwid);
		 
		
		
		driver.switchTo().window(childwid);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title=driver.getTitle();
		
		System.out.println(title);
		
		
		
		Actions act = new Actions(driver);
		act.moveToElement(Konto).perform();
		System.out.println("after mosue hovering");
		act.moveToElement(AustriaReg).click().perform();
		String title1=driver.getTitle();
		System.out.println(title1);
		
		
		while(!"Konto Anlegen | Gillette Deutschland".equals(title1))
		{
			Actions act1 = new Actions(driver);
			act.moveToElement(Konto).perform();
			System.out.println("inside while");
			act.moveToElement(AustriaReg).click().perform();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String title2=driver.getTitle();
			System.out.println(title2);
			title1=title2;
			
			
		}
		
		
		cutomerName.sendKeys(name);
		email.sendKeys(emaild);
		confemail.sendKeys(confemaild);
		pwd.sendKeys(apwd);
		conpwd.sendKeys(aconfpwd);
		refcode.sendKeys(refercode);
		System.out.println("after pincode");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This  will scroll down the page by  1000 pixel vertical		
		   js.executeScript("window.scrollBy(0,500)");
		explicitwait(submitbtn);
		
		
		
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(submitbtn).doubleClick().perform();
		//submitbtn.click();
		System.out.println("after click");
		
		

	}
	
	public void explicitwait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOf(element));
	}

}
