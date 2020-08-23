package PageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.BaseClass;

public class Homepage extends BaseClass
{
WebDriver driver;
	

	public Homepage(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}


	@FindBy(xpath="//*[text()='Deals']") WebElement deals;
	@FindBy(xpath="//*[text()='Coupons']") WebElement coupons;
	@FindBy(xpath="//*[text()='Promotions']") WebElement promotion;
	@FindBy(xpath="//*[text()='Classifieds']") WebElement classified;
	@FindBy(xpath="//*[text()='Categories']") WebElement category;
	@FindBy(xpath="//*[text()='Home']") WebElement home; 

	
	public Dealapage clickondeal()
	{
		deals.click();
		return new Dealapage();
		
	}
	public couponss clickoncoupon()
	{
		coupons.click();
		return new couponss();
		
	}
	public String verifyhomepageTitle()
	{
		return driver.getTitle();
	}
	 
	}

