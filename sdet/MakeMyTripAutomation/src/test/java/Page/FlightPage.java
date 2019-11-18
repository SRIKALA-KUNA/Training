package Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomation.Settings;

public class FlightPage extends Settings {
	WebDriver driver;
	 JavascriptExecutor javaScript;
	@FindBy(xpath="//label[@for ='fromCity']/input")
	WebElement fromLabel;

	@FindBy(xpath="//*[@id='react-autowhatever-1-section-0-item-1']/div")
	WebElement fromLocation;

	@FindBy(xpath = "//*[@id=\"react-autowhatever-1-section-0-item-7\"]/div")
	WebElement toLocation;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]")
	WebElement departureLabel;

	@FindBy(xpath="//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[4]")
	WebElement returnLabel;

	@FindBy(xpath = "//div[@class='dateInnerCell']/p[contains(text(),'20')]")
	WebElement departureDate;

	@FindBy(xpath="//div[@class='DayPicker-NavBar']/span[2]")
	WebElement nextMonthArrow;

	@FindBy(xpath = "//div[@class='DayPicker-Months']/div[2]//div[@class='dateInnerCell']/p[contains(text(),'20')]")
	WebElement returnDate;

	@FindBy(xpath="//p[@data-cy='submit']/a")
	WebElement search;

	@FindBy(xpath="//*[@id='more_filters']/span")
	WebElement more;

	@FindBy(xpath="//*[@id=\"slider_filters_panel\"]/div[1]/div/div/div/div/div[4]")
	WebElement slider;

	@FindBy(xpath="//*[@id=\"extended-filter-apply\"]")
	WebElement applyFilter;

	@FindBy(xpath ="//*[@id=\"sorting-togglers\"]/div[5]/span/span[1]")
	WebElement priceButton;

	@FindBy(xpath="//*[@id=\"sorting-togglers\"]/div[5]/span/span[1]")
	WebElement sortPrice;

	@FindBy(xpath="//span[@class ='actual-price']")
	List<WebElement> ticketsPriceList;

	@FindBy(xpath = "//*[@id=\"airline_group\"]/span[1]/label/span[1]")
	WebElement airIndia;

	@FindBy (xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div[4]/button")
	WebElement bookTicket;

	@FindBy(xpath = "//*[@id=\"fli_list_item_0f40b71e-0f1b-4e13-bb73-edd152180acb\"]/div[1]/div/div/div/div[2]/div/div/div/label/div")
	List<WebElement> bookedTicketTimeData;
	
	@FindBy(xpath = "//*[@id=\"rev-header\"]/div/div/ul/li[2]/span[1]")
	WebElement progressBarPage2;
	
	@FindBy(xpath = "//*[@id=\"rev-header\"]/div/div/ul/li[3]/span[1]")
	WebElement progressBarPage3;

	@FindBy(xpath = "//input[@type='radio'][@value='no']")
	WebElement no;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[4]/button")
	WebElement continue1;

	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div[4]/p/span[2]/span/span")
	WebElement finalPrice;


	public FlightPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void verifyFlightdataEntry() 
	{
		fromLabel.click();
		fromLocation.click();
		toLocation.click();
		departureLabel.click();
		nextMonthArrow.click();
		departureDate.click();
		//returnLabel.click();
		//nextMonthArrow.click();
		//returnDate.click();
		search.click();

	}


	public List verifyFilters() throws InterruptedException
	{
		Thread.sleep(1000);
		more.click();
		Thread.sleep(1000);


		Actions action= new Actions(driver);
		action.clickAndHold(slider);
		action.moveByOffset(45,0);
		action.release().build().perform();
		Settings.sleep();
		applyFilter.click();
		Thread.sleep(500);
		airIndia.click();
		Thread.sleep(500);
		priceButton.click();
		Thread.sleep(500);
		//sortPrice.click();
		List<String> price = new ArrayList();
		for(int i=0;i<4;i++)
		{
			price.add(	ticketsPriceList.get(i).getText());

		}
		return price;

	}

	public List  bookTicketData() throws InterruptedException
	{
		List<String> expectedTicketData = new ArrayList();
		Thread.sleep(500);
		expectedTicketData.add(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[3]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div/label/div[1]/div")).getText());
		expectedTicketData.add(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[3]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div/label/div[3]/div/p[1]")).getText());
		expectedTicketData.add(driver.findElements(By.xpath("//span[@class= 'actual-price']")).get(1).getText());
		 

		return expectedTicketData;
				
	}

	public List bookTicketPage2() throws InterruptedException
	{
		Thread.sleep(500);
		bookTicket.click();
		Thread.sleep(500);
		this.driver = nextWindow(driver);
		List<String> actualTicketData = new ArrayList();
		actualTicketData.add(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div")).getText());
		actualTicketData.add(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/div[1]/div/div/div[2]/div[2]/p[1]")).getText());
		actualTicketData.add(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[4]/p/span[2]/span/span")).getText());
		 
		return actualTicketData;
				
	}


	public String trackProgressBar(int pageNumber)
	{
		String number;
		if(pageNumber == 2)
		{
		 number = progressBarPage2.getText();
		return number;
		}
		else
		{
			number = progressBarPage3.getText();
			return number;
		}
	}

	public String bookTicketPage3() throws InterruptedException
	{
		Settings.longSleep();
		Thread.sleep(5000);
		javaScript = (JavascriptExecutor) driver;
		 javaScript.executeScript("window.scrollBy(0,2000)");
		 Settings.longSleep();
		no.click();
		Thread.sleep(500);
		continue1.click();
		Thread.sleep(500);
		return finalPrice.getText();

	}
	
	




}
