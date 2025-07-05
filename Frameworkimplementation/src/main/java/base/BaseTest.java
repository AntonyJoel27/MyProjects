package base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import config.ConfigReader;
import reports.ReportManager;
import utils.Log;
import utils.Utilities;

public class BaseTest {

	//global Variables
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		extent = ReportManager.getInstance(); // creates the report
		Log.initLogger();
		 Log.info("===== Test Suite Started =====");

	}

	@BeforeMethod
	public void setupDriver(Method method) {
		test = extent.createTest(method.getName()); // creates a new test section in the report
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Utilities.takeScreenshot(driver, result.getName());
			test.fail(result.getThrowable());
			test.addScreenCaptureFromPath(path);
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String path = Utilities.takeScreenshot(driver, result.getName());
			test.pass("✅ Test passed");
			test.addScreenCaptureFromPath(path);
		} else if (result.getStatus() == ITestResult.SKIP) {
			String path = Utilities.takeScreenshot(driver, result.getName());
			test.skip("⏭️ Test skipped");
			test.addScreenCaptureFromPath(path);
		}
		
	}

	@AfterSuite
	public void flushReport() {
		extent.flush(); // writes the HTML report to disk
	}

	public WebDriver getDriver() {
		return driver;
	}

	public ExtentTest getTest() {
		return test;
	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = ConfigReader.get("url");

		if (url != null) {
			driver.get(url);
		} else {
			throw new RuntimeException("URL not found in config.properties!");
		}

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {

			driver.quit();
		}

	}

}
