package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.SFHomePage;
import com.mystore.pageobjects.SFLoginPage;

public class SFHomePageTest extends BaseClass{

	SFLoginPage sfloginpage;
	SFHomePage sfhomepage;
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		LaunchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void homePageTest() throws InterruptedException {
		
		sfloginpage = new SFLoginPage();
		sfhomepage=sfloginpage.LoginSFMoveHomePage();
		sfhomepage.verifyHomePage();
		sfhomepage.AppLauncherClickMoveToServiceApp();
		
	}
}
