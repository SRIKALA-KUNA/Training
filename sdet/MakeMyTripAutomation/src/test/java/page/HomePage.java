package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.logging.Logger;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomation.RestAssuredClass;
import com.epam.MakeMyTripAutomation.Utils;

public class HomePage {
	WebDriver driver;
	Actions actions;
	List<String> nextPageUrls = new ArrayList();
	List<String> footerLinks = new ArrayList();
	Logger logger = Logger.getLogger(HomePage.class.getName());
	@FindBy(xpath = "//ul[@class ='makeFlex font12']/li/a") 
	private List<WebElement> navigationBar;
	RestAssuredClass rest = new RestAssuredClass();
	
	@FindBy(xpath="//ul[@class ='makeFlex font12']/li[10]/a")
	private WebElement moreOption;
	
	
	@FindBy(xpath = "//footer/div[@class='landingContainer']/div")
	WebElement footer;
	
	@FindBy(xpath ="//ul[@class ='makeFlex font12']/li[10]")
	WebElement mouseHower;
	@FindBy(xpath="//ul[@class ='makeFlex font12']/li[10]/div/a[4]")
	WebElement dealsLink;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	public List verifyNavigationLinks() throws InterruptedException
	{
		for(int options =0 ;options < navigationBar.size()-1 ; options++)
		{
			navigationBar.get(options).click();
			Utils.wait(5);
			nextPageUrls.add(driver.getCurrentUrl());
			driver.navigate().back();
		}
		return nextPageUrls;
	}

	
	public List<String> verifyFooterLinks() {
		 List<String> brokenLinks = new ArrayList();
		
		List<WebElement> anchorTags = footer.findElements(By.tagName("a"));
		for (WebElement anchor : anchorTags) {
			if (anchor.getAttribute("href") != null) {
				footerLinks.add(anchor.getAttribute("href"));
			}
		}
		for (String href : footerLinks) {
			try {
				int responseCode = rest.getStatusCode(href);
				if(responseCode != 200)
				{
					brokenLinks.add(href);
				}
			} catch (Exception e) {
				
				logger.info(e.toString());
			}
		}
		return brokenLinks;
	}
	 
	public String verifyDealsLink() throws InterruptedException
	{
		moreOption.click();
		Utils.wait(20);
		dealsLink.click();
		Utils.wait(20);
		Utils.nextWindow(driver);
		return driver.getCurrentUrl();
	}

	public void performMouseHower() {
		actions = Utils.getActions(driver);
		actions.moveToElement(mouseHower).build().perform();
		
	}
	

}

