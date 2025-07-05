package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.Utilities;

public class ScreenshotListener extends BaseTest implements ITestListener  {
	
	 @Override
	    public void onTestFailure(ITestResult result) {
		 
		 Object testClass = result.getInstance();
		 WebDriver driver = ((BaseTest) testClass).driver;

		 
		 String testName = result.getName();
		 
		 String screenshotPath = Utilities.takeScreenshot(driver, testName);
	     System.out.println("🛑 Test Failed: Screenshot saved at " + screenshotPath);

	 }
	
	
	

}
