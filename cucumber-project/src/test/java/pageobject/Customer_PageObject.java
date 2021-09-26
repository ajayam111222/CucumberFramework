package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Basepage.Baseclass;
import Utility.WaitHelper;

public class Customer_PageObject {
	
	@FindBy(id="Email")
	private WebElement username;
	@FindBy(id="Password")
	private WebElement Password;
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	private WebElement Login;
	@FindBy(xpath="//h1[contains(text(),'Dashboard')] ")
	private WebElement Dashboard;
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')] ")
	private WebElement customer_feature;
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	private WebElement customer;
	@FindBy(xpath="//a[normalize-space()='Add new']")
	private WebElement AddNew;
	@FindBy(id="Email")
	private WebElement email;
	@FindBy(xpath="//input[@id='Password']")
	private WebElement password_customerinfo ;
	@FindBy(id="FirstName")
	private WebElement FirstName;
	@FindBy(id="LastName")
	private WebElement LastName;
	@FindBy(id="Gender_Male")
	private WebElement Gender_Male;
	@FindBy(css="#DateOfBirth")
	private WebElement DateOfBirth;
	@FindBy(id="Company")
	private WebElement Company;
	@FindBy(id="IsTaxExempt")
	private WebElement IsTaxExempt;
	@FindBy(xpath="(//div[@role='listbox'])[1]")
	private WebElement NewsLetter;
	@FindBy(xpath="//li[contains(text(),'Your store name')]")
	private WebElement YourStoreName;
	@FindBy(xpath="//li[contains(text(),'Test store 2')]")
	private WebElement Store2;
	@FindBy(xpath="//div[@class='input-group-append input-group-required']//input[@role='listbox']")
	private WebElement customer_role;
	@FindBy(xpath="//li[normalize-space()='Administrators']")
	private WebElement administration;
	@FindBy(xpath="//li[normalize-space()='Forum Moderators']")
	private WebElement forum_moderator;
	@FindBy(xpath="//li[normalize-space()='Guests']")
	private WebElement Guest;
	@FindBy(xpath="//li[normalize-space()='Registered']")
	private WebElement Registered;
	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	private WebElement Vendor;
	@FindBy(xpath="//select[@id='VendorId']")
	private WebElement ManagerOfVendor;
	@FindBy(name ="save")
	private WebElement Save;
	@FindBy(xpath="//body/div[3]/div[1]/div[2]")
	private WebElement SuccesMessage;
	@FindBy(xpath="//div[@class='card-title']")
	private WebElement customerinfo;
	@FindBy(xpath="//span[@title='delete']")
	private WebElement delete;
	
	public WebDriver ldriver;
	  WaitHelper waiter;
		
  public  Customer_PageObject (WebDriver driver)
  {
		   ldriver=driver;
		   PageFactory.initElements(driver, this);
		   waiter=new WaitHelper();
		  
  }
  
 
	public void Username(String un,String pw)
	{  
		username.clear();
		username.sendKeys(un);
		Password.clear();
		Password.sendKeys(pw);
	}
	public void login()
	{
		Login.click();
	}
	public Boolean DashBoard()
	{
		Boolean b=Dashboard.isDisplayed();
		return b;
	}
	public void customer_feature()
	{
		customer_feature.click();
	}
    public void customer()
    {
    	customer.click();
    }
    public void AddNew()
    {
    	AddNew.click();
    }
    public void email(String email1)
    {
    	email.sendKeys(email1);
    }
	public void password_customerinfo(String pass)
	{
		password_customerinfo.sendKeys(pass);
	}
	public void firstname_lastname(String fn,String ln)
	{
		FirstName.sendKeys(fn);
		LastName.sendKeys(ln);
	}
	public void Gender()
	{
		Gender_Male.click();
	}
	public void  DateOfBirth()
	{
		   JavascriptExecutor js=(JavascriptExecutor)ldriver;
		    js.executeScript("document.querySelector('#DateOfBirth').value='09/25/2021'"); 
	}
    public void Company(String company)
    {
    	Company.sendKeys(company);
    }
   public void IsTaxExempt()
    {
	   IsTaxExempt.click();
    }
   public void NewsLetter(String store)
   {  
	   NewsLetter.click();
	   
	   if(store.equals("Your store name"))
	   {
		   //YourStoreName.click();
		   JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		   executor.executeScript("arguments[0].click();", YourStoreName);
	   }
	   else if (store.equals("Test store 2"))
	   {
		   Store2.click();
	   }
   }
   public void customer_role(String role)
   {   
	   
	   delete.click();
	   customer_role.click();
	   
	   if(role.equals("Administrators"))
	   {
		   administration.click();
	   }
	   else if(role.equals("Forum Moderators"))
	   {
		   forum_moderator.click(); 
	   }
	   else if(role.equals("Guests"))
	   {
		  // Guest.click();
		   JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		   executor.executeScript("arguments[0].click();",Guest);
	   }
	   else if(role.equals("Registered"))
	   {
		   Registered.click();
	   }
   }
   public void Vendor(int name)
   {
	   Select s=new  Select(ManagerOfVendor);
	   s.selectByIndex(name);
   }
   public void Save()
   {
	  
	   Save.click();
   }
   public Boolean SuccesMessage()
   {
	   Boolean text=SuccesMessage.isDisplayed();
	   return text;
   }
   public Boolean customerinfo() {
	  Boolean b= customerinfo.isDisplayed();
	  return b;
   }
   }