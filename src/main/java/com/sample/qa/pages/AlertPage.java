package com.sample.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sample.qa.base.TestBase;

public class AlertPage extends TestBase {

	// Page Factory-OR

	@FindBy(xpath = "//a[text()='SwitchTo']")
	WebElement switchtab;

	@FindBy(xpath = "//a[text()='Alerts']")
	WebElement Alertoption;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement AlertdisplayButton;

	@FindBy(xpath = "//a[text()='Alert with OK & Cancel ']")
	WebElement ALertwithOKCancel;

	@FindBy(xpath = "//p[text()='You pressed Ok']")
	WebElement Okmsg;

	@FindBy(xpath = "//p[text()='You Pressed Cancel']")
	WebElement Cancelmsg;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement AlertConfButton;

	@FindBy(xpath = "//a[text()='Alert with Textbox ']")
	WebElement AlertWithTextBox;

	@FindBy(xpath = "//button[@class='btn btn-info']")
	WebElement AlertPromptBox;

	@FindBy(xpath = "//p[@id='demo1']")
	WebElement AlertTextboxmsg;

	public String Okmessage;

	public String Cancelmessage;

	public String txtmsg;

	// initializing the Page objects
	public AlertPage() {
		PageFactory.initElements(driver, this);

	}

	public void alertOKfunction() {

		switchtab.click();
		Alertoption.click();
		AlertdisplayButton.click();

		Alert alt = driver.switchTo().alert();
		alt.accept();

	}

	public void alertConfunction() {

		switchtab.click();
		Alertoption.click();
		ALertwithOKCancel.click();

		AlertConfButton.click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		String Okmessage = Okmsg.getText();
		this.Okmessage = Okmessage;

		AlertConfButton.click();
		alt.dismiss();
		String Cancelmessage = Cancelmsg.getText();
		this.Cancelmessage = Cancelmessage;

	}

	public void alertTextboxfunction() {

		switchtab.click();
		Alertoption.click();
		AlertWithTextBox.click();

		AlertPromptBox.click();
		Alert alt = driver.switchTo().alert();

		alt.sendKeys("Amiya");
		alt.accept();
		String txtmsg = AlertTextboxmsg.getText();
		this.txtmsg = txtmsg;

		AlertPromptBox.click();
		alt.dismiss();

	}


	
	
}
