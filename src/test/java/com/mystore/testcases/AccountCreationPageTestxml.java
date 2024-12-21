package com.mystore.testcases;


	import java.util.HashMap;

import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
	import com.mystore.pageobjects.HomePage;
	import com.mystore.pageobjects.IndexPage;
	import com.mystore.pageobjects.LoginPage;
	import com.mystore.utility.Log;


	public class AccountCreationPageTestxml extends BaseClass{
		
		IndexPage indexPage;
		LoginPage loginPage;
		HomePage homePage;
		AccountCreationPage accountCreationPage;
		
		
		
		@Parameters("browser")
		@BeforeMethod
		public void setup(String browser) throws InterruptedException {
			LaunchApp(); 
			//LaunchApp(browser); 
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		@Test(dataProvider = "newAcountDetailsData", dataProviderClass = DataProviders.class)
		public void verifyAccountCreationLandingPage(HashMap<String,String> hashMapValue) throws Throwable {
			
			try {
			
			Log.startTestCase("-----verifyAccountCreationLandingPage-----");
			indexPage= new IndexPage();
			Log.info("user is going to click on SignIn");
			loginPage=indexPage.clickOnSignIn();
			Thread.sleep(3000);
			
			accountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
			//accountCreationPage=loginPage.createNewAccount("tesyyuy4763@gmail.com");
			
			boolean result=accountCreationPage.validateAccountCreationpage();
			Assert.assertTrue(result);
			
			//accountCreationPage.createAccount("Mr", "Testuy", "SalesererhrUY", "Testing*12345", "7", "5", "1995");
			accountCreationPage.createAccount(
					hashMapValue.get("Gender"),
					hashMapValue.get("FirstName"),
					hashMapValue.get("LastName"),
					hashMapValue.get("SetPassword"),
					hashMapValue.get("Day"),
					hashMapValue.get("Month"),
					hashMapValue.get("Year"));
			
		    homePage = accountCreationPage.validateRegistration();
		    Thread.sleep(3000);
		    boolean result2= homePage.ValidateHomePageAfterLogin();
		    
		    Assert.assertTrue(result2);
		    
		    boolean result3=homePage.accountCreationSuccessfully();
		    Assert.assertTrue(result3);
		    Log.endTestCase("-----verifyAccountCreationLandingPage-----");
		    
			}
			
			catch (Exception e) {
	            System.out.println("An unexpected error occurred: " + e.getMessage());
			}
		}
		
//		@Test
//		public void verifyErrorMsgIfgivingexisingemail() throws Throwable {
//			
//			try {
//			Log.startTestCase("-----verifyErrorMsgIfgivingexisingemail----");
//			System.out.println("AC1----");
//			indexPage= new IndexPage();
//			Log.info("user is going to click on SignIn");
//			loginPage=indexPage.clickOnSignIn();
//			
//			Thread.sleep(3000);
//			loginPage.errorMsgVerify();
//			Log.endTestCase("-----verifyErrorMsgIfgivingexisingemail----");
//			}
//			
//			catch (Exception e) {
//	            System.out.println("An unexpected error occurred: " + e.getMessage());
//			}
//		
//		}	
//		
//		 @Test  
//		public void verifyErrorMsgwhenemailnotgiven() throws Throwable {
//			
//			try {
//			Log.startTestCase("-----verifyErrorMsgwhenemailnotgiven----");
//			System.out.println("AC2----");
//			indexPage= new IndexPage();
//			Log.info("user is going to click on SignIn");
//			loginPage=indexPage.clickOnSignIn();
//			
//			Thread.sleep(3000);
//			loginPage.verifyerrormsgIfNoMailisgiven();
//			Log.endTestCase("-----verifyErrorMsgwhenemailnotgiven-----");
//			}
//			catch (Exception e) {
//	            System.out.println("An unexpected error occurred: " + e.getMessage());
//			}
//		
//		}

		 
//		 @Test(enabled = false)  // This test will be skipped
//			public void verifyError1() throws Throwable {
//				
//				try {
//				Log.startTestCase("-----verifyErrorMsgwhenemailnotgiven----");
//				indexPage= new IndexPage();
//				Log.info("user is going to click on SignIn");
//				loginPage=indexPage.clickOnSignIn();
//				
//				Thread.sleep(3000);
//				loginPage.verifyerrormsgIfNoMailisgiven();
//				Log.endTestCase("-----verifyErrorMsgwhenemailnotgiven-----");
//				}
//				catch (Exception e) {
//		            System.out.println("An unexpected error occurred: " + e.getMessage());
//				}
//			
//			}
//		 
//		 
//		 @Test(enabled = true)  // This test will be skipped
//			public void verifyError2() throws Throwable {
//				
//				try {
//				Log.startTestCase("-----verifyErrorMsgwhenemailnotgiven----");
//				indexPage= new IndexPage();
//				Log.info("user is going to click on SignIn");
//				loginPage=indexPage.clickOnSignIn();
//				
//				Thread.sleep(3000);
//				loginPage.verifyerrormsgIfNoMailisgiven();
//				Log.endTestCase("-----verifyErrorMsgwhenemailnotgiven-----");
//				}
//				catch (Exception e) {
//		            System.out.println("An unexpected error occurred: " + e.getMessage());
//				}
//			
//			}
//		 
//		 
//		 @Test(enabled = true)  // This test will be skipped
//			public void verifyError3() throws Throwable {
//				
//				try {
//				Log.startTestCase("-----verifyErrorMsgwhenemailnotgiven----");
//				indexPage= new IndexPage();
//				Log.info("user is going to click on SignIn");
//				loginPage=indexPage.clickOnSignIn();
//				
//				Thread.sleep(3000);
//				loginPage.verifyerrormsgIfNoMailisgiven();
//				Log.endTestCase("-----verifyErrorMsgwhenemailnotgiven-----");
//				}
//				catch (Exception e) {
//		            System.out.println("An unexpected error occurred: " + e.getMessage());
//				}
//			
//			}
		
	}
