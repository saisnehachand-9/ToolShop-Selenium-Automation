package Utilities;

import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import testCases.BaseClass;

public class ListenerExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

String repName;
@Override
public void onStart(ITestContext testContext) {   //  // create/configure report

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
            .format(new Date());

    repName = "Test-Report-" + timeStamp + ".html";

    sparkReporter = new ExtentSparkReporter(
            ".\\Reports\\" + repName
    );

    sparkReporter.config().setDocumentTitle("ToolStop Automation Report");
    sparkReporter.config().setReportName("ToolStop Functional Testing");

    extent = new ExtentReports();

    extent.attachReporter(sparkReporter);
    String os = testContext
            .getCurrentXmlTest()
            .getParameter("os");

    String browser = testContext
            .getCurrentXmlTest()
            .getParameter("browser");

    extent.setSystemInfo("Tester", "Sai Sneha");
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("Operating System", os);
    extent.setSystemInfo("Browser", browser);
}
				@Override
				public void onTestStart(ITestResult result) {

    					test = extent.createTest(result.getName());
					}
				@Override
				public void onTestSuccess(ITestResult result) {
				    test.log(Status.PASS, result.getName()+" got successfully executed");
				}
				
				@Override
				public void onTestFailure(ITestResult result) {

				    test.log(Status.FAIL, "Test Failed");

				    test.log(Status.INFO, result.getThrowable().getMessage());
				    try {
						  String imgPath = new BaseClass().captureScreen(result.getName());
						 // System.out.println("Screenshot path: " + imgPath);
						  //  System.out.println("Screenshot exists: " + new File(imgPath).exists());

						  test.addScreenCaptureFromPath(imgPath);

						  } 
					  catch (IOException e1) {
						  e1.printStackTrace();

						  }
				}
				
				@Override
				public void onFinish(ITestContext testContext) {

				    extent.flush();
				}
				
				
}