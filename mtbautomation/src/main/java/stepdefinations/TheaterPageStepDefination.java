package stepdefinations;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.TheaterPage;

public class TheaterPageStepDefination {
	WebDriver driver;
	Base base;
	TheaterPage theater ; 
	@Given("^user is already in theater page$")
	public void user_is_already_in_theater_page()  {
		base = new Base();
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		theater = new TheaterPage(driver);
		
	}

	@When("^user clicks theater \"([^\"]*)\" radio button$")
	public void user_clicks_theater_radio_button(String arg1) {
	   
	}

	@When("^user clicks on search button$")
	public void user_clicks_on_search_button()  {
	    
	}

	@Then("^verify user is redirected to #next  page$")
	public void verify_user_is_redirected_to_next_page()  {
	  
	}

	@Then("^verify user is in same page$")
	public void verify_user_is_in_same_page(){
	   
	}
}
