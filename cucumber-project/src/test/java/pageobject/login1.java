package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login1{
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	private WebElement login;
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcome;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logout;


    
	WebDriver ldriver;
	
	
	public login1 (WebDriver driver)
	{
	   ldriver=driver;
	   PageFactory.initElements(driver, this);
	}
	

	public void  username1(String un)
	{
		username.sendKeys(un); 
		
	}
	
	public void password1(String pw)
	{
		password.sendKeys(pw);
	}
	
	public void login_button()
	{
		login.click();
	}
	
	public void welcome()
	{
		welcome.click();
	}

	public void logout()
   {
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", logout);
   }
	 
}
