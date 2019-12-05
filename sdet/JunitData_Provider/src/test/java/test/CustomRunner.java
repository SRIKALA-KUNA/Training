package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;


import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import custom.annotations.Data;
import custom.annotations.DataInjection;



public class CustomRunner extends Runner {
	String msg1 = "";
	String msg = "";
  HashMap<String,Object[][]> data=new HashMap<String, Object[][]>();
  private Class<?> testClass;
    public CustomRunner(Class<?> AddtiondTest) {
        super();
        this.testClass = AddtiondTest;
    }
 
    @Override
    public Description getDescription() {
        return Description
          .createTestDescription(testClass, "My runner description");
    }
 
    public void run(RunNotifier notifier) {
    	System.out.println("running the tests from CustomRunner: " + testClass);
        String dataprovidername = "";
        Object[][] testdata = null;
        String testdataname;
        try {
            Object testObject = testClass.newInstance();
            for (Method method : testClass.getMethods()) {
                if (method.isAnnotationPresent(Data.class)) {
                	
                    dataprovidername=method.getAnnotation(Data.class).name();   
                    testdata=(Object[][]) method.invoke(testObject);
                   data.put(dataprovidername, testdata);
                }
            }
            for (Method method : testClass.getMethods()) {
                if (method.isAnnotationPresent(DataInjection.class)) {
                	notifier.fireTestStarted(Description
                            .createTestDescription(testClass, method.getName()));
                     testdataname=method.getAnnotation(DataInjection.class).dataProvider();
                     if(data.containsKey(testdataname))                 
                    {
                    	
                    	for(int i=0;i<data.get(testdataname).length;i++)
                        method.invoke(testObject, data.get(testdataname)[i]);
                    }
                     notifier.fireTestStarted(Description
                             .createTestDescription(testClass, method.getName()));
                  
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

	
}