package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting extends TestListenerAdapter
	{
		
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@Parameters({ "Testname" })
	public void onStart(ITestContext testcontext,String Testname)
	{
		String timestramp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname=Testname+timestramp+".html";
		
	htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repname);
	    htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

	extent=new ExtentReports();
	   extent.attachReporter(htmlreporter);

	extent.setSystemInfo("Host name","localhost");
	extent.setSystemInfo("Enviroment","QA");
	extent.setSystemInfo("user","abcdef");

	htmlreporter.config().setDocumentTitle("Flipcart  project");
	//htmlreporter.config().setReportName("functional Test Report");
	htmlreporter.config().setTheme(Theme.DARK);


	}

	public void onTestSuccess(ITestResult tr)
	{
		
	logger=extent.createTest(tr.getName());//create new entry in the report
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	extent.flush();

	}
	public void onTestFaliure(ITestResult tr)
	{
		
	logger=extent.createTest(tr.getName());//create new entry in the report
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	String screenshotpath=System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+".png";
	File f=new File(screenshotpath);


	if(f.exists())
	{
		try {
			logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
		} 
		catch (Exception e) 
		{
		
		}

	}
	}

	public void onSkipped(ITestResult tr)
	{
		
	logger=extent.createTest(tr.getName());//create new entry in the report
	logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}




	}

