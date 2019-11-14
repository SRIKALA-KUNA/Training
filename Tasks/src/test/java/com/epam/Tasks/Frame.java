package com.epam.Tasks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Frame extends Factory {
	
	String baseUrl;
	 String[] frames = new String[2];
	@BeforeClass
	void init()
	{
		
		 baseUrl = "https://the-internet.herokuapp.com/frames";
		 frames[0]="//*[@id=\"content\"]//li[1]";
		 frames[1]="//*[@id=\"content\"]//li[2]";
		 
	}
	@Test
	void testNavigation() {
		String currentUrl , nextUrl;
		
		driver.get(baseUrl);
		currentUrl = driver.getCurrentUrl();
		for(int typesOfFrames=0; typesOfFrames <frames.length ;typesOfFrames++) 
		{
			driver.findElement(By.xpath(frames[typesOfFrames]+"/a")).click();
			nextUrl = driver.getCurrentUrl();
			assertNotEquals(currentUrl,nextUrl);
			driver.navigate().back();
		}
	}
	
	@Test
	void testDataInsideNestedFrame() {
		driver.get(baseUrl);
		driver.findElement(By.xpath(frames[0]+"/a")).click();
		System.out.println(driver.findElement(By.ByXPath.xpath("//*[@id=\"content\"]")).getText());
		}
	
	@Test
	void testDataInsideIFrame()
	{
		driver.get("https://the-internet.herokuapp.com/iframe");
		WebElement element = driver.findElement(By.xpath("//textarea[@id='mce_0']"));
		element.clear();
		String keysToSend = "Hello world!";
		element.sendKeys(keysToSend);
		String textRetrieved = element.getText();
		assertEquals(keysToSend.equals(textRetrieved),textRetrieved);
		
	}
	
	@Test
	void testTypo() {
		driver.get("https://the-internet.herokuapp.com/typos");
		String data = driver.findElement(By.xpath("//div[@class='example']/p[2]")).getText();
		assertEquals(data, "Sometimes you'll see a typo, other times you won't.");
		
	}


}
