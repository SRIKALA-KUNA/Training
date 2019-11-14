package com.epam.TestCalculator;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		public ExcelUtils(String path, String sheetName) {
			try {
				workbook = new XSSFWorkbook(path);
				sheet = workbook.getSheet(sheetName);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		public  int rowCount() {
			int rowCount = sheet.getPhysicalNumberOfRows();
			return rowCount;
			
		}
		public int colCount() {
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			return colCount;
		}
		public int  getCellDataNumber(int rowNumber , int colNumber)
		{
			double cellData = sheet.getRow(rowNumber).getCell(colNumber).getNumericCellValue();
			return (int) cellData;
		}
	
}
