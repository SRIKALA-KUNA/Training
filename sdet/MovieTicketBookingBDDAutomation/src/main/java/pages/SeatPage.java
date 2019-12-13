package pages;


import java.util.List;
import java.util.logging.Logger;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.Utils;

public class SeatPage extends Page {

	@FindBy(xpath = "//input[@name='seat']")
	List<WebElement> seats;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	static Logger logger = Logger.getLogger(SeatPage.class.getName());
	//static Logger loggerUtils = Logger.getLogger(SeatPage.class.getName());
	public SeatPage() {
		super(driver);
		PageFactory.initElements(Page.driver, this);
	}
	
	@Step("user selects seats:{0}")
	public void selectSeatOption(String selectedSeats) {

		String[] listOfSeats;
		listOfSeats = selectedSeats.split(",");
		for(String selectedSeat: listOfSeats)
		{
			for(WebElement seat:seats)
			{
				String seatValue = seat.getAttribute("value");
				if(seat.isEnabled())
				{
				if(seatValue.contains(selectedSeat))
				{
					Utils.clickOn(seat);
					break;
				}
				}
				else
				{
					logger.info("seat is already booked");
				}

			}
		}

	}
}
