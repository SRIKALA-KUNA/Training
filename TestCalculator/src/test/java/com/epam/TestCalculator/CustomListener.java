package com.epam.TestCalculator;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
	      System.out.println(tr.getName()+ "-- This test method failed\n");
	   }

}
