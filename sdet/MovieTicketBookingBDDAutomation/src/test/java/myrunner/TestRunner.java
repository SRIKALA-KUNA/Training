package myrunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "./src/main/java/features", 
			glue={"stepdefinitions"},
			tags= {"@movie"}	
			)
	 
	public class TestRunner {
	 
	}
