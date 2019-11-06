package com.epam.TestCalculator;

import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;
@Listeners(CustomListener.class)
public class CalculatorTest {
	Calculator cal;
	@BeforeClass(alwaysRun = true)
	public void initialize() {
		cal = new Calculator();
	}
	
	@AfterClass
	public void close()
	{
		cal =null;
	}



	@Test(dataProvider = "sumDataLong" , dataProviderClass =DataProviderClass.class, groups = {"sum"})
	public void testSum(long inputNumberOne, long inputNumberTwo, long expectedResult) {
		assertEquals(expectedResult, cal.sum(inputNumberOne,inputNumberTwo));
	}

	@Test(dataProvider = "sumDataDouble" , dataProviderClass =DataProviderClass.class, groups = {"sum"})
	public void testSum(double inputNumberOne, double inputNumberTwo, double expectedResult) {
		assertEquals(expectedResult, cal.sum(inputNumberOne,inputNumberTwo));
	}

	@Test(dataProvider = "subDataLong" , dataProviderClass =DataProviderClass.class,groups = { "sub"})
	public void testSub(long inputNumberOne, long inputNumberTwo, long expectedResult) {
		System.out.println(inputNumberOne);
		assertEquals(expectedResult, cal.sub(inputNumberOne,inputNumberTwo));
	}

	@Test(dataProvider = "subDataDouble" , dataProviderClass =DataProviderClass.class,groups = {"sub"})
	public void testSub(double inputNumberOne, double inputNumberTwo, double expectedResult) {
		assertEquals(expectedResult, cal.sub(inputNumberOne,inputNumberTwo));
	}

	@Test(dataProvider = "multDataLong" , dataProviderClass =DataProviderClass.class,groups = {"mult"})
	public void testMult(long inputNumberOne, long inputNumberTwo, long expectedResult) {
		assertEquals(expectedResult, cal.mult(inputNumberOne,inputNumberTwo));
	}

	@Test(dataProvider = "multDataDouble" , dataProviderClass =DataProviderClass.class,groups = {"mult"})
	public void testMult(double inputNumberOne, double inputNumberTwo, double expectedResult) {
		assertEquals(expectedResult, cal.mult(inputNumberOne,inputNumberTwo));
	}

	@Test(dataProvider = "divDataLong" , dataProviderClass =DataProviderClass.class,groups = {"div"})
	public void testDiv(long inputNumberOne, long inputNumberTwo, long expectedResult) {
		assertEquals(expectedResult, cal.div(inputNumberOne,inputNumberTwo));
	}

	@Test(dataProvider = "divDataDouble" , dataProviderClass =DataProviderClass.class,groups = {"div"} )
	public void testDiv(double inputNumberOne, double inputNumberTwo, double expectedResult) {
		assertEquals(expectedResult, cal.div(inputNumberOne,inputNumberTwo));
	}
	
	@Test(dataProvider = "divDataBy0" , dataProviderClass =DataProviderClass.class,groups = {"div"}, expectedExceptions= { AssertionError.class } )
	public void testDivBy0(double inputNumberOne, double inputNumberTwo, double expectedResult) {
		assertEquals(expectedResult, cal.div(inputNumberOne,inputNumberTwo));
	}

	@Test(dataProvider = "sqrtData" , dataProviderClass =DataProviderClass.class,groups = {"additional"} )
	public void testSqrt(double inputNumber, double expectedResult) {
		assertEquals(expectedResult, cal.sqrt(inputNumber));
	}
	
	
	@Test(dataProvider = "powDataDouble" , dataProviderClass =DataProviderClass.class,groups = {"aditional"})
	public void testPow(double input,double exponent, double expectedResult) {
		assertEquals(expectedResult, cal.pow(input,exponent));
	}
	
	@Test
	public void testSin()
	{
		assertTrue(false);
	}
	
	@Test(dependsOnMethods = {"testSin"})
	public void testcos()
	{
		assertTrue(true);
	}




}
