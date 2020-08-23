package Testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageLayer.LoginPage;
import TestData.Gettestdata;

public class Login_TestCases  extends BaseClass
{
	LoginPage loginpage;
	
	@BeforeMethod
	public void setup()
	{
		loginpage =new LoginPage(driver);
		
	}

	@Test(dataProvider="exceltestdata")
      public void loginVerified(String uname1,String password1,String type1) throws InterruptedException    
      {
		log.info("login with--" +type1+"--credentials");
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	loginpage.testDatalogin(uname1, password1, type1);
	
	 }

	
	@DataProvider(name="exceltestdata")
	public Iterator<Object[]> testData()
	{ 
		
				ArrayList<Object[]> testdata= Gettestdata.getdatafromExcel();
		return testdata.iterator() ;
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
}
