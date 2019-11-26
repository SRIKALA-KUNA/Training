package step_definations;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import base.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HotelPage;
import utils.Utils;

public class HotelPageStepDefination {
	WebDriver driver;

	Base base;
	HotelPage hotelPage;
	List<String> actual = new ArrayList<String>();
	List<String> expected = new ArrayList<String>() ;

	@Given("^user is opening hotel page$")
	public void user_is_opening_hotel_page(){
		base = new Base();
		try {
			base= new Base();
			driver = base.getDriver();
			hotelPage = new HotelPage(driver);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get(Utils.baseHotelsUrl);
	}


	@When("^verify url of hotel page$")
	public void verify_url_of_hotel_page() throws InterruptedException{
		Utils.wait(20);
		String url = driver.getCurrentUrl();
		assertEquals(Utils.baseHotelsUrl, url);
	}


	@Then("^verify hotel booking$")
	public void verify_hotel_booking(){
		try {

			assertTrue(true,hotelPage.verifyDataEntryInHotelBooking());
			hotelPage.applyFilters();
			actual = hotelPage.verifyPriceSorting();
			expected = actual;
			assertEquals(actual,expected);
			hotelPage.selectHotel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Then("^refresh page$")
	public void refresh_page() {
		try {
			hotelPage.refreshPage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}