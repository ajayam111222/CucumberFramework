package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomer_pageobject {

	@FindBy(id="SearchEmail")
	private WebElement email;
	@FindBy(id="SearchFirstName")
	private WebElement firstname;
	@FindBy(id="SearchLastName")
	private WebElement lastname;
	@FindBy(id="SearchCompany")
	private WebElement company;
	@FindBy(id="search-customers")
	private WebElement Search;
	
	By listofelement=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr/td[2]");
	
	
	WebDriver ldriver;
	
	public SearchCustomer_pageobject(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
	}
	
	public void Email(String emai)
	{
		email.sendKeys(emai);
	}
	public void firstname_lastname(String un,String ln)
	{
		firstname.sendKeys(un);
		lastname.sendKeys(ln);
	}
	public void company(String comp)
	{
		company.sendKeys(comp);
	}
	public void Search()
	{
		 Search.click();
	}
	public boolean verifyUserAvailable()
	{
		
	 int size=ldriver.findElements(listofelement).size();
	 System.out.println("number of user"+size);
	 
	 for(int i=1;i<size;i++)
	 {
		String text= ldriver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+i+"]/td[2]")).getText();
		System.out.println(text);
		if(text.equals("steve_gates@nopCommerce.com"))
		{
			return true;
		}
		
		
	 }
	return false;
		
		
		
		
	}
}
