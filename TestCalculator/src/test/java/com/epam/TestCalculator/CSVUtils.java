package com.epam.TestCalculator;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class CSVUtils {
	public  Object[][] subData() {
		CSVReader reader;
		Object[][] object= null ; 
		java.util.List<String[]> allData;
		int rowCount;
		int colCount;
		try {
			reader = new CSVReader(new FileReader("C:\\Users\\Srikala_Kuna\\eclipse-workspace\\TestCalculator\\CSV\\New Text Document.csv"));
			allData = reader.readAll();
			rowCount = allData.size();
			colCount = allData.get(0).length;
			object = new Object[rowCount][colCount];
			for (int row=0;row<rowCount ;row++)
			{
				for(int col =0; col<colCount ;col++)
				{
					object[row][col]= Long.parseLong(allData.get(row)[col]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object; 
	}
}