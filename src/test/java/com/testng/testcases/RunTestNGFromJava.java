package com.testng.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RunTestNGFromJava {
	 
	public static void main(String[] args) {
	TestNG runner=new TestNG();
	List<String> suitefiles=new ArrayList<String>();
	suitefiles.add("grouptest.xml");
	runner.setTestSuites(suitefiles);
	runner.run();
	}
}
