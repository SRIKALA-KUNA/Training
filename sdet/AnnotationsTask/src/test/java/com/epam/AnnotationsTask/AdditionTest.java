package com.epam.AnnotationsTask;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import custom.annotations.Data;
import custom.annotations.DataInjection;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(ExecuteWithCustomListener.class)
public class AdditionTest {
	Addition sum;
	@BeforeAll
	public void init()
	{
		System.out.println("hello");
		sum = new Addition();
	}

	@Test()
	@DataInjection(dataProvider ="dataForSum")
	public void testSum(Object obj[][]) {
		System.out.println("hfkjdfs");
		for(int i=0;i<2;i++)
		{
				int actual = sum.add((int)obj[i][0],(int)obj[i][1]);
				assertEquals((int)obj[i][2],actual);
			
		}
		
	}
	
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
