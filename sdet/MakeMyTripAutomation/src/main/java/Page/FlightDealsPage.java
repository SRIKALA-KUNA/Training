package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomation.Settings;

import io.qameta.allure.Step;

public class FlightDealsPage  {

	@FindBy(xpath = "//*[@id=\"js-hp-widgetSection\"]/div[2]/div[1]/input")
	WebElement fromDeals;

	@FindBy(xpath = "//*[@id=\"hp-widget__sTo\"]")
	WebElement toDeals;

	@FindBy(xpath = "/html/body/div[6]/div[4]/div[2]/div[1]/section/div[2]/div[3]/input")
	WebElement departDeals;

	@FindBy(xpath = "/html/body/div[6]/div[4]/div[2]/div[3]/div/div[3]/div/div[1]/table/tbody[1]/tr/td/a[text()='20']")
	WebElement departDate;

	@FindBy(xpath = "//*[@id=\"searchBtn\"]")
	WebElement search;
	WebDriver driver;
	
	public FlightDealsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	@Step("data entry for flight booking")
	public void verifyFlightDataEntryForDeals() throws InterruptedException
	{
		fromDeals.click();
		Settings.sleep();
		fromDeals.sendKeys("hyderabad");
		Settings.sleep();
		fromDeals.click();
		Settings.sleep();
		toDeals.click();
		Settings.sleep();
		toDeals.sendKeys("delhi");
		Settings.sleep();
		toDeals.click();
		Settings.sleep();
		departDeals.click();
		Settings.sleep();
		departDate.click();
		Settings.wait(driver);
		search.click();

	}

}
