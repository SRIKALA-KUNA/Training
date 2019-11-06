package com.epam.TestCalculator;

import java.util.logging.Logger;

public class ExcelSumDataProvider {
	public Object[][] sumData(String path, String sheetName)
	{
		ExcelUtils excel = new ExcelUtils(path, sheetName);
		int rowCount = excel.rowCount();
		int colCount = excel.colCount();
		Object[][] object = new Object[rowCount][colCount];
		for(int row =0;row<rowCount ;row++)
		{
			for(int col =0; col< colCount ;col++)
			{
				
				object[row][col] = excel.getCellDataNumber(row, col);
			}
		}
		return object;
	}

}
