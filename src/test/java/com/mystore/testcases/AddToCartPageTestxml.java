package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class AddToCartPageTestxml extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		LaunchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void addToCartTest() throws InterruptedException {
		
		try {
		Log.startTestCase("----addToCartTest-----");
		indexPage= new IndexPage();
		//searchResultPage=indexPage.searchProduct(productname);
		searchResultPage=indexPage.searchProduct("Printed Chiffon Dress");
		addToCartPage=searchResultPage.clcikOnProduct();
		addToCartPage.enterSize("M");
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCartBtn();
		Thread.sleep(3000);
		System.out.println("123222");
		boolean result=addToCartPage.verifyAfterAddtoCartclick();
		System.out.println(result);
		System.out.println("123333");
		Assert.assertTrue(result);
		System.out.println("123444");
		Thread.sleep(3000);
		//orderPage=addToCartPage.clickOnCheckOut();
//		System.out.println("123555");
//		Thread.sleep(3000);
		Log.endTestCase("-------addToCartTest-------");
		}
		
		catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	

}
