package com.OnlinePurchaseWebFlow.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.forms.OnlinePurchaseWebApplicationFlowForm;
import com.utils.BaseClass;
import com.utils.DataDriven;

public class OnlinePurchaseWebFlowTests extends BaseClass {
	

	@Test(dataProvider = "data_login" )
	public  void onlineWebAppPurchaseFlow(HashMap<String, String> hash) throws Exception {
		test = extentReports.createTest("Online Web Application Purchase Flow");
		OnlinePurchaseWebApplicationFlowForm onlinePurchaseWebFlow = new OnlinePurchaseWebApplicationFlowForm(driver);
		onlinePurchaseWebFlow.login(hash.get("userName"), hash.get("password"));
		onlinePurchaseWebFlow.clickOnLoginButton();
		onlinePurchaseWebFlow.addFourProductsToCart();
		onlinePurchaseWebFlow.clickOnShoppingCartLink();
		onlinePurchaseWebFlow.verifySubTotalInAddToCartPage();
		onlinePurchaseWebFlow.clickOnCheckOutButton();
		onlinePurchaseWebFlow.enterShippingDetails(hash.get("firstName"), hash.get("lastName"), hash.get("postalCode"));
		onlinePurchaseWebFlow.clickOnContinueButton();
		onlinePurchaseWebFlow.printItemPricesDetails();
		onlinePurchaseWebFlow.clickOnFinishButton();
		onlinePurchaseWebFlow.successMsg();
	}

	@DataProvider
	public  Object[][] data_login() throws Exception {
		return DataDriven.getData("C:\\Users\\jashm\\Downloads\\AutomationTask\\Assessment\\OnlineWebPurchaseFlow.xlsx", "WebPurchaseFlow");
	}

}

