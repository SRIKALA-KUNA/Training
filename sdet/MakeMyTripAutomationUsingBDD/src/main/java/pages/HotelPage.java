package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import base.Base;
import io.qameta.allure.Step;
//import io.qameta.allure.Step;
import utils.Utils;

public class HotelPage  {
	WebDriver driver;
	Properties  prop;

	@FindBy(xpath = "//*[@id='city']")
	WebElement destination;

	@FindBy(xpath = "//*[@id=\"react-autowhatever-1-section-0-item-4\"]/div/div/div")
	WebElement destinationCity;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]")
	WebElement checkInInput;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[3]")
	WebElement checkInDate;

	@FindBy(id = "//*[@id=\"hp-widget__return\"]")
	WebElement checkOutInput;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[6]")
	WebElement checkOutDate;

	@FindBy(xpath = "//button[@type='button']")
	WebElement searchButton;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div[1]/div/div[2]/ul/li[2]/span[1]/label")
	WebElement mmtAssuredLabel;

	@FindBy(xpath = "//*[@id=\"hlistpg_fr_star_category\"]/ul/li[1]/span[1]/label")
	WebElement fiveStarLabel;

	@FindBy(xpath ="//*[@id=\"hlistpg_fr_star_category\"]/ul/li[2]/span[1]")
	WebElement fourStartLabel;


	@FindBy(xpath = "//*[@id=\"hlistpg_fr_property_types\"]/ul/li[2]/span[1]")
	WebElement propertyType;
	
	@FindBy(xpath="//*[@id='Listing_hotel_0']")
	WebElement hotel;

	@FindBy(id = "//*[@id=\"hlistpg_proptypes_show_more\"]")
	WebElement showMoreFilters;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[3]/span")
	WebElement close;

	@FindBy(xpath = "//*[@id=\"hlistpg_sortby_option\"]/span")
	WebElement sortByPopularity;

	@FindBy(xpath = "//*[@id=\"hlistpg_sortby_option\"]/ul/li[2]")
	WebElement sortByPriceLowToHigh;

	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div[2]/div/div/div/a/div/div[2]/div[2]/div/p[1]")
	List<WebElement> priceOfHotels;
	@FindBy(id = "//*[@id=\"detpg_headerright_room_price\"]")
	WebElement priceOnBookingPage;

	@FindBy(xpath = "//*[@id=\"_Hlisting_area\"]/div[3]/div[1]/div/div[1]/div/a")
	WebElement clearFilters;

	List<String >actual = new ArrayList<String>();

	public HotelPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	@Step("data entry for hotel booking")
	public String verifyDataEntryInHotelBooking() throws InterruptedException
	{
		destination.click();
		Utils.wait(20);
		Utils.wait(driver);
		destinationCity.click();
		Utils.wait(20);
		Utils.wait(5);
		Utils.wait(driver);
		checkInInput.click();
		Utils.wait(5);
		checkInDate.click();
		Utils.wait(5);
		Utils.wait(5);
		checkOutDate.click();
		Utils.wait(10);
		Utils.wait(driver);
		searchButton.click();
		return driver.getCurrentUrl();
	}
	@Step("applying filters")
	public void clickFilters() throws InterruptedException
	{
		
		close.click();
		Utils.wait(20);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]")).click();
		Utils.wait(20);
		mmtAssuredLabel.click();
		Utils.wait(20);
		Utils.wait(driver);
		fiveStarLabel.click();
		Utils.wait(20);
		fourStartLabel.click();
		Utils.wait(20);
		//showMoreFilters.click();
		//Utils.wait(20);
		propertyType.click();


	}
	@Step("applying sort")
	public List<String> verifyPriceSorting() throws InterruptedException
	{

		
		Utils.wait(5);
		
		sortByPopularity.click();
		Utils.wait(5);
		sortByPriceLowToHigh.click();
		Utils.wait(5);

		for(int index=0;index<priceOfHotels.size();index++)
		{
			Utils.wait(5);
			actual.add(priceOfHotels.get(index).getText());
		}

		return actual;
	}
	@Step("selecting hotel")
	public void selectHotel() 
	{
		hotel.click();

	}
	@Step("refresh")
	public void refreshPage() throws InterruptedException
	{
		clearFilters.click();
		Utils.wait(20);
		Utils.refreshPage(driver);
	}

}
