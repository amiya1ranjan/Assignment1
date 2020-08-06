package com.sample.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sample.qa.base.TestBase;

import com.sample.qa.pages.newGilleteRegPage;
import com.sample.qa.util.excelLib;

public class GillRegTest extends TestBase {

	newGilleteRegPage RegPageTest;

	public GillRegTest() {
		super();
	}

	// @BeforeMethod
	@BeforeClass
	@Parameters("url")
	public void setup(String url) {
		initialization(url);
		RegPageTest = new newGilleteRegPage();
	}

	 @DataProvider
	public Object[][] getRegData() throws InvalidFormatException, IOException {
		Object data[][] = excelLib.getTestData("Sheet1");
		return data;
	}

	 @Test(priority=2,dataProvider="getRegData")
	public void AGillPageRegTest(String fname, String lname, String email, String pwd, String confpwd, String month,
			String year, String pin) {

		RegPageTest.RegisterIndia(fname, lname, email, pwd, confpwd, month, year, pin);

	}

	@DataProvider
	public Object[][] getRegDataAus() throws InvalidFormatException, IOException {
		Object data[][] = excelLib.getTestData("Sheet2");
		return data;
	}

	@Test(priority=1,dataProvider="getRegDataAus")
	public void BGillPageRegTestAustria(String name,String emaild,String confemaild,String apwd,String aconfpwd,String refercode) {

		RegPageTest.RegisterAustria(name, emaild, confemaild, apwd, aconfpwd, refercode);

	}
}
