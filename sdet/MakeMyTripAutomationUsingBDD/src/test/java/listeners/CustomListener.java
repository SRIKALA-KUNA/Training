package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import base.Base;
import utils.Utils;

public class CustomListener implements ITestListener				
{		

	@Override		
    public void onFinish(ITestContext arg0) {					
		try {
			
			Utils.takeScreenShot(Base.getDriverInstance());
		} catch (IOException e) {

			e.printStackTrace();
		}			
        		
    }	
	 @Override		
	    public void onTestFailure(ITestResult arg0) {					
		 try {
				Utils.takeScreenShot(Base.getDriverInstance());
			} catch (IOException e) {

				e.printStackTrace();
			}			
	        		
	    }
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}	