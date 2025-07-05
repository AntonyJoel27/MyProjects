package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utilities;

public class HomePage {
	
WebDriver driver;
	
	
	public HomePage (WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//span[text()='My Account']")
	public WebElement myAccount;
	
	@FindBy (linkText ="Register")
	public WebElement register;
	
	public void clickMyAccount()
	{
		Utilities.waitForElementToBeClickable(driver, myAccount, 10);
		myAccount.click();
	}
	
	public RegisterAccountPage clickRegister()
	{
		Utilities.waitForElementToBeClickable(driver, register, 10);
		register.click();
		return new RegisterAccountPage(driver);
	}
	
	
}
