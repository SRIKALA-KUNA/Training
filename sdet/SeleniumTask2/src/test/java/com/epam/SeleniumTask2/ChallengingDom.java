package com.epam.SeleniumTask2;

import static org.testng.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ChallengingDom extends Factory {
	

	@Test
	void testChallengingDomButtons()
	{
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='content']//div[@class='large-2 columns']/a"));
		List<String> buttonNames = Arrays.asList("buz","foo","qux","bar");

		for(int button=0;button<buttons.size();button++)
		{
			buttons = driver.findElements(By.xpath("//div[@id='content']//div[@class='large-2 columns']/a"));

			assert(buttonNames.contains(buttons.get(button).getText()));
			buttons.get(button).click();


		}


	}
	@Test
	void testChallengingDomLinks()
	{
		driver.get("https://the-internet.herokuapp.com/challenging_dom");

		String presentPage = driver.getCurrentUrl();
		driver.findElements(By.xpath("//div[@id='content']//div[@class ='large-10 columns']//a[@href='#edit']")).get(0).click();
		String nextPage = driver.getCurrentUrl();

		assertNotEquals(presentPage,nextPage);
		driver.findElements(By.xpath("//div[@id='content']//div[@class ='large-10 columns']//a[@href='#delete']")).get(0).click();
		nextPage = driver.getCurrentUrl();
		assertNotEquals(presentPage,nextPage);
	}
}
