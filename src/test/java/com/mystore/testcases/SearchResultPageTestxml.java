package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.package1.ChromeDriver;
import com.mystore.package1.JavascriptExecutor;
import com.mystore.package1.Webdriver;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTestxml extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addtocartpage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		LaunchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "endtoend", dataProviderClass = DataProviders.class)
	public void verifyProductSearch(HashMap<String,String> hashMapValue) {
		
		try {
		Log.startTestCase("-------verifyProductSearch--------");
		indexPage= new IndexPage();
		//searchResultPage=indexPage.searchProduct("Printed Chiffon Dress");
		searchResultPage=indexPage.searchProduct(hashMapValue.get("Product"));
		boolean result=searchResultPage.productResultDisplayed();
		Assert.assertTrue(result);
		addtocartpage=searchResultPage.clcikOnProduct();
		Log.endTestCase("-------verifyProductSearch-------");
		
		
	
		
		
		}
		catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
		
	}
}