package com.mystore.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class windowSwitching extends BaseClass{
	
	
	
IndexPage indexPage;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		LaunchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifylink() throws InterruptedException {
		indexPage = new IndexPage();
		//Below verifylinkinNewTab method has the switch to Window code
		indexPage.verifylinkinNewTab();
		
		
	} 

}
