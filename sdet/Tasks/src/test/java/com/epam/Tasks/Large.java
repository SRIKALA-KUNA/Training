package com.epam.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Large extends Factory {
	@Test
	void testLarge() {
		driver.get("https://the-internet.herokuapp.com/large");
		WebElement element = driver.findElement(By.xpath("//div[@id='sibling-50.2']"));
		String currentElementText = element.getText();
		Assert.assertEquals(currentElementText, "50.2");
	}
	
	@Test
	void testLargeTable() {
		driver.get("https://the-internet.herokuapp.com/large");
		WebElement element = driver.findElement(By.xpath("//tr[@class='row-50']/td[@class='column-50']"));
		String currentElementText = element.getText();
		Assert.assertEquals(currentElementText, "50.50");
	}


}
