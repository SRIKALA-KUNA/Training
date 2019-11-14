package com.epam.Tasks;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Table extends Factory {
	String baseUrl;
	@BeforeClass
	void init() {

		baseUrl = "https://the-internet.herokuapp.com/tables";
	}
	@Test
	void testTableData() {
		driver.get(baseUrl);
		assertEquals(driver.findElement(By.xpath("//*[@id=\"table1\"]//tr[2]/td[2]")).getText(), "Frank");
	}

	@Test
	void testTableDataWithClassesAndIds() {
		driver.get(baseUrl);
		assertEquals(driver.findElement(By.xpath("//table[@id='table2']//tr[3]/td[@class='email']")).getText(), 
				"jdoe@hotmail.com");
	}

	@Test
	void testDelete() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[6]/a[@href='#delete']")).click();
		String expectedUrl = baseUrl+"#delete";
		assertEquals(driver.getCurrentUrl(), expectedUrl);
		driver.navigate().to(baseUrl);
		driver.findElement(By.xpath("//table[@id='table2']/tbody/tr[3]/td[6]/a[@href='#delete']")).click();
		String expectedUrlTable2 = baseUrl+"#delete";
		assertEquals(driver.getCurrentUrl(), expectedUrlTable2);
	}

}


