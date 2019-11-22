package com.epam.MakeMyTripAutomation;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import base.Base;

class CustomListener implements ITestListener				
{		

	@Override		
    public void onFinish(ITestContext arg0) {					
		try {
			
			Utils.takeScreenShot(Base.getDriver());
		} catch (IOException e) {

			e.printStackTrace();
		}			
        		
    }	
	 @Override		
	    public void onTestFailure(ITestResult arg0) {					
		 try {
				Utils.takeScreenShot(Base.getDriver());
			} catch (IOException e) {

				e.printStackTrace();
			}			
	        		
	    }
}	