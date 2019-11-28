package com.epam.AnnotationsTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import custom.annotations.Data;

public class DataProvider {
	@Data(name = "dataForSum")
	public Object sumData()
	{
		/*Map<List<Integer>,Integer> sum = new HashMap();
		sum.put(Arrays.asList(2,2), 4);
		sum.put(Arrays.asList(0,2), 2);
		sum.put(Arrays.asList(-2,2), 0);
		return sum;	
		*/
		Object [][] obj = new Object[][] {
			{2,2,4},
			{0,2,2}
		};
		return obj;
		
	}
}
