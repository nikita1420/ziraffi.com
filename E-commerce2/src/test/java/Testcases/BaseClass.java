package Testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import PageLayer.LoginPage;
import Utilities.EmailUtil;


public class BaseClass 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement element; 
   public String  url="http://139.59.15.212:8000/Home ";
    public static Logger log = Logger.getLogger(BaseClass.class);

//public static Logger log = Logger.getLogger(BaseClass.class);


@Parameters("browser")
@BeforeMethod
public void setup(String br)
{
	if(br.equalsIgnoreCase("chrome"))
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Nikita\\workspace\\E-Commerce\\Drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
		
	}
	else if(br.equalsIgnoreCase("firefox"))
	{
		
		 System.setProperty("webdriver.gecko.driver","C:\\Nikita\\workspace\\E-Commerce\\Drivers\\geckodriver.exe");
		    driver=new FirefoxDriver();
	}

	log.info("browser start");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get(url);
	
	
	
}
@AfterClass
public void teardown() throws Exception
{
	EmailUtil.sendemail();
	driver.close();
	
	log.info("browser close");
	}


public  static void waitmethod(WebDriver drive,String path)
{
	 wait=new WebDriverWait(driver,20);
	 element = wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	//element.isDisplayed();
		
}



public void captureScreenShot(WebDriver driver,String screenshotname)
{
	 TakesScreenshot ts=(TakesScreenshot)driver;
File	srcfile= ts.getScreenshotAs(OutputType.FILE);
File destfile=  new File("C:\\Users\\mayan\\git\\repository\\E-Commerce\\Screenshot"+"-"+screenshotname+"-"+System.currentTimeMillis()+".png");
try 
{
	Files.copy(srcfile, destfile);
} 
catch (Exception e) 
{
	System.out.println("error message is----"+e.getMessage());
	
}

}

public static String randomstring()
{
	
String genratedstring=RandomStringUtils.randomAlphabetic(4);
return(genratedstring);

}



}
