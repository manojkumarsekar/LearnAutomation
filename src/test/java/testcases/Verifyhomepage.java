package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.Browserfactory;
import factory.Datafactory;
import pages.Homepage;

public class Verifyhomepage {
	
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
		System.out.println("My application title is " + title);
	
	}
	
	@AfterMethod
		public void teardown()
		{
			Browserfactory.closeBrowser(driver);
		}
		
		
	}


