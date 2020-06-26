package tyssframework.listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import tyssframework.lib.Genericlib;

public class MyListeners implements ITestListener {

	public void onTestStart(ITestResult result) 
	{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
				String startTime = LocalDateTime.now().format(dtf);
				Reporter.log("The Testcase: "+result.getName()+"started at :"+startTime);

		
	}

	public void onTestSuccess(ITestResult result) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String endTime = LocalDateTime.now().format(dtf);
		Reporter.log("The Testcase: "+result.getName()+"completed at :"+endTime);

		
	}

	public void onTestFailure(ITestResult result) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String endTime = LocalDateTime.now().format(dtf);
		Reporter.log("The Testcase: "+result.getName()+"failed at :"+endTime);
		
		WebDriver driver=(WebDriver)result.getTestContext().getAttribute("driver");
		Genericlib.saveScreenshot(driver, result.getName());

		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	

	public void onStart(ITestContext context) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String startTime = LocalDateTime.now().format(dtf);
		Reporter.log("The testsuite started at :"+startTime);

		
	}

	public void onFinish(ITestContext context) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String endTime = LocalDateTime.now().format(dtf);
		Reporter.log("The Testsuite finished at :"+endTime);

		
	}

}
