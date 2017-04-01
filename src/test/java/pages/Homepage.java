package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	WebDriver driver;
	
	public Homepage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//a[text()='Candidate Login']") WebElement Signinlink;
	@FindBy(xpath="//a[text()='Jobs']") WebElement Joblink;
	@FindBy(xpath="//a[text()='Resumes']") WebElement Resumelink;
	
	
	public void clickonsigninlink()
	{
		Signinlink.click();
	}

	public void clickonjoblink()
	{
		Joblink.click();
	}

	public void clickonresumelink()
	{
		Resumelink.click();
	}
	
	public String getapplicationtitle()
	{
		return driver.getTitle();
	}

}
