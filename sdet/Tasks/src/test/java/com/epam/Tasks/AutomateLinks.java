package com.epam.Tasks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srikala\\eclipse-workspace\\Tasks\\resource\\chromedriver.exe");
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
		List<WebElement> input = driver.findElements(By.xpath("//*[@id='content']//li/a"));
		String presentPage = driver.getCurrentUrl();
		String nextPage;
		for(int pages =0 ;pages<input.size();pages++)
		{
			input = driver.findElements(By.xpath("//*[@id='content']//li/a"));
			input.get(pages).click();
			nextPage = driver.getCurrentUrl();
			assertNotEquals(presentPage,nextPage);
			driver.navigate().back();
		}
	}
	
	@Test 
	void testdynamicContent()
	{
		
		driver.get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");
		String presentData = driver.findElements(By.xpath("//*[@id='content']/div[3]/div[@class ='large-10 columns']")).get(0).getText();
		driver.findElements(By.xpath("//*[@id='content']/div/p[2]/a")).get(0).click();;
		String nextData = driver.findElements(By.xpath("//*[@id='content']/div[3]/div[@class ='large-10 columns']")).get(0).getText();
		assertNotEquals(presentData,nextData);
		
		
	}
	
	@Test
	void testGeoLocation() {
		try {
			driver.navigate().to("https://the-internet.herokuapp.com/geolocation");		
			WebElement locationButton = driver.findElement(By.tagName("button"));
			locationButton.click();
			Thread.sleep(6000);
			driver.findElement(By.partialLinkText("on Google")).click();
			Thread.sleep(2000);
			driver.navigate().back(); 
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testWindows()
	{
		
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//div[@id='content']//a")).click();
		Set<String> windowHandles = driver.getWindowHandles();
        for(String winHandle : windowHandles){
            driver.switchTo().window(winHandle);
        }
        Assert.assertEquals(driver.getTitle(), "New Window");
		
	}
	
	@Test
	void testNotification()
	{
		driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
		driver.findElement(By.xpath("//a[@href = '/notification_message']")).click();
		String notification = driver.findElement(By.xpath("//div[@id = 'flash']")).getText();
		System.out.println(notification);
	}





}