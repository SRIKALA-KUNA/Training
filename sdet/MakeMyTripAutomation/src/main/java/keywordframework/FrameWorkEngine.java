package keywordframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Base;

public class FrameWorkEngine {
	WebDriver driver;
	WebElement element;
	Base base;
	public Properties prop;
	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	String locatorName,locatorValue , actionValue,value;
	String excelPath="C:\\Users\\Srikala_Kuna\\eclipse-workspace\\MakeMyTripAutomation\\resource\\flightData.xlsx";
	public void readExcel(String sheetName) throws InterruptedException
	{
		FileInputStream file =null;
		try {
			file = new FileInputStream(excelPath);
			book =WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);

		} catch (EncryptedDocumentException|IOException e) {

			e.printStackTrace();
		} 
		int k=0;
		for(int i=1; i< 15;i++)
		{

			String locatorColValue = sheet.getRow(i).getCell(k+1).toString().trim();

			locatorName = locatorColValue;
			actionValue =sheet.getRow(i).getCell(k+2).toString().trim();

			locatorValue = sheet.getRow(i).getCell(k+3).toString().trim();

			value =sheet.getRow(i).getCell(k+4).toString().trim();

			switch (actionValue) {
			case "open browser":
				base = new Base();
				try {
					driver = base.getBrowser();
				} catch (MalformedURLException e) {

					e.printStackTrace();
				}


				break;
			case "baseUrl": driver.get(value);

			break;
			default:
				break;
			}

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			switch (locatorName){
			case "xpath": 

				element = driver.findElement(By.xpath(locatorValue));
				if(actionValue.equals("click"))
				{

					element.click();
				}
				if(actionValue.equalsIgnoreCase("slider"))
				{
					Actions action= new Actions(driver);
					action.clickAndHold(element);
					action.moveByOffset(45,0);
					action.release().build().perform();
				}
				locatorName = null;
				break;

			default:
				break;
			}
		}
		driver.quit();

	}

}