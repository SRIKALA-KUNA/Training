package Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomation.Settings;

import Base.Base;

public class HotelPage  {
	WebDriver driver;
	Properties  prop;

	@FindBy(xpath = "//*[@id=\\\"city\\\"]")
	WebElement to;

	@FindBy(xpath = "//*[@id=\"react-autowhatever-1-section-0-item-4\"]/div/p/span[1]")
	WebElement city;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]")
	WebElement check_in;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]")
	WebElement check_in_date;

	@FindBy(xpath = "//*[@id=\"hp-widget__return\"]")
	WebElement check_out;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[6]")
	WebElement check_out_date;

	@FindBy(xpath = "//button[@type='button']")
	WebElement search;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div[1]/div/div[2]/ul/li[2]/span[1]/label")
	WebElement mmtAssured;

	@FindBy(xpath = "//*[@id=\"hlistpg_fr_star_category\"]/ul/li[1]/span[1]/label")
	WebElement fiveStar;

	@FindBy(xpath ="//*[@id=\"hlistpg_fr_star_category\"]/ul/li[2]/span[1]")
	WebElement fourStart;


	@FindBy(xpath = "//*[@id=\"hlistpg_fr_property_types\"]/ul/li[2]/span[1]")
	WebElement propertyType;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[2]/a/div")
	WebElement hotel;

	@FindBy(xpath = "//*[@id=\"hlistpg_proptypes_show_more\"]")
	WebElement showMore;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[3]/span")
	WebElement close;

	@FindBy(xpath = "//*[@id=\"hlistpg_sortby_option\"]/span")
	WebElement popularity;

	@FindBy(xpath = "//*[@id=\"hlistpg_sortby_option\"]/ul/li[2]")
	WebElement priceLowToHigh;

	@FindBy(xpath = "//*[@id=\"hotelListingContainer\"]/div/div/div")
	WebElement hotelContainer;

	@FindBy(xpath = "//p[@id ='hlistpg_hotel_shown_price']")
	List<WebElement> price;

	@FindBy(xpath = "//*[@id=\"_Hlisting_area\"]/div[3]/div[1]/div/div[1]/div/a")
	WebElement clear;

	List<String >actual = new ArrayList();

	public HotelPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		//prop = Base.init_properties();
	}

	public String verifyDataEntryInHotelBooking() throws InterruptedException
	{
		to.click();
		Settings.sleep();
		city.click();

		Thread.sleep(2000);
		Settings.sleep();
		Settings.wait(driver);
		check_in.click();

		Settings.sleep();
		check_in_date.click();
		Settings.sleep();

		Settings.sleep();
		check_out_date.click();
		Settings.sleep();
		Settings.wait(driver);
		search.click();
		return driver.getCurrentUrl();
	}

	public void verifyFilters() throws InterruptedException
	{
		driver.get("https://www.makemytrip.com/hotels/hotel-listing/?checkin=11272019&checkout=11302019&roomStayQualifier=2e0e&city=BLR&country=IN&type=CTY&searchText=Bangalore&visitorId=4a961398-c83c-4fc9-b43d-538ada187baf");
		close.click();
		Settings.sleep();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]")).click();
		Settings.longSleep();
		mmtAssured.click();
		Settings.longSleep();
		Settings.wait(driver);
		fiveStar.click();
		Settings.longSleep();
		fourStart.click();
		Settings.longSleep();
		showMore.click();
		Settings.longSleep();
		propertyType.click();


	}

	public List verifySort() throws InterruptedException
	{

		driver.get("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&category=MMT%20Assured&checkin=11272019&checkout=11302019&city=BLR&country=IN&propType=Resort&roomStayQualifier=2e0e&searchText=Bangalore&starRating=4%2C5&type=CTY&visitorId=4a961398-c83c-4fc9-b43d-538ada187baf");
		Settings.sleep();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]")).click();
		popularity.click();
		Settings.sleep();
		priceLowToHigh.click();
		Settings.sleep();

		for(int i=0;i<3;i++)
		{
			Settings.sleep();
			actual.add(price.get(i).getText());
		}

		return actual;
	}
	public void selectHotel()
	{
		hotel.click();
	}

	public void refresh()
	{
		clear.click();
		driver.navigate().refresh();
	}

}
