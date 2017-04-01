package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	
	{
		this.driver=ldriver;
	}
	
	
	@FindBy(id="user_login") WebElement loginid;
	@FindBy(name="user_password") WebElement Password;
	@FindBy(name="user_password") WebElement signin;
	By Signout = By.xpath(".//*[@id='wpjb-custom-menu-2']/h3");


	public void loginApplication(String user, String pass)
	{
	loginid.sendKeys(user);
	Password.sendKeys(pass);
	signin.click();

	}
	
	public void verifysignout()
	{
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement ele =wait.until(ExpectedConditions.presenceOfElementLocated(Signout));
	String text = ele.getText();
	Assert.assertEquals(text,"CUSTOMIZABLE MENU","Signout Link not verified properly");
	}

}
