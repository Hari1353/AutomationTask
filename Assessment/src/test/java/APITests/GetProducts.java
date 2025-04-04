package APITests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.utils.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetProducts extends BaseClass {
	@Test
	public void testProductsApiFlow() {
		 //base URI with Rest Assured class
	      RestAssured.baseURI = "https://dummyjson.com";

	      //obtain Response from GET request
	      Response res = RestAssured.given()
	         .when()
	         .get("/products");

	      //convert JSON to string
	      JsonPath j = new JsonPath(res.asString());

	      //get values of JSON array after getting array size
	      int s = j.getInt("products.size()");
	      for(int i = 0; i < s; i++) {
	         String category = j.getString("products["+i+"].category");
	         System.out.println(category);
	         assertTrue(!category.equals(null), "Category Should not contains null");
	         if (category.equals("groceries")) {
	        	 System.out.println("products["+i+"].title");
	         }
	         if (category.equals("groceries")) {
	        	 double priceValue = Double.parseDouble("products["+i+"].price");
	        	 if(priceValue < 5.0) {
	        		 assertFalse(false, "failed as it has lower than expected price");
	        	 	 System.out.println("products["+i+"].title");
	        	 }
	         }
	         int count = 0;
	         for(int k = 0; k < s; k++) {
		         String category1 = j.getString("products["+k+"].category");
		         System.out.println(category);
		         if (category.equals("beauty")) {
		        	 System.out.println("products["+i+"].title");
		        	 count++;
		        	 if (count > 2) {
		              break;
		        	 }
		         }
		         if (category.equals("beauty")) {
		        	 double priceValue = Double.parseDouble("products["+k+"].price");
		        	 if(priceValue < 5.0 || priceValue > 14) {
		        		 assertFalse(false, "failed as it has lower than expected price");
		        	 	 System.out.println("products["+i+"].title");
		        	 }
		         }
		         }
	         int count1 = 0;
	         for(int l= 0; l < s; l++) {
	     
		         double totalPrice = Double.parseDouble("products["+l+"].price");
		         System.out.println("Total Price is :"+totalPrice);
		        	 }
	         List<Double> list = new ArrayList<Double>();
	         for(int m= 0; m < s; m++) {
		         double priceVal = Double.parseDouble("products["+m+"].price");
		         count1++;
		         list.add(priceVal);
		         if (count > 6)
		        break;
		        	 }
	         Double averagePrice = 0.0;
	         for (Double price : list) {
	        	 averagePrice = averagePrice + price;
	         }
	         
	         System.out.println("Average Price of 6 products is :"+averagePrice/6);
	         List<Double> beautyPrice = new ArrayList<Double>();
	         double priceValue = 0.0;
	         for(int n = 0; n < s; n++) {
		         String category1 = j.getString("products["+n+"].category");
		         System.out.println(category);
		         if (category.equals("beauty")) {
		        	 priceValue = Double.parseDouble("products["+n+"].price");
		        	 beautyPrice.add(priceValue);
		         }
		        	
		         }
	         double beautyPriceValue = 0.0;
	         for (Double value : beautyPrice) {
	        	 beautyPriceValue = beautyPriceValue + value;
	         }
	         
	         System.out.println("Average of Beauty Category Price Values are :"+beautyPriceValue/beautyPrice.size());
	         
	         List<Double> groceriesPrice = new ArrayList<Double>();

	         double groceriespriceValue = 0.0;
	         for(int O = 0; O < s; O++) {
		         String category1 = j.getString("products["+O+"].category");
		         System.out.println(category);
		         if (category.equals("groceries")) {
		        	 priceValue = Double.parseDouble("products["+O+"].price");
		        	 groceriesPrice.add(priceValue);
		         }
		        	
		         }
	         for (Double value : groceriesPrice) {
	        	 groceriespriceValue = groceriespriceValue + value;
	         }
	         
	         System.out.println("Average of groceries Category Price Values are :"+groceriespriceValue/groceriesPrice.size());
	         
	       
	}
	      
	}

}
