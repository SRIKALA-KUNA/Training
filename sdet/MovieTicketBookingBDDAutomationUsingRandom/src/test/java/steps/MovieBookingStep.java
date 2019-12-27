package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import driverhandler.Base;
import pages.DatePage;
import pages.HomePage;
import pages.LocationPage;
import pages.LoginPage;
import pages.MoviePage;
import pages.CommonPageOperations;
import pages.SeatPage;
import pages.TheatrePage;
import pages.TicketPage;
import pages.TimePage;
import utils.Utils;

public class MovieBookingStep {
	WebDriver driver;

	Utils commonUtils;
	CommonPageOperations commonPageOperations;
	Properties  prop;
	public MovieBookingStep()
	{
		Base base = new Base();
		this.driver = base.getDriver();
		commonUtils =new Utils(driver);
		commonPageOperations = new CommonPageOperations(driver);
		prop = base.initProperties();
	}

	LoginPage login;
	LocationPage location;
	HomePage home;
	MoviePage movie;
	TheatrePage theatre;
	DatePage date;
	TimePage time;
	SeatPage seat;
	TicketPage ticket;
	public void loginUsingCredentials(String username, String password) {
		login = new LoginPage(driver,prop.getProperty("base.url"));
		login.enterLoginCredentials(username,password);
		login.clickOnLogin();
	}

	public void bookTicket(List<List<String>> data) {
		loginUsingCredentials(data.get(1).get(0), data.get(1).get(1));
		try {
			Utils.wait(2);
		} catch (InterruptedException e1) {
			Thread.currentThread().interrupt();
		}
		proceedForBooking();
		try {
			Utils.wait(2);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		selectLocation();
		selectMovie();
		selectTheatre();
		selectDate();
		selectTime();
		selectSeats();
		try {
			Utils.wait(2);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void proceedForBooking() {
		home = new HomePage(login.returnDriver());
		home.cliclOnProccedButton();
	}
	public  List<String> getTicketData() {
		try {
			Utils.wait(2);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		ticket = new TicketPage(seat.returnDriver());
		return ticket.tickteData();
	}
	void selectSeats() {
		seat = new SeatPage(time.returnDriver());
		seat.selectSeatOption();
		try {
			Utils.wait(2);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		seat.book();
	}

	void selectTime() {
		time = new TimePage(date.returnDriver());
		time.selectTimeOption();
		commonPageOperations.next();
	}

	void selectDate() {
		date = new DatePage(theatre.returnDriver());
		date.selectDateOption();
		commonPageOperations.next();
	}

	void selectTheatre() {
		theatre = new TheatrePage(movie.returnDriver());
		theatre.selectTheaterOption();
		commonPageOperations.next();
	}

	void selectMovie() {
		movie = new MoviePage(location.returnDriver());
		movie.clickOnMovieOption();
		commonPageOperations.next();
	}

	void selectLocation() {
		location = new LocationPage(home.returnDriver());
		location.selectLocationOption();
		commonPageOperations.next();	
	}

	public boolean verifyUserIsInLoginPage() {
		assertEquals(driver.getTitle(),prop.getProperty("loginPage.title"));
		commonUtils.closeTheBrowser();
		return true;
	}

	public void next() {
		location = new LocationPage(login.returnDriver());
		commonPageOperations.next();
	}

	public void loginPage(String username, String password) {
		loginUsingCredentials(username, password);
	}

	public boolean verifyTitleOfLocationPage() {
		assertEquals(driver.getTitle(), prop.getProperty("locationPage.title"));
		commonUtils.closeTheBrowser();
		return true;
	}

	public void goToMoviePage(List<List<String>> data) {
		goToLocationPage(data);
		selectLocation();
	}

	public boolean verifyTitleOfMoviePage() {
		assertEquals(driver.getTitle(), prop.getProperty("moviePage.title"));
		commonUtils.closeTheBrowser();
		return true;
	}

	public void goToTheatrePage(List<List<String>> data) {
		goToMoviePage(data);
		selectMovie();

	}

	public boolean verifyTitleOfTheatrePage() {
		assertEquals(driver.getTitle(),prop.getProperty("theaterPage.title"));
		commonUtils.closeTheBrowser();
		return true;
	}

	public void goToDatePage(List<List<String>> data) {
		goToTheatrePage(data);
		selectTheatre();

	}

	public boolean verifyTitleOfDatePage() {
		assertEquals(driver.getTitle(),prop.getProperty("datePage.title"));
		commonUtils.closeTheBrowser();
		return true;
	}

	public void goToTimePage(List<List<String>> data) {
		goToDatePage(data);
		selectDate();

	}

	public boolean verifyTitleOfTimePage() {
		assertEquals(driver.getTitle(),prop.getProperty("timePage.title"));
		commonUtils.closeTheBrowser();
		return true;
	}
	
	public void goToLocationPage(List<List<String>> data) {
		loginPage(data.get(1).get(0),data.get(1).get(1));
		proceedForBooking();
	}
	
	public boolean verifTheTicketDetails(List<String> actual) {
		for(int i=0;i<actual.size();i++)
		{
			assertTrue(actual.get(i).contains(CommonPageOperations.ticket.get(i)));
		}
		commonUtils.closeTheBrowser();
		return true;
	}


}
