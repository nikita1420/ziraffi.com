package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Testcases.BaseClass;

public class Registrationpage extends BaseClass
{
WebDriver driver;

	
	public Registrationpage(WebDriver driver1)
	{
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}

	@FindBy(id="email") WebElement mailid;
	@FindBy(id="firstname") WebElement fstname;
	@FindBy(id="InputPassword") WebElement pass;
	@FindBy(id="repassword") WebElement repass;
	@FindBy(id="state") WebElement state1;
	@FindBy(id="Zip") WebElement zipcode;
	@FindBy(id="referred_by") WebElement refferal;
	@FindBy(id="lastname") WebElement lname;
	@FindBy(xpath="//*[@id=\'myModal1\']/div/div/form/button") WebElement submitbtn;
	
	@FindBy(xpath="//*[@id=\'myModal1\']/div/div/form/p[3]/a") WebElement login;
	@FindBy(xpath="//*[@id=\'book-login\']/button[2]") WebElement signupbtn;
	@FindBy(xpath="//*[@id=\"mailing\"]/input") WebElement checkbox;
	
	@FindBy(xpath="//*[@class='alert alert-success success-alert']/span") WebElement regmessage;
	
	public void testDataregistration(String email1, String password1,String password2,String firstname,String lastname1,String state,String zip,String type2) throws Throwable
	{
		signupbtn.click();
		mailid.sendKeys(email1);
		pass.sendKeys(password1);
		repass.sendKeys(password2);
		fstname.sendKeys(firstname);
		lname.sendKeys(lastname1);
		state1.sendKeys(state);
		zipcode.sendKeys(zip);
		
		if(type2.equalsIgnoreCase("refferal option is not selected"))
		{
			
			//captureScreenShot( driver, "when refferal option is not selected");
		}
		else
		{
			Select optn=new Select(refferal);
			optn.selectByValue("Friend" );
		}
		
		checkbox.click();
		Thread.sleep(3000);
	    submitbtn.click();
	    
	log.info("validation is started");
	
	
	boolean res= driver.getPageSource().contains("Thank you for registering with Vikreya.");
	  
	  if (res==true)
	  {  
		  String msg=	regmessage.getText(); 
		  log.info("User are successfully registered with message-->"+msg);
	
		  Assert.assertTrue(true);
		  
	  }else
	  {
		  log.info("There is some error. Please look Screenshots");
		  captureScreenShot(driver,type2);
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
     /* String msg=	regmessage.getText();
	 if(msg.contains("Thank you"))
	   {
		   log.info("User are successfully registered with message-->"+msg);
		   Assert.assertTrue(true);
	   }
	 else 
	 {
		 captureScreenShot( driver, type2);
	 }
	  
	 */
}
	
}
