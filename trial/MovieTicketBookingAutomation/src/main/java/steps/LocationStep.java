package steps;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import pages.LocationPage;
import utils.Utils;

public class LocationStep extends DriverStep {


	LocationPage location;
	LoginStep login;

	public LocationStep() throws MalformedURLException  {

		driver = Base.getDriverInstance();
		location = new LocationPage(driver);		
	}
	public void openLocationPage() throws MalformedURLException {
		login = new LoginStep();
		login.loginFeature("apurv@gmail.com","kumar");
	}
	public void pre()
	{
		System.out.println(driver.getCurrentUrl()+"hello");
		location.preRequisit();
	}
	public void clicksOnLocation(String loc) {
		pre();
		location.selectLocationOptions(loc);
	}
	public void next() {
		location.next();	
	}
	public boolean verifyTitleOfMoviePage() {
		Assert.assertEquals(driver.getTitle(), Utils.titleOfMoviePage); 
		return true;
	}
	public boolean verifyTitleOfLocationPage() {
		Assert.assertEquals(driver.getCurrentUrl(), Utils.titleOfLocationPage);
		return true;
	}


}
