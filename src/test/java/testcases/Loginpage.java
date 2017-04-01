package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.Browserfactory;
import factory.Datafactory;
import pages.Homepage;
import pages.LoginPage;

public class Loginpage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = Browserfactory.getBrowser("firefox");
		driver.get(Datafactory.getconfig().geturl());
		
	}
	
	@Test
	public void testhomepage()
	{
		Homepage home = PageFactory.initElements(driver,Homepage.class);
		String title = home.getapplicationtitle();
		Assert.assertTrue(title.contains("wpjobboard"));
		home.clickonsigninlink();
		LoginPage logins=PageFactory.initElements(driver,LoginPage.class);
		logins.loginApplication(Datafactory.getexcel().getdata(0,0,0),Datafactory.getexcel().getdata(0,0,1));
		logins.verifysignout();
			
	}
	
	@AfterMethod
		public void teardown()
		{
			Browserfactory.closeBrowser(driver);
		}
		
		
	}


