package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPage {
	WebDriver driver;
	@FindBy (xpath ="//input[@value]")
	WebElement locationRadio;
	public LocationPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickSearchButton() {
		// TODO Auto-generated method stub
		
	}
	public void clickLocationRadio(String location) {
		
		
	}

}
