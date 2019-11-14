package com.epam.SeleniumTask2;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Checkbox extends Factory {
	
	@Test(dataProvider ="checkbox")
	void checkBoxes(String xpath) {
		 driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement button = driver.findElement(By.xpath(xpath));
		button.click();

	}
	@DataProvider(name="checkbox")
	Object[] checkbox() {
		Object[] object =new Object[] {"//form[@id='checkboxes']/input[@type='checkbox'][2]",
		"//form[@id='checkboxes']/input[@type='checkbox'][1]"};
		return object;

	}
}
