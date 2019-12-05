package listeners;



import org.junit.runner.JUnitCore;

import test.AdditionTest;

public class Runner {


	public static void main(String[] args)
	{
		JUnitCore runner = new JUnitCore();    
        runner.addListener(new CustomListener());
        runner.run(AdditionTest.class);
	}

}
