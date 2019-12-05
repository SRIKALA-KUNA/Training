package listeners;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import custom.annotations.Data;
import custom.annotations.DataInjection;
import test.AdditionTest;

public class CustomListener extends RunListener {

	public void testStarted(Description description) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		HashMap<String,Object[][]> data=new HashMap<String, Object[][]>();
		String dataInjectionName = null,dataProviderName = null;
		Object[][] testData = null;
		Class<test.AdditionTest> obj = test.AdditionTest.class;
		for (Method method : obj.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Data.class)) {

				Annotation annotation = method.getAnnotation(Data.class);
				dataProviderName = method.getAnnotation(Data.class).name();
				testData =(Object[][]) method.invoke(new AdditionTest());
				data.put(dataProviderName, testData);

			}
		}
		for (Method method : obj.getDeclaredMethods()) {
			if(method.isAnnotationPresent(DataInjection.class))
			{
				Annotation annotation = method.getAnnotation(DataInjection.class);
				dataInjectionName = method.getAnnotation(DataInjection.class).dataProvider();
				if(data.containsKey(dataInjectionName))                 
				{

					for(int i=0;i<data.get(dataInjectionName).length;i++)
						method.invoke(new AdditionTest(), data.get(dataInjectionName)[i]);
				}

			}}
	}
	public void testFailure(Description description) {
		System.out.println("failed...");
	}
}
