package KeyWordFrameWorkTest;

import org.testng.annotations.Test;

import KeyWordFramework.FrameWorkEngine;

public class Flight {
	FrameWorkEngine engine;
	
	@Test
	public void flightTest()
	{
		engine = new FrameWorkEngine();
		engine.readExcel("Sheet1");
	}

}
