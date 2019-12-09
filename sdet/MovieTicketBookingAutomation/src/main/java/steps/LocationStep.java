package steps;

import org.openqa.selenium.WebDriver;

import pages.LocationPage;

public class LocationStep {
LocationPage location;
	public LocationStep(WebDriver driver) {
		location = new LocationPage(driver);
	}
	public void pre()
	{
		location.preRequisit();
	}
	public void clicksOnLocation(String loc) {
		
		location.selectLocationOptions(loc);
		
	}
	public void next() {
	location.next();	
	}

}
