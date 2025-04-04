package MobileAppWikipediaFlow;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.forms.WikipediaFlow;
//import com.page.forms.Createaccountpage_termsandconditionsform;
//import com.page.forms.LoginForm;
import com.utils.BaseClass;
import com.utils.DataDriven;

import io.appium.java_client.android.AndroidDriver;

public class WikipediaFlowAutomationTest extends BaseClass {
	
	@BeforeTest()
	public void mobileAppLaunch() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "");
		dc.setCapability("deviceVersion", "");
		dc.setCapability("platformName", "");
		dc.setCapability("platformVersion", "");
		dc.setCapability("appPackage", "");
		dc.setCapability("appActivity", "");
		androidDriver = new AndroidDriver<>(new URL("0.0.0.0:4723/wd/hub"), dc);
	}
	
	@Test()

	public void login(HashMap<String, String> hash) throws Exception {
		test = extentReports.createTest("Wikipedia Flow Automation Test");
		WikipediaFlow wikipedia = new WikipediaFlow((AndroidDriver) driver);
		wikipedia.enterDataIntoSearchBar();
		wikipedia.verifySearchResults();
		wikipedia.selectArticle();
		wikipedia.verifyHistoryLabelAndContent();

	}


}
