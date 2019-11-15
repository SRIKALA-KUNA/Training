package com.epam.MakeMyTripAutomation;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Log;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyHomePage {
	WebDriver driver;
	Logger logger  = Logger.getLogger( VerifyHomePage.class.getName()); 
	private final String baseUrl ="https://www.makemytrip.com/";
	private List<String> actual = new ArrayList<String>();
	private final List<String> expected = new ArrayList<String>(Arrays.asList("https://www.makemytrip.com/flights/",
			"https://www.makemytrip.com/hotels/",
			"https://www.makemytrip.com/homestays/",
			"https://www.makemytrip.com/holidays-india/",
			"https://www.makemytrip.com/railways/",
			"https://www.makemytrip.com/bus-tickets/",
			"https://www.makemytrip.com/cabs/",
			"https://www.makemytrip.com/visa/",
			"https://www.makemytrip.com/gift-cards/?intid=Header_ch_giftcard"));
	HomePage home;
	@BeforeClass
	void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srikala_Kuna\\eclipse-workspace\\MakeMyTripAutomation\\resource\\chromedriver.exe");
		driver = new ChromeDriver();
		home = new HomePage(driver);
	}

	@Test
	void verifyNavigationBar()
	{

		driver.get(baseUrl);

		actual = home.verifyNavigationBar();
		assertEquals(actual, expected );
	}

	@Test
	void verifyBrokenLinks()
	{
		driver.get(baseUrl);
		List<String> brokenLinks = home.verifyFooterLinks();
		for(String broken : brokenLinks)
		{
			System.out.println(broken);
		}

	}

	@Test
	void verifyMouseHower()
	{
		driver.get(baseUrl);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class ='makeFlex font12']/li[10]"))).build().perform();
	}



	@Test
	void verifyMoreOptions() 
	{
		driver.get(baseUrl);
		String actual;
		try {
			actual = home.verifyDeals();
			assertEquals(actual,"https://www.makemytrip.com/daily-deals/");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
