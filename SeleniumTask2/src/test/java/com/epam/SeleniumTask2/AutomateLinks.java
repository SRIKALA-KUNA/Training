package com.epam.SeleniumTask2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AutomateLinks  {
	WebDriver driver;
	@BeforeClass
	void initialize() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srikala_Kuna\\eclipse-workspace\\SeleniumTask2\\resource\\chromedriver.exe");
		driver= new ChromeDriver();	

	}

	@Test
	void addRemoveElements() {
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		WebElement button = driver.findElement(By.xpath("//div[@class='example']/button"));
		for(int i=0 ;i<5 ;i++)
		{
			button.click();
		}
		List deleteElement = driver.findElements(By.xpath("//div[@class='example']/div[@id='elements']/button[@onclick='deleteElement()']"));
		Assert.assertEquals(5,deleteElement.size());
		for(int i=0 ;i<5 ;i++)
		{
			driver.findElement(By.xpath("//div[@class='example']/div[@id='elements']/button[@onclick='deleteElement()']")).click();
		}
	}
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

	@Test
	void testDropdown()
	{
		driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.findElement(By.xpath("//select[@id='dropdown']/Option"));
		Select options = new Select(driver.findElement(By.ById.id("dropdown")));
		options.selectByVisibleText("Option 1");
		options.selectByVisibleText("Option 2");

	}

	@Test
	void testInputs()
	{

		driver.get("https://the-internet.herokuapp.com/inputs");
		WebElement input = driver.findElement(By.xpath("//div[@id='content']//input[@type='number']"));
		input.sendKeys("3");
		String value =input.getText();
		assertEquals("3",value);

	}

	@Test
	void testStatusCodes()
	{

		driver.get("https://the-internet.herokuapp.com/status_codes");
		List<WebElement> input = driver.findElements(By.xpath("//*[@id=\"content\"]//li/a"));
		String presentPage = driver.getCurrentUrl();
		for(int pages =0 ;pages<input.size();pages++)
		{
			input = driver.findElements(By.xpath("//*[@id=\"content\"]//li/a"));
			input.get(pages).click();
			String nextPage = driver.getCurrentUrl();
			assertNotEquals(presentPage,nextPage);
			driver.navigate().back();
		}
	}

	@Test
	void testChallengingDom()
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





}
