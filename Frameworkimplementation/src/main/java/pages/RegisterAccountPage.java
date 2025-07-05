package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.ConfigReader;
import utils.Utilities;


public class RegisterAccountPage {
	
	WebDriver driver;
	
	
	public RegisterAccountPage (WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (id="input-firstname")
	public WebElement firstName;
	
	@FindBy (id="input-lastname")
	public WebElement lastName;
	
	@FindBy (id="input-email")
	public WebElement eMail;
	
	@FindBy (id="input-telephone")
	public WebElement telephone;
	
	@FindBy (id="input-password")
	public WebElement passWord;
	
	@FindBy (id="input-confirm")
	public WebElement passWordConfirm;

	@FindBy (xpath= "(//input[@name='newsletter'])[1]")
    public WebElement newLetterSelection;
	
	@FindBy (xpath= "//input[@name='agree']")
    public WebElement privacyPolicy;
	
	@FindBy (xpath= "//input[@value='Continue']")
    public WebElement continueButton;
	
	@FindBy (linkText ="Register")
	public WebElement registerBreadCrumb;
	
	public String getTextOfregisterBreadCrumb()
	{
		return registerBreadCrumb.getText();
		
	}
	
	public void enterFirstname()
	{
		
		firstName.sendKeys(ConfigReader.get("firstName"));
	}
	
	public void enterLirstname()
	{
		
		lastName.sendKeys(ConfigReader.get("lastName"));
	}
	
	public void enterEmail()
	{
		
		eMail.sendKeys(Utilities.generateBrandNewEmail());
	}
	
	public void enterTelephoneNumber()
	{
		telephone.sendKeys(ConfigReader.get("telephone"));
		
	}
	
	public void enterPassword()
	{
		passWord.sendKeys(ConfigReader.get("passWord"));
		
	}
	
	public void confirmPassword()
	{
		
		passWordConfirm.sendKeys(ConfigReader.get("passWordConfirm"));
		
	}
	
	public void selectNewsLetterOption()
	{
		newLetterSelection.click();
		
	}
	
	public void selectprivacyPolicy()
	{
		privacyPolicy.click();
		
	}
	
	public SuccessPage clickContinueButton()
	{
		
		continueButton.click();
		return new SuccessPage(driver);
		
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

