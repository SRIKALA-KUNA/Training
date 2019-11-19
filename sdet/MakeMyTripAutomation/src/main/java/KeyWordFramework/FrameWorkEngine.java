package KeyWordFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.Base;

public class FrameWorkEngine {
	WebDriver driver;
	WebElement element;
	Base base;
	public Properties prop;
	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	String locatorName,locatorValue , actionValue,value;
	String excelPath="C:\\Users\\Srikala_Kuna\\eclipse-workspace\\MakeMyTripAutomation\\resource\\flightData.xlsx";
	public void readExcel(String sheetName)
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
		for(int i=1; i< sheet.getLastRowNum();i++)
		{
			String locatorColValue = sheet.getRow(i).getCell(k+1).toString().trim();
			//if(!locatorColValue.equalsIgnoreCase("NA"))
			//{
			locatorName = locatorColValue;
			locatorValue = sheet.getRow(i).getCell(k+3).toString().trim();
			//}
			actionValue =sheet.getRow(i).getCell(k+2).toString().trim();
			value =sheet.getRow(i).getCell(k+4).toString().trim();
			switch (actionValue) {
			case "open browser":
				base = new Base();
				prop = base.init_properties();
				driver = base.init();

				break;
			case "baseUrl": driver.get(value);
			break;
			default:
				break;
			}
			switch (locatorName){
			case "xpath": 
				element =driver.findElement(By.xpath(locatorValue));
				if(actionValue.equalsIgnoreCase("click"))
				{
					System.out.println(actionValue);
					element.click();
				}
				if(actionValue.equalsIgnoreCase("slider"))
				{
					Actions action= new Actions(driver);
					action.clickAndHold(element);
					action.moveByOffset(45,0);
					action.release().build().perform();
				}
				//locatorName = null;
				break;

			default:
				break;
			}
		}

	}

}
