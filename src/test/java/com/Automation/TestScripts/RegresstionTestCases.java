package com.Automation.TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Automation.Pages.HomePage;
import com.Automation.Utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegresstionTestCases 
{
	Utilities factory=new Utilities();
	ExtentReports extent;
	ExtentTest Logger;
	String url=factory.getURL();
	
	WebDriver driver=factory.StartBrowser("Chrome", url);
	
	HomePage hp=PageFactory.initElements(driver, HomePage.class);
	
	
  //Verify Luanching Login page
	@BeforeTest
	
	public void startreport()
	{
	
	  extent=new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	
	}
	
	@Test
	public void AppLaunch()
	{
		Logger=extent.startTest("Starting Test");
		hp.clicMyAccountButton();
		hp.verifyLaunchingOnRegistration();
		Logger.log(LogStatus.INFO, "Browser Luanched successfully@");
		extent.endTest(Logger);
		
	}
	

	@AfterMethod
	
	 public void getResult(ITestResult result)
	 {
		 if(result.getStatus() == ITestResult.FAILURE)
		 {
		 Logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		 Logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		 }
		 else if(result.getStatus() == ITestResult.SKIP)
		 {
		 Logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
		 else if(result.getStatus() == ITestResult.SUCCESS)
		 {
			 Logger.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
		 }
		 
	 }	 
		 // 
	
	@AfterTest
	
	public void endreport()
	{
		extent.flush();
		extent.close();
		driver.close();
	 
	}
	

}
