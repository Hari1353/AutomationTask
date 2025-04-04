package com.page.forms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utils.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class OnlinePurchaseWebApplicationFlowForm extends BaseClass {
	
	@SuppressWarnings("rawtypes") 
	public OnlinePurchaseWebApplicationFlowForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 double cartItemPricesGrandTotal = 0.00;
 
	@FindBy(id = "user-name")
	public WebElement userNameField;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(id = "login-button")
	public WebElement loginButton;

	@FindBy(xpath = "//*[text()='Add to cart']")
	public List<WebElement> addToCartButton;

	@FindBy(linkText = "shopping_cart_link")
	public WebElement shoppingCartLink;

	@FindBy(className = "inventory_item_price")
	public List<WebElement> itemPrices;

	@FindBy(id = "checkout")
	public WebElement checkoutButton;

	@FindBy(id = "first-name")
	public WebElement firstNameField;

	@FindBy(id = "last-name")
	public WebElement lastNameField;

	@FindBy(id = "postal-code")
	public WebElement postalCodeField;

	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(className = "summary_subtotal_label")
	public WebElement itemTotal;

	@FindBy(className = "summary_tax_label")
	public WebElement itemTaxTotal;

	@FindBy(className = "summary_total_label")
	public WebElement totalAmount;

	@FindBy(id = "finish")
	public WebElement finishButton;

	@FindBy(className = "complete-headerl")
	public WebElement successMsgHeader;

	@FindBy(className = "complete-text")
	public WebElement successMsg;
	
	public  void login(String userName, String password) {
		try {
			userNameField.sendKeys(userName);
			test.log(Status.INFO, MarkupHelper.createLabel("userName Entered on Text Box is :"+userName, ExtentColor.BLUE));
			print("userName Entered on Text Box is :"+userName);
			passwordField.sendKeys(password);
			test.log(Status.INFO, MarkupHelper.createLabel("password Entered on Text Box is :"+password, ExtentColor.BLUE));
			print("password Entered on Text Box is :"+password);
            loginButton.click();
			test.log(Status.INFO, MarkupHelper.createLabel("Clicked on login button", ExtentColor.BLUE));
			print("Clicked on login button");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			print("Unble to Valid the Test Case Valiting the Login with Invalid OTP");
		}

	}

	public void clickOnLoginButton() {
		loginButton.click();
		test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Login Button", ExtentColor.BLUE));
	}

	public void addFourProductsToCart() {
		for(WebElement addToCart: addToCartButton) {
              addToCart.click();
		}
		test.log(Status.INFO, MarkupHelper.createLabel("Four Products added to Cart", ExtentColor.BLUE));
			print("Four Products added to Cart");
	}

    public void clickOnShoppingCartLink() {
    shoppingCartLink.click();
	test.log(Status.INFO, MarkupHelper.createLabel("Clicked on shoppingCartLink", ExtentColor.BLUE));
    }
	public void verifySubTotalInAddToCartPage() {

	List<Integer> cartItemPricesTotal = new ArrayList<Integer>();

		for (WebElement itemPrice : itemPrices) {
			cartItemPricesTotal.add(Integer.parseInt(itemPrice.getText().replace("$","")));
		}

		for (int i = 0; i < cartItemPricesTotal.size(); i++) {
cartItemPricesGrandTotal = cartItemPricesGrandTotal + cartItemPricesTotal.get(i);
		}
		test.log(Status.INFO, MarkupHelper.createLabel("Added Cart Item Prices Gran Total is :"+cartItemPricesGrandTotal, ExtentColor.BLUE));

	}
	
    public void clickOnCheckOutButton() {
    checkoutButton.click();
	test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Check Out Button", ExtentColor.BLUE));
    }
	
	public void enterShippingDetails(String firstName, String lastName, String postalCode) {
		firstNameField.sendKeys(firstName);
		test.log(Status.INFO, MarkupHelper.createLabel("First Name Entered in Shipping Details Page :"+firstName, ExtentColor.BLUE));
		lastNameField.sendKeys(lastName);
		test.log(Status.INFO, MarkupHelper.createLabel("Last Name Entered in Shipping Details Page :"+lastName, ExtentColor.BLUE));
		postalCodeField.sendKeys(postalCode);
		test.log(Status.INFO, MarkupHelper.createLabel("Postal Code Entered in Shipping Details Page :"+postalCode, ExtentColor.BLUE));
	}

	public void clickOnContinueButton() {
		continueButton.click();
		test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Continue Button", ExtentColor.BLUE));
	}

	public void printItemPricesDetails() {
		System.out.println("Item Total Amount is :"+itemTotal.getText());
		test.log(Status.INFO, MarkupHelper.createLabel("Item Total Amount is :"+itemTotal.getText(), ExtentColor.BLUE));
		System.out.println("Item Tax Total Amount is :"+itemTaxTotal.getText());
		test.log(Status.INFO, MarkupHelper.createLabel("Item Tax Total Amount is :"+itemTaxTotal.getText(), ExtentColor.BLUE));
		System.out.println("Item Grand Total Amount is :"+totalAmount.getText());
		test.log(Status.INFO, MarkupHelper.createLabel("Item Grand Total Amount is :"+totalAmount.getText(), ExtentColor.BLUE));
	}

	public void clickOnFinishButton() {
		finishButton.click();
		test.log(Status.INFO, MarkupHelper.createLabel("Clicked on Finish Button", ExtentColor.BLUE));
	}

	public void successMsg() {
		String successMsgHeaderContent = successMsgHeader.getText();
		String completeMsg = successMsg.getText();
	}
	
	}
	
	


