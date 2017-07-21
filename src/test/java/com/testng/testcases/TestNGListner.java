package com.testng.testcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
Listeners gives us the ability to act before and after of every Suite, Test and Methods.
There are many types of listeners available in TestNG for example IAnnotationTransformer, 
IAnnotationTransformer2, IConfigurable, IConfigurationListener, IConfigurationListener2, 
IExecutionListener, IHookable, IInvokedMethodListener, IInvokedMethodListener2, 
IMethodInterceptor, IReporter, ISuiteListener, ITestListener.*/

/*Implementing ITestListner*/
/*Two listener are there class level and suite level*/


public class TestNGListner implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started and details are : "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success and details are : "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed and details are : "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped and details are : "+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
