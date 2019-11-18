package HotelBooking;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPage {
	WebDriver driver;
	
	@FindBy(xpath ="//*[@id=\"city\"]")
	WebElement to;
	
	@FindBy(xpath = "//*[@id=\"react-autowhatever-1-section-0-item-4\"]")
	WebElement city;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/label[@for ='checkin']")
	WebElement check_in;
	
	@FindBy(xpath = "//*[@id=\"dp1573933759003\"]/div/div[1]/table/tbody/tr//span[contains(text(),27)]")
	WebElement check_in_date;
	
	@FindBy(xpath = "//*[@id=\"hp-widget__return\"]")
	WebElement check_out;
	
	@FindBy(xpath = "//*[@id=\\\"dp1573933759003\\\"]/div/div[1]/table/tbody/tr//span[contains(text(),30)]")
	WebElement check_out_date;
	
	@FindBy(xpath = "//*[@id=\"searchBtn\"]")
	WebElement search;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div[1]/div/div[2]/ul/li[2]/span[1]/label/text()")
	WebElement mmtAssured;
	
	@FindBy(xpath = "//*[@id=\"hlistpg_fr_star_category\"]/ul/li[1]/span[1]")
	WebElement fiveStar;
	
	@FindBy(xpath ="//*[@id=\"hlistpg_fr_star_category\"]/ul/li[2]/span[1]")
	WebElement fourStart;
	
	
	
	@FindBy(xpath = "//*[@id=\"hlistpg_fr_property_types\"]/ul/li[1]/span[1]")
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
	
	@FindBy(xpath = "//*[@id=\"hlistpg_hotel_shown_price\"]/text()[2]")
	List<WebElement> price;
	
	@FindBy(xpath = "//*[@id=\"_Hlisting_area\"]/div[3]/div[1]/div/div[1]/div/a")
	WebElement clear;
	
	List<String >actual = new ArrayList();
	
	HotelPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	void verifyDataEntryInHotelBooking() throws InterruptedException
	{
		to.click();
		Thread.sleep(1000);
		city.click();
		Thread.sleep(500);
		check_in.click();
		Thread.sleep(500);
		search.click();
		
	}
	
	void verifyFilters() throws InterruptedException
	{
		driver.get("https://www.makemytrip.com/hotels/hotel-listing/?checkin=11272019&checkout=11302019&roomStayQualifier=2e0e&city=BLR&country=IN&type=CTY&searchText=Bangalore&visitorId=4a961398-c83c-4fc9-b43d-538ada187baf");
		//Thread.sleep(500);
		//driver.switchTo().alert().dismiss();
		close.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]")).click();
		Thread.sleep(500);
		mmtAssured.click();
		Thread.sleep(500);
		fiveStar.click();
		Thread.sleep(500);
		fourStart.click();
		Thread.sleep(500);
		showMore.click();
		Thread.sleep(500);
		propertyType.click();
		Thread.sleep(500);
		hotel.click();
		
	}
	
	List verifySort() throws InterruptedException
	{
		
		driver.get("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&category=MMT%20Assured&checkin=11272019&checkout=11302019&city=BLR&country=IN&propType=Resort&roomStayQualifier=2e0e&searchText=Bangalore&starRating=4%2C5&type=CTY&visitorId=4a961398-c83c-4fc9-b43d-538ada187baf");
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]")).click();
		popularity.click();
		Thread.sleep(500);
		priceLowToHigh.click();
		Thread.sleep(500);
		//hotelContainer.findElement(By.id())
		/*for(int i=0;i<2;i++)
		{
		actual.add(price.get(i).getText());
		}*/
		Thread.sleep(500);
		actual.add(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/a/div/div[2]/div[2]/div/p[1]")).getText());
		Thread.sleep(500);
		actual.add(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[2]/a/div/div[2]/div[2]/div/p[3]")).getText());
		Thread.sleep(500);
		return actual;
	}
	
	void refresh()
	{
		clear.click();
		driver.navigate().refresh();
	}

}
