package com.page.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utils.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class WikipediaFlow extends BaseClass {
	
	public String searchContent = "Selenium";
	
	@SuppressWarnings("rawtypes") 
	public WikipediaFlow(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "")
	public WebElement searchBar;
	
	@FindBy(xpath = "")
	public List<WebElement> searchResults;
	
	@FindBy(id = "")
	public WebElement historyHeader;
	
	@FindBy(xpath =  "")
	public WebElement historyContent;
	
	
	public void enterDataIntoSearchBar() {
		searchBar.sendKeys(searchContent);
		test.log(Status.INFO, MarkupHelper.createLabel("seach content Entered on Search Bar is :"+searchContent, ExtentColor.BLUE));
		print("seach content Entered on Search Bar is :"+searchContent);
	}
	
	public boolean verifySearchResults() {
		for (WebElement searchResult : searchResults) {
			if (!searchResult.getText().contains(searchContent))
				return false;
		}
		return true;
	}
	
	public void selectArticle() { 
		searchResults.get(0).click();
		test.log(Status.INFO, MarkupHelper.createLabel("Clicked on article", ExtentColor.BLUE));
		print("Clicked on article");
	}
	
	public boolean verifyHistoryLabelAndContent() {
		historyHeader.isDisplayed();
		test.log(Status.INFO, MarkupHelper.createLabel("History Label is Displayed", ExtentColor.BLUE));
		print("History Label is Displayed");
		if(!historyContent.getText().contains(searchContent)) {
			return false;
		}
return true;
	}

}
