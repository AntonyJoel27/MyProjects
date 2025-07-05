package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import pages.HomePage;
import pages.RegisterAccountPage;
import pages.SuccessPage;
import utils.ExcelReader;
import utils.Log;

public class SampleTest extends BaseTest {

	RegisterAccountPage registerAccountPage;
	SuccessPage successPaage;
	
	
	@Test (priority=0)
	public void navigateToRegisterPage() {
		HomePage homePage = new HomePage(driver);
		Log.info("Clicking My Account page");
		homePage.clickMyAccount();
		Log.info("Clicking My Register page");
		registerAccountPage= homePage.clickRegister();
		String registerPageBreadCrumbText= registerAccountPage.getTextOfregisterBreadCrumb();
		Log.info("Verifying whether user is on Register Paage");
		Assert.assertEquals(registerPageBreadCrumbText, "Register");
		Log.info("✅ Login test Failed");
		ExcelReader.excelReader("./ExcelFile.xlsx");
		ExcelReader.printSheetData("LoginTests");
		


	}
	

	@Test (priority=1)
	public void dataEntryInRegisterpage() {
        
		Log.debug("Entering FirstName");
		registerAccountPage.enterFirstname();
		Log.debug("Entering Lastname");
		registerAccountPage.enterLirstname();
		Log.debug("Entering Email");
		registerAccountPage.enterEmail();
		Log.debug("Entering Telephone Number");
		registerAccountPage.enterTelephoneNumber();
		Log.debug("Entering Password ");
		registerAccountPage.enterPassword();
		registerAccountPage.confirmPassword();
		registerAccountPage.selectNewsLetterOption();
		registerAccountPage.selectprivacyPolicy();
		successPaage=registerAccountPage.clickContinueButton();
		String successPageBreadCrumbText = successPaage.getAccountCreatedText();
		Assert.assertEquals(successPageBreadCrumbText, "Your Account Has Been Created!");
		Log.info("✅ Login test passed");


	}

}
