package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Browserfactory;
import factory.Datafactory;
import pages.Homepage;
import pages.LoginPage;
import utility.Helper;

public class Loginpagewithreports_screenshot {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup()
	{
		report = new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		logger =report.startTest("verify test login");
		driver = Browserfactory.getBrowser("firefox");
		driver.get(Datafactory.getconfig().geturl());	
		logger.log(LogStatus.INFO,"Application is up and running");
		
	}
	
	@Test
	public void testhomepage()
	{
		Homepage home = PageFactory.initElements(driver,Homepage.class);
		String title = home.getapplicationtitle();
		Assert.assertTrue(title.contains("wpjobboard"));
		logger.log(LogStatus.PASS,"home page loaded and verified");
		home.clickonsigninlink();
		logger.log(LogStatus.INFO,"Click on Signin link");
		LoginPage logins=PageFactory.initElements(driver,LoginPage.class);
		logins.loginApplication(Datafactory.getexcel().getdata(0,0,0),Datafactory.getexcel().getdata(0,0,1));
		logger.log(LogStatus.INFO,"login to application");
		logins.verifysignout();
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"validation1 ")));
		logger.log(LogStatus.INFO,"signoutlink is present");
	}
	
	@AfterMethod
		public void teardown(ITestResult result)
		{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
		String path=Helper.captureScreenshot(driver,result.getName());
		logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
		}

			Browserfactory.closeBrowser(driver);
			report.endTest(logger);
			report.flush();
		}
		
		
	}


