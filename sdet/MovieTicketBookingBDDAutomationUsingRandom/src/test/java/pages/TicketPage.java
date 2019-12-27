package pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
public class TicketPage{
	@FindBy(xpath = "//h3")
	List<WebElement> ticketData;
	WebDriver driver;
	public TicketPage(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	static Logger logger = Logger.getLogger(TicketPage.class.getName());
	List<String> data = new ArrayList<>();
	@Step("the ticket is booked")
	public List<String> tickteData()
	{		
		for(WebElement ticket :ticketData)
		{
			data.add(ticket.getText());
		}

		data.remove(0);
		String date = data.get(0);
		data.remove(0);
		data.add(3, date);
		data.remove(6);
		return data;

	}
}
