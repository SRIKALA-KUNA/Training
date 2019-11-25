package step_definations;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import base.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import testrunner.RestAssuredClass;
import utils.Utils;


public class HomePageStepDefination {
	Base base;
	WebDriver driver;
	HomePage home ;
	RestAssuredClass rest = new RestAssuredClass();
	final static Logger logger  = Logger.getLogger(HomePageStepDefination.class); 
	private List<String> actual = new ArrayList<String>();
	private final List<String> expected = new ArrayList<String>(Arrays.asList("https://www.makemytrip.com/flights/",
			"https://www.makemytrip.com/hotels/",
			"https://www.makemytrip.com/homestays/",
			"https://www.makemytrip.com/holidays-india/",
			"https://www.makemytrip.com/railways/",
			"https://www.makemytrip.com/bus-tickets/",
			"https://www.makemytrip.com/cabs/",
			"https://www.makemytrip.com/visa/",
			"https://www.makemytrip.com/gift-cards/?intid=Header_ch_giftcard"));
	
	@Given("^user is opening home Page$")
	public void inHomePage(){
		base = new Base();
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		home = new HomePage(driver);
		driver.get(Utils.baseUrl);
	}


	@When("^title of home page$")
	public void titleOfHomePage(){
		String title = driver.getTitle();
		assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday", title);
	}


	@Then("^verify navigation links$")
	public void verifyNavigationLinks(){
		try {
			actual = home.verifyNavigationLinks();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(actual, expected );
	}

	@Then("^verify broken links$")
	public void verifyBrokenLinks(){
		List<String> footerLinks = home.verifyFooterLinks();
		//RestAssuredClass.verifyFooterLinksThroughtRestAssured(footerLinks);
		for (String href : footerLinks) {
			try {
				int responseCode = rest.getStatusCode(href);
				if(responseCode != 200)
				{
					logger.info(href+"server problem");	

				}
			} catch (Exception e) {

				logger.error(e);
			}
		}
		
	
		
	}

	
	@Then("^verify more options$")
	public void verifyMoreOptions(){
		String actual;
		try {
			actual = home.verifyDealsLink();
			assertEquals(actual,Utils.baseDealsUrl);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	

}
