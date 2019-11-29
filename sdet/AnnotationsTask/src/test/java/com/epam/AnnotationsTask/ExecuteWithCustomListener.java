package com.epam.AnnotationsTask;
import org.junit.runner.JUnitCore;
 
public class ExecuteWithCustomListener
{
    public static void main(String[] args)
    {
        JUnitCore runner = new JUnitCore();
        
        runner.addListener(new CustomListener());
        runner.run(AdditionTest.class);
    }
}
/*import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class Runner extends BlockJUnit4ClassRunner
{
    public Runner(Class<?> klass) throws InitializationError
    {
         super(klass);
    }

    @Override
    public void run(RunNotifier notifier)
    {
        notifier.addListener(new CustomListener()); 
        super.run(notifier);
    }
}*/