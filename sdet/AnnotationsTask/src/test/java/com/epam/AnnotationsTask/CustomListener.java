package com.epam.AnnotationsTask;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import custom.annotations.Data;
import custom.annotations.DataInjection;

public class CustomListener extends RunListener {
	public void testStarted(Description description) {
		String className, method;
		if (description.getAnnotation(DataInjection.class) != null){
			className =  description.getClassName();
			method  =description.getMethodName();
			System.out.println(className+""+method);
		}
	}
	public void testFinished(Description description) {
		System.out.println("Finished .... "+ description.getMethodName());
	}
	public void testRunFinished(Result result) {
		System.out.println("\n\n");
	}
}
