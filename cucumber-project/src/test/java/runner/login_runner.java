package runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		          features= {"C:\\Users\\Ajay AM\\eclipse-workspace\\New folder\\cucumber-project\\Feature"},
		          glue= {"stepdefinition"},
		          monochrome = true,
		          dryRun = false,
		          //tags = "@sanity",
		        		 
		         plugin = {"pretty", "html:test-out"}
		          
                 )


public class login_runner {
	
	
	
	
	
	

}
