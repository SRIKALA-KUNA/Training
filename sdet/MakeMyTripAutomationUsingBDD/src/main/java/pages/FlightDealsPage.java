package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;
public class FlightDealsPage  {

	@FindBy(xpath = "//*[@id=\"hp-widget__sfrom\"]")
	WebElement fromDealsLabel;

	@FindBy(xpath = "//*[@id=\"hp-widget__sTo\"]")
	WebElement toDealsLabel;

	@FindBy(xpath = "/html/body/div[6]/div[4]/div[2]/div[1]/section/div[2]/div[3]/input")
	WebElement departDealsLabel;

	@FindBy(xpath = "/html/body/div[6]/div[4]/div[2]/div[3]/div/div[3]/div/div[1]/table/tbody[1]/tr/td/a[text()='29']")
	WebElement departDate;

	@FindBy(xpath = "//*[@id=\"searchBtn\"]")
	WebElement searchButton;
	WebDriver driver;
	Properties prop;
	public FlightDealsPage(WebDriver driver ,Properties prop)
	{
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(this.driver, this);
	}
	@Step("data entry for flight booking")
	public String enterFlightData() throws InterruptedException
	{
		Utils.wait(20);
		fromDealsLabel.click();
		Utils.wait(5);
		fromDealsLabel.sendKeys(prop.getProperty("from.city"));
		Utils.wait(5);
		fromDealsLabel.click();
		Utils.wait(5);
		toDealsLabel.click();
		Utils.wait(5);
		toDealsLabel.sendKeys(prop.getProperty("to.city"));
		Utils.wait(5);
		toDealsLabel.click();
		Utils.wait(5);
		departDealsLabel.click();
		Utils.wait(5);
		departDate.click();
		Utils.wait(driver);
		searchButton.click();
		Utils.wait(5);
		return driver.getCurrentUrl();

	}

}
