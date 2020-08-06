package com.sample.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sample.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	static Properties prop;
	
	
	public TestBase()
	{
		
		prop=new Properties();
		try {
			//FileInputStream fis=new FileInputStream("/Users/91702/git/repository/MySampleTest/src/main/java/com/sample/qa/config/config.properties");
			//C:\New folder\newProject\src\main\java\com\sample\qa\config\config.properties
			
			FileInputStream fis=new FileInputStream("C:\\New folder\\newProject\\src\\main\\java\\com\\sample\\qa\\config\\config.properties");
			
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization(String url)
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "/Users/91702/git/repository/MySampleTest/chromedriver.exe");
			//C:\New folder\newProject\chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "C:\\New folder\\newProject\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("FF"))
		{
				System.setProperty("webdriver.gecko.driver", "C://NewSoft/geckodriver-v0.26.0-win64/geckodriver.exe");
				driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	
		
		
		driver.get(prop.getProperty(url));
		
		
		
		
				
		
			
		}
	
	}
	


