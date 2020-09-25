package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtentReporting extends TestListenerAdapter
	{
				//builds a new report using the html template 	
				public ExtentHtmlReporter htmlreporter;
				
				//Specify the location of report
				public ExtentReports extent;
				public WebDriver driver;
				
				//helps to generate the logs in test report.
				public static ExtentTest logger; 

	@Override
	public void onStart(ITestContext testcontext)
	{
		String timestramp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname=testcontext.getName()+"-"+timestramp+".html";
		
		// initialize the HtmlReporter	
	htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repname);
	  htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

	  //initialize ExtentReports and attach the HtmlReporter and specify location of
	extent=new ExtentReports();
	   extent.attachReporter(htmlreporter);

	 //To add system or environment info by using the setSystemInfo method.
	extent.setSystemInfo("Host name","nikita");
	extent.setSystemInfo("Enviroment","QA");
	extent.setSystemInfo("user","Nikita");

	//configuration items to change the look and feel
    //add content, manage tests etc
	htmlreporter.config().setDocumentTitle("Ziraffi.Com");
	//htmlreporter.config().setReportName("functional Test Report");
	htmlreporter.config().setTheme(Theme.DARK);


	}

	@Override
	public void onTestSuccess(ITestResult tr)
	{
		
	logger=extent.createTest(tr.getName());//create new entry in the report
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	extent.flush();

	}

	 @Override
	  public void onTestFailure(ITestResult result)
	  {
		 
		 System.out.println("this test is failed"); 
			if(result.getStatus() == ITestResult.FAILURE)
			{
	logger.log(Status.FAIL, "Test Case Failed is "+result.getName());//to add name in extent report
	logger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());//to add error/exception in extent report
	
	ScreenShot screenshot=new ScreenShot();
	String path=screenshot.captureScreenShot(driver, result.getName());
try {
	logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(path));
} catch (Exception e) {
	
}//to add screenshot in extent report
			       
			}
			
			

		 /*   if (result.getStatus() == ITestResult.FAILURE) 
		    {
logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " Test case FAILED due to below issues:", ExtentColor.RED));
		    	logger.fail(result.getThrowable());
		    	
		    } */
		    extent.flush();
	  }

	 @Override
	  public void onTestSkipped(ITestResult tr)
	 {
		 logger=extent.createTest(tr.getName());//create new entry in the report
			logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	  }

	
	/*@AfterMethod
	public void AfterMethod(ITestResult result) {

	    if (result.getStatus() == ITestResult.FAILURE) {
	    	logger.log(Status.FAIL,
	                MarkupHelper.createLabel(result.getName()
	                        + " Test case FAILED due to below issues:",
	                        ExtentColor.RED));
	    	logger.fail(result.getThrowable());
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	    	logger.log(
	                Status.PASS,
	                MarkupHelper.createLabel(result.getName()
	                        + " Test Case PASSED", ExtentColor.GREEN));
	    } else {
	    	logger.log(
	                Status.SKIP,
	                MarkupHelper.createLabel(result.getName()
	                        + " Test Case SKIPPED", ExtentColor.ORANGE));
	    	logger.skip(result.getThrowable());
	    }*/
	


	
}
	

