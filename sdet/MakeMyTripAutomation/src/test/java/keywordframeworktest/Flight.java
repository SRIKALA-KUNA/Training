package keywordframeworktest;

import org.testng.annotations.Test;

import keywordframework.FrameWorkEngine;

public class Flight {
	FrameWorkEngine engine;
	
	@Test
	public void flightTest()
	{
		engine = new FrameWorkEngine();
		try {
			engine.readExcel("Sheet1");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}