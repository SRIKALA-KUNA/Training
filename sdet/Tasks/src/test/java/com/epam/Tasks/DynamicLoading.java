package com.epam.Tasks;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicLoading  extends Factory{
	//private static final By ID = finish;


	@Test
	void testDynamicLoading() {
		String[] example = {"//*[@id=\"content\"]//a[1]","//*[@id=\"content\"]//a[2]"} ;
		for (int typesOfDynamicLoading =0 ;typesOfDynamicLoading <example.length; typesOfDynamicLoading++) {
			driver.get("https://the-internet.herokuapp.com/dynamic_loading");
			driver.findElement(By.xpath(example[typesOfDynamicLoading])).click();
			driver.findElement(By.xpath("//*[@id='start']/button")).click();
			WebDriverWait wait=new WebDriverWait(driver, 5);
			String data = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4"))).getText();
			assertEquals(data, "Hello World!");
		}

	}

}
