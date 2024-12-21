package com.mystore.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;
import com.mystore.utility.NewExcelLibrary;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class endToEndTestxml extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	PaymentPage paymentPage;
	ShippingPage shippingPage;
	AddressPage addressPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	public static ExtentTest test;
	public static ExtentReports extent;
	
	NewExcelLibrary excel = new NewExcelLibrary();
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		//test = extent.createTest("endToEndTest", "Description of the test");
		LaunchApp(); 
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "endtoend", dataProviderClass = DataProviders.class)
	public void endToEndTest(HashMap<String,String> hashMapValue) throws Exception {
		
		
		try {
		Log.startTestCase("------endToEndTest------");
		System.out.println("EE1------");
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
		//Log.info("Logged in Succesfully");
		homePage=loginPage.login(hashMapValue.get("Username"), hashMapValue.get("Password"),homePage);
	    homePage.ValidateHomePageAfterLogin();
	    Log.info("Logged in Succesfully");
	    //searchResultPage=homePage.searchProduct("Printed Chiffon Dress");
	    searchResultPage=homePage.searchProduct(hashMapValue.get("Product"));
	    addToCartPage=searchResultPage.clcikOnProduct();
	    Thread.sleep(3000);
//	    addToCartPage.enterSize("M");
//	    addToCartPage.enterQuantity("2");
	    addToCartPage.enterSize(hashMapValue.get("Size"));
	    addToCartPage.enterQuantity(hashMapValue.get("qty"));
	    addToCartPage.clickOnAddToCartBtn();
	    orderPage=addToCartPage.clickOntheCheckOut();
	    addressPage=orderPage.clickOnCheckOut1();
	    shippingPage=addressPage.clickOnChectOut();
	    shippingPage.clickonTerms();
	    paymentPage=shippingPage.clcikOnProceedToCheckoutBtn();
	    orderSummaryPage=paymentPage.clickOnPaymentMethod();
	    orderConfirmationPage=orderSummaryPage.clickOnConfirmOrderBtn();
	    String msg=orderConfirmationPage.getConfirmMessage();
	    System.out.println(msg);
	    orderConfirmationPage.validateConfirmMsg();
	    Thread.sleep(3000);
	    
	    
	    
	    //To write data in a excel
	    excel.setCellData("DataFromWeb", "ARN", 2, msg);
	    Log.info("Saved on excel successfully");
	    
	    Log.endTestCase("------endToEndTest------");
		}
		catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	@Test
	public void newTest1() {
		
		Log.startTestCase("------Startparalleltest------");
		System.out.println("EE2------");
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		System.out.println("parallel Test");
		Log.endTestCase("-----EndparallelTest------");
		
	}
	
	
	
}