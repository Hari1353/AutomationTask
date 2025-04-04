package com.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass extends CommonUtils {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest test;
	public ExtentColor color;
	@SuppressWarnings("rawtypes")
	public WebDriver driver;
	public AndroidDriver androidDriver;
	
	String webURL = "https://www.saucedemo.com/";
	

	@BeforeTest
	public void launch1() throws Exception {
		 driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jashm\\Downloads\\AutomationTask\\Assessment\\driver\\chromedriver.exe");
		driver.get(webURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


	}
	
	
	
	
	@BeforeSuite
	public void htmlReportGenaration() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output"+"/MediBuddyAppResults"+".html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		print("Html Report Genaration Started");
	}
	
	
	@AfterMethod
	public  void listener(ITestResult result) throws Exception {
		try {
			if(result.getStatus() == ITestResult.FAILURE) {
				test.addScreenCaptureFromPath(getscreenshot(driver,"test"));
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			}else if(result.getStatus() ==ITestResult.SKIP) {
				test.addScreenCaptureFromPath(getscreenshot(driver,"test"));
				test.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable()+"Test Case Skipped", ExtentColor.ORANGE));
				
			}else if(result.getStatus() == ITestResult.SUCCESS) {
				test.addScreenCaptureFromPath(getscreenshot(driver,"test"));
				test.log(Status.PASS, MarkupHelper.createLabel(result.getInstanceName()+"Test Case Passed", ExtentColor.GREEN));


			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			print("Unable to get the Status from the Method");
		}
	}
	private String getscreenshot(WebDriver driver,String screenshotName) throws Exception {
			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot)(driver);
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir")+"/FailedScreenshot/"+screenshotName+date+".png";
			File finaldestination = new File(destination);
			FileUtils.copyFile(source, finaldestination);
		    return destination;
		
	}
	
	@AfterTest
	public  void htmlReportsClose() {
		extentReports.flush();
		print("Html Reports flushed");
	}
		
//	@SuppressWarnings("rawtypes")
//	@BeforeTest
//	public void launch() throws Exception {
////		DesiredCapabilities dc = new DesiredCapabilities();
////		dc.setCapability("deviceName", "emulator-5554");
////		dc.setCapability("platformName", "Android");
////		dc.setCapability("platformVersion", "9.0");
////		dc.setCapability("automationName", "UiAutomator2");
////		dc.setCapability("appPackage", "in.medibuddy");
////		dc.setCapability("appActivity", "in.medibuddy.ui.splash.SplashActivity");
////		//.ui.login.MBLoginActivity
////		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
////		print("Medibuddy Application Launched Successfully");
////		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
////		driver.ge
//		
//		
//	}
//	
	
//	@AfterTest
//	public static void tearDown() {
//		System.out.println("Test Run Successfully");
//	}
	
	}
	
	


