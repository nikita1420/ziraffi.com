package Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageLayer.Homepage;
import PageLayer.LoginPage;

public class HomePage_Testcases extends BaseClass	
{
	LoginPage loginpage;
	Homepage homepage;
	
	@BeforeMethod
	public void login()
	{
		loginpage =new LoginPage(driver);
		loginpage.validlogin();
		homepage= new Homepage(driver);
	}
	
	@Test
	public void verifyhomepagetitle()
	{
	String actualtitle=homepage.verifyhomepageTitle();
	Assert.assertEquals(actualtitle, "Free Coupons, Promotions, Hot Deals, Free Classifieds | Zirafi.com");
	log.info("home page verified");	
	}
	
}
