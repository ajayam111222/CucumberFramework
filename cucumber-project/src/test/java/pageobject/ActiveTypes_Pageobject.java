package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveTypes_Pageobject {

	@FindBy(xpath="//p[normalize-space()='Activity Types']")
	private WebElement ActiveType;
	@FindBy(xpath="	//div[@class='dataTables_scrollHeadInner']//input[@type='checkbox']")
	private WebElement IsEnabled;
	
	By list=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr/td[2]/input[1]");
	
    WebDriver ldriver;
	public ActiveTypes_Pageobject(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(ldriver,this);
	}
	
	public void ActiveType()
	{
		 //ActiveType.click();
		 JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		 executor.executeScript("arguments[0].click();", ActiveType);
		 
	}
	public void IsEnabled()
	{
		IsEnabled.click();
	}
	
	public boolean CheckAllOptionSelected()
	{
		
		int size=ldriver.findElements(list).size();
		System.out.println(size);
		for(int i=1;i<=size;i++)
		{
			WebElement element=ldriver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+i+"]/td[2]/input[1]"));
		   Boolean b= element.isSelected();
		   System.out.println("element is selected"+i);
		    if(b==false)
		    {
		     System.out.println("element is not selected");	
		     return false;
		     
		    }
		  
		    
		}
		return true;
		
		
		
	}
	
}
