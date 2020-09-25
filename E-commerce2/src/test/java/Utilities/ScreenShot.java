package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

public class ScreenShot
{


public  String captureScreenShot(WebDriver driver,String screenshotname)
{
	String timestramp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String path= System.getProperty("user.dir")+"/FailedScreenshots/"+"-"+screenshotname+"-"+timestramp+".png";
	try {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File srcfile=ts.getScreenshotAs(OutputType.FILE);

File destfile=  new File(path);

	Files.copy(srcfile, destfile);
	}
 
catch (Exception e) 
{
	System.out.println("error message is----"+e.getMessage());
	
}

return path;

	}
}