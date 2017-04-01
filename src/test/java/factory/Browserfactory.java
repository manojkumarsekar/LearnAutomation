package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browserfactory {
	
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName)
	{
	if(browserName.equalsIgnoreCase("firefox"))
	{
		
		System.setProperty("webdriver.firefox.driver", Datafactory.getconfig().getfirefoxpath());
		driver = new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("chrome"))
	{
		
		System.setProperty("webdriver.chrome.driver",Datafactory.getconfig().getchromepath());
		driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("IE"))
	{
		
		System.setProperty("webdriver.ie.driver",Datafactory.getconfig().getIepath());
		driver = new InternetExplorerDriver();
	}
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
	}

	public static void closeBrowser(WebDriver idriver)
	{
	
		idriver.quit();
		
	}
	
}
