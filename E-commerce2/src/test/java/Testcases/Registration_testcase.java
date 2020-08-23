package Testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageLayer.Homepage;
import PageLayer.LoginPage;
import PageLayer.Registrationpage;
import TestData.Gettestdata;
import TestData.Gettestdataforreg;

public class Registration_testcase extends BaseClass
{
	Registrationpage reg;
	String     email;


	@BeforeMethod
	public void regis()
	{
		reg= new Registrationpage(driver);
		     
	}
	
	@Test(dataProvider="exceltestdata2")
    public void registration(String email1, String password1,String password2,String firstname,String lastname1,String state,String zip,String type2) throws Throwable    
      {
		log.info("signup  when-->" +type2);	
	reg.testDataregistration(email1, password1, password2, firstname, lastname1, state, zip,type2);
	
	 }
	
	/*@DataProvider(name="exceltestdata2")
	public Iterator<Object[]> testData()
	{ 
		ArrayList<Object[]> testdata= Gettestdataforreg.getdatafromExcel();
		return testdata.iterator() ;
		
	}*/
	
	
		 @DataProvider (name = "exceltestdata2")
  public Object[][] dpMethod()
 {      email= randomstring()+"@gmail.com";
        String   email2= randomstring()+"@gmail.com";
           
		 return new Object[][] { {email,"password","password","nik","kapoor","co","80231","all fiels are filled"}, 	
			                      { email,"password","password","nik","kapoor","co","80231","refferal option is not selected"},
			                      {"","password","password","nik","kapoor","co","80231","empty mail id"},
			                      {email2,"password","password","","","","","empty firstname,lastname,state"}                       };
	}
		 
	

	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
}
