package com.Automation.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utilities 
{
	WebDriver driver;
	String url;
	public WebDriver StartBrowser(String browserName,String URL)
	{
		if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("Chrome"))
		{
			  System.setProperty("webdriver.chrome.driver", "D:\\Software\\LatestChromeDriver\\chromedriver.exe");
	    	  driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
		
	}
	
	public String getURL() 
	{
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(new File("./config.properties"));
			//BufferedReader b1=new BufferedReader(new FileReader("./config.properties"));
		} 
		catch (FileNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop=new Properties();
		try 
		{
			prop.load(fis);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=prop.getProperty("URL");
		System.out.println("URL ::" + url);
		return url;
		
		
	}
}
