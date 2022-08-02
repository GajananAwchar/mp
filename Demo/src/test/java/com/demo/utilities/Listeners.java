package com.demo.utilities;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
public class Listeners extends TestListenerAdapter {
	@Override
	public void onTestSuccess(ITestResult tr) {
		String test_Name= tr.getName();
		System.out.println(test_Name + "is sucess / passed");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test is failed");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("test is skipped");
			}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test is started");
			}

}
