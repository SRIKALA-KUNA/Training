package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import base.Base;
import utils.Utils;

class CustomListener implements ITestListener				
{



	@Override
	public void onTestSuccess(ITestResult result) {
		try {

			Utils.takeScreenShot(Base.getDriverInstance());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {

			Utils.takeScreenShot(Base.getDriverInstance());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
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
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



}	