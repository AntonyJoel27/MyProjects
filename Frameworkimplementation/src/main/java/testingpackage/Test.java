package testingpackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Test {
	
	public static WebDriver driver = new ChromeDriver();

	
	public static void main(String[] args) throws IOException
	
	
	{
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = "screenshots/" + "testName1" + "_" + timestamp + ".png";

	
		File dest = new File(path);

	    Files.copy(src, dest);
	
	
}
}