package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	// TODO Auto-generated method stub
		static WebDriver driver;
		

		@BeforeClass
		@Parameters({"os", "browser"})
		public void setup(String os,String br)
		{
			switch(br.toLowerCase())
			{
			case "chrome":  driver=new ChromeDriver();break;
			case "edge":  driver=new EdgeDriver();break;
			case "firefox":  driver=new FirefoxDriver();break;
			
			default:System.out.println("Invalid browser name : ");
			         return;
			         
			}
		    driver.get("https://practicesoftwaretesting.com");
		    driver.manage().window().maximize();
		}

		public String randomAlphabets(int length)
		{
			String generatedEmail = RandomStringUtils.secure().nextAlphabetic(5);
			return generatedEmail;
		}
		public String randomNumbers(int length)
		{
			String generatedNumber = RandomStringUtils.secure().nextNumeric(10);
			return generatedNumber;
		}
		public String alphaNumbers()
		{
			String generated = RandomStringUtils.secure().nextAlphanumeric(6);
			return generated;
		}
		
		public String captureScreen(String tname) throws IOException {
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp+".png";
			File targetFile=new File(targetFilePath);

			sourceFile.renameTo(targetFile);

			return targetFilePath;
			
		}
		
		

	/*	@AfterClass
		public void tearDown()
		{
		    driver.quit();
		}  */

	

}
