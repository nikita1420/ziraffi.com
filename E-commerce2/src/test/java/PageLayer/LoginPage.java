package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	@FindBy(xpath="/html/body/div[4]/div[1]/div/div/span") WebElement loginerrmsg;
	@FindBy(xpath="//*[@class='alert alert-success success-alert']/span") WebElement loginmsg;
	
	
//this function will login with multiple set of data	using excel
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
				
		     if(actualerrormessage.contains("The user name you entered is incorrect. Check your username (email) or create an account if you don't have an account with us"))
				   {
					   log.info("User are not able to login with INVALID eMAIL ID credentials");
					   System.out.println("Error message recived-->"+actualerrormessage);
				   }
		     else
			    { 
				
				log.info("User are not allowed to login  with  wrong passord ");
				 System.out.println("Error message recived-->"+actualerrormessage);
				}
		}
		if(type1.equalsIgnoreCase("blank"))
		{
			if(clickloginbutton.isDisplayed())
			{
				Assert.assertTrue(true);
			log.info("User are not allowed to click on Login Button with  Empty Credentials ");
			}
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

//this function will login with valid credentials
	public void validlogin()
	{

		login.click();
		email.sendKeys(username);
		pass.sendKeys(password);
		clickloginbutton.click();
	}
}
