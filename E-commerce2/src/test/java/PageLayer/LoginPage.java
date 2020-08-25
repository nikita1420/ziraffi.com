package PageLayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Testcases.BaseClass;

public class LoginPage extends Testcases.BaseClass
{
WebDriver driver;

	
	public LoginPage(WebDriver driver1)
	{
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}

	@FindBy(xpath="//*[@id=\'book-login\']/button[1]") WebElement login;
	@FindBy(xpath="//*[@id=\'myModal\']/div/div/form/div[1]/input") WebElement email;
	@FindBy(xpath="//*[@id=\'myModal\']/div/div/form/div[2]/input") WebElement pass;
	@FindBy(xpath="//*[@id=\'myModal\']/div/div/form/button") WebElement clickloginbutton;
	@FindBy(xpath="//html/body/div[1]/div[3]/div/button") WebElement name;
	@FindBy(xpath="/html/body/div[1]/div[3]/div/div/a[9]") WebElement logout;
	@FindBy(xpath="//*[@class='alert alert-danger success-alert']") WebElement loginerrmsg;
	
	
	@FindBy(xpath="//*[@class='alert alert-success success-alert']/span") WebElement loginmsg;
	
	
	
	public void testDatalogin(String uname1, String password1,String type1) throws InterruptedException
	{  
		Thread.sleep(2000);
		login.click();
		email.sendKeys(uname1);
		pass.sendKeys(password1);
		clickloginbutton.click();
		try {
			Thread.sleep(2000);
		} 
		catch (Exception e) {
			
		}
		 
		if(type1.equalsIgnoreCase("invalid"))
		{
			String	actualerrormessage =loginerrmsg.getText();
			
			   if(actualerrormessage.contains("   The user name you entered is incorrect. Check your username (email) or create an account if you don't have an account with us.  "))
			   {
				   log.info("User are not able to login with invalid credentials");
				   System.out.println("Error message recived-->"+actualerrormessage);
			   }
		}
		else
		{ 
			
			String actual = loginmsg.getText();
			Assert.assertEquals(actual, "   Your login is successfully completed.");
			log.info("User are allowed to login successfully with meassge"+actual);
			
		}
				
	}
	
	public  String validloginpageTitle()
	 {
		return driver.getTitle(); 
		 
	 }
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(name).build().perform();
		logout.click();
		
	
	}


	public void validlogin()
	{

		login.click();
		email.sendKeys("kapoor.nikita5455@gmail.com");
		pass.sendKeys("password@12345");
		clickloginbutton.click();
	}
}
