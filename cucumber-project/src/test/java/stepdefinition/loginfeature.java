package stepdefinition ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Basepage.Baseclass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobject.ActiveTypes_Pageobject;
import pageobject.Customer_PageObject;
import pageobject.SearchCustomer_pageobject;
import pageobject.login1;

public class loginfeature extends Baseclass{
	
	@Before
	public void setup() throws IOException
	{
		log = Logger.getLogger("orange hrm");
		PropertyConfigurator.configure("log4j.properties");	
		
		FileInputStream stream=new FileInputStream("config.properties");
		pro=new Properties();
		pro.load(stream);
		String br=pro.getProperty("browser");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",pro.getProperty("chromepath"));
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",pro.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",pro.getProperty("firefoxpath"));
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		}
	
		}
	
	
	@Given(": user should open browser")
	public void user_should_open_browser() {
 
	  l=new login1(driver);
	}

	@When(":user open the URL {string} ;")
	public void user_open_the_url(String string) {
	    driver.get(string);
	    
	    log.info("------------opening application url--------------");
	}

	@Then(":Enter the username {string} and password {string} ;")
	public void enter_the_username_and_password(String un, String pw) {
		log.info("--------entering the username-------------");
		l.username1(un);
		log.info("--------entering the password-------------");
	    l.password1(pw);
	}

	@Then(": click on the login")
	public void click_on_the_login() {
		log.info("--------clicking on the login button-------------");
		l.login_button();
		
	
	}

	@Then(":user should get title {string} ;")
	public void user_should_get_title(String string) {
	log.info("--------capturing the tittle -------------");	
	 String title=driver.getTitle();
	 System.out.println(title);
	}

	@Then(":click on logout button")
	public void click_on_logout_button()
	{
	log.info("--------clicking on the logout button -------------");	
	 l.welcome();	
	 l.logout();
	}

	@Then(":user shold get title {string} ;")
	public void user_shold_get_title(String string) {
		log.info("--------capturing the tittle -------------");		
	   String title= driver.getTitle();
	   System.out.println(title);
	}

	@Then(":close the browser;")
	public void close_the_browser() {
		log.info("-----------close the browser --------------");
	    driver.quit();
	}

	//add customer feature
	@Given("Open the browser")
	public void open_the_browser() {
	c=new Customer_PageObject(driver); 
	}

	@When("Open the application URL {string}")
	public void open_the_application_url(String url) {
	  driver.get(url);  
	}

	@When("Enter the username {string} and Password {string} ;")
	public void enter_the_username_and_password1(String username, String password) {
	  c.Username(username, password);
		
	}

	@When("Click on login button")
	public void click_on_login_button() {
	   c.login();
	}

	@Then("User can view the Dashboard")
	public void user_can_view_the_dashboard() {
	  Boolean check_Dasboard=c.DashBoard();  
	  Assert.assertTrue(true);
	}

	@Then("click on Customer option")
	public void click_on_customer_option() {
	   c.customer_feature(); 
	}

	@Then("click on the customer feature")
	public void click_on_the_customer_feature() {
	  c.customer();  
	}

	@Then("Click on the Add New button")
	public void click_on_the_add_new_button() {
	  c.AddNew();  
	}

	@Then("User can view the Cutomer info page")
	public void user_can_view_the_cutomer_info_page() {
	  Boolean b=c.customerinfo();
	  Assert.assertTrue(true);
	}

	@Then("Enter the customer info")
	public void enter_the_customer_info() {
		
	  String email_pass=randomeString()+"@gmail.com";
	   c.email(email_pass);
	   c.password_customerinfo("ajay1234");
	   c.firstname_lastname("Ajay", "AM");
	   c.Gender();
	   c.DateOfBirth();
	   c.Company("wipro");
	   c.IsTaxExempt();
	   c.NewsLetter("Test store 2");
	   c.customer_role("Administrators");
	   c.Vendor(1);
	   
	}

	@Then("Click on the save button")
	public void click_on_the_save_button() {
		c.Save();
	}

	@Then("Successfull message should display with text {string}")
	public void successfull_message_should_display_with_text(String string) {
		 Boolean Actuatext= c.SuccesMessage();
		 Assert.assertTrue(true); 
	}
   
	@Then("Enter the Details in Serach Field")
	public void enter_the_details_in_serach_field() {
	    s=new SearchCustomer_pageobject(driver);
	    s.Email("steve_gates@nopCommerce.com");
	    s.firstname_lastname("Steve","Gates");
	    s.company(" ");
	}

	@Then("click search button")
	public void click_search_button() {
	    s.Search();
	}

	@Then("Verify the customer is Available in Search Field")
	public void verify_the_customer_is_available_in_search_field() {
        
		Boolean Actual=s.verifyUserAvailable();
		Assert.assertEquals(Actual, expected);
	}

	@Then("close the browser")
	public void close_the_browser1() {
		driver.close(); 
	}
	
	
   @Then("close browser")
	public void close_browser() {
	    driver.close();
	}
   @Then("click on Active Type feature")
   public void click_on_active_type_feature() throws InterruptedException {
      
	   a=new ActiveTypes_Pageobject(driver);
	   a.ActiveType();
	   Thread.sleep(3000);
   }

   @When("click on the is Enabled button")
   public void click_on_the_is_enabled_button() {
       a.IsEnabled();
   }

   @Then("verify all button is selected or not")
   public void verify_all_button_is_selected_or_not() {
     Boolean actual=  a.CheckAllOptionSelected();
     Assert.assertEquals(actual, expected);
   }
	
	
}
