package com.epam.TestCalculator;

import java.util.ArrayList;
import java.util.List;


import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.beust.testng.TestNG;

public class Runner {

	public static void main(String args[])
	{
		XmlSuite suite = new XmlSuite();
		suite.setName("Suite1");
		XmlTest test = new XmlTest(suite);
		test.setName("Test1");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.epam.TestCalculator.CalculatorTest"));
		test.setXmlClasses(classes) ;
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}
}
