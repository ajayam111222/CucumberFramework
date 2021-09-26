package Basepage;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.ActiveTypes_Pageobject;
import pageobject.Customer_PageObject;
import pageobject.SearchCustomer_pageobject;
import pageobject.login1;

public class Baseclass {
	
	public  WebDriver driver;
	public login1 l;
	public Customer_PageObject c;
	public  SearchCustomer_pageobject s;
	public ActiveTypes_Pageobject a;
    public Logger log;
    public Properties pro;
    public Boolean  expected=true;
	
	
    public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	
	

}
