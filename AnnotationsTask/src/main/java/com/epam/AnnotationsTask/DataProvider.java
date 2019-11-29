package com.epam.AnnotationsTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import custom.annotations.Data;

public class DataProvider {
	@Data(name = "dataForSum")
	public Object additionData()
	{
		
		Object [][] obj = new Object[][] {
			{2,2,4},
			{0,2,2}
		};
		return obj;
		
	}
}
