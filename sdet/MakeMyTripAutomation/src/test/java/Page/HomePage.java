package Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.logging.Logger;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomation.RestAssuredClass;

public class HomePage {
	WebDriver driver;
	List<String> nextPageUrls = new ArrayList();
	List<String> footerLinks = new ArrayList();
	Logger logger = Logger.getLogger(HomePage.class.getName());
	@FindBy(xpath = "//ul[@class ='makeFlex font12']/li/a") 
	private List<WebElement> navigationBar;
	RestAssuredClass rest = new RestAssuredClass();
	
	@FindBy(xpath="//ul[@class ='makeFlex font12']/li[10]/a")
	private WebElement moreOption;
	
	@FindBy(xpath="//ul[@class ='makeFlex font12']/li[10]/a/div/a[4]")
	private WebElement deals;
	
	@FindBy(xpath = "//footer/div[@class='landingContainer']/div")
	WebElement footer;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	public List verifyNavigationBar()
	{
		for(int navigationOptions =0 ;navigationOptions < navigationBar.size()-1 ; navigationOptions++)
		{
			navigationBar.get(navigationOptions).click();
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
	 
	public String verifyDeals() throws InterruptedException
	{
		moreOption.click();
		Thread.sleep(2331);
		moreOption.findElement(By.xpath("//ul[@class ='makeFlex font12']/li[10]/div/a[4]")).click();
		Thread.sleep(2331);
		Set<String> windowHandles = driver.getWindowHandles();
        for(String winHandle : windowHandles){
            driver.switchTo().window(winHandle);
        }
		return driver.getCurrentUrl();
	}


}

