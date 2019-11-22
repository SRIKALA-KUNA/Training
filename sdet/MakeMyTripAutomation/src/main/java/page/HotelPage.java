package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomation.Utils;

import base.Base;
import io.qameta.allure.Step;

public class HotelPage  {
	WebDriver driver;
	Properties  prop;

	@FindBy(xpath = "//*[@id='city']")
	WebElement destination;

	@FindBy(xpath = "//*[@id=\"react-autowhatever-1-section-0-item-4\"]/div/div/div")
	WebElement destinationCity;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]")
	WebElement checkInInput;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]")
	WebElement checkInDate;

	@FindBy(id = "//*[@id=\"hp-widget__return\"]")
	WebElement checkOutInput;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[6]")
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

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[2]/a/div")
	WebElement hotel;

	@FindBy(id = "//*[@id=\"hlistpg_proptypes_show_more\"]")
	WebElement showMoreFilters;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[3]/span")
	WebElement close;

	@FindBy(xpath = "//*[@id=\"hlistpg_sortby_option\"]/span")
	WebElement sortByPopularity;

	@FindBy(xpath = "//*[@id=\"hlistpg_sortby_option\"]/ul/li[2]")
	WebElement sortByPriceLowToHigh;

	

	@FindBy(id = "//p[@id ='hlistpg_hotel_shown_price']")
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
		Utils.wait(5);
		Utils.wait(driver);
		searchButton.click();
		return driver.getCurrentUrl();
	}
	@Step("applying filters")
	public void clickFilters() throws InterruptedException
	{
		driver.get("https://www.makemytrip.com/hotels/hotel-listing/?checkin=11272019&checkout=11302019&roomStayQualifier=2e0e&city=BLR&country=IN&type=CTY&searchText=Bangalore&visitorId=4a961398-c83c-4fc9-b43d-538ada187baf");
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
		showMoreFilters.click();
		Utils.wait(20);
		propertyType.click();


	}
	@Step("applying sort")
	public List<String> verifyPriceSorting() throws InterruptedException
	{

		driver.get("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&category=MMT%20Assured&checkin=11272019&checkout=11302019&city=BLR&country=IN&propType=Resort&roomStayQualifier=2e0e&searchText=Bangalore&starRating=4%2C5&type=CTY&visitorId=4a961398-c83c-4fc9-b43d-538ada187baf");
		Utils.wait(5);
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]")).click();
		sortByPopularity.click();
		Utils.wait(5);
		sortByPriceLowToHigh.click();
		Utils.wait(5);

		for(int i=0;i<2;i++)
		{
			Utils.wait(5);
			actual.add(priceOfHotels.get(i).getText());
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
