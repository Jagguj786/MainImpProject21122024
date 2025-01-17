package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTestxml extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		LaunchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider="credentials", dataProviderClass=DataProviders.class)
	//@Test
	public void loginTest(String Uname, String Pword) throws Exception {
		
		try {
		Log.startTestCase("-------loginTest----------");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(3000);
		Log.info("Enter Username and Password");
	    //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage)
		homePage=loginPage.login(Uname,Pword,homePage);
		
	    String actualURL=homePage.getCurrentURL();
	    String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
	    //Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Success");
	    Log.endTestCase("------loginTest-------");
	}
	catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
	}
		
	}

}
