package com.mystore.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJenkinsfromLocal extends BaseClass{
	
	IndexPage indexPage;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		LaunchApp(); 
	}
	
	
//	//@Parameters("browser")
//	@BeforeMethod
//	public void setup() throws InterruptedException {
//		
//		LaunchApp(); 
//		
//	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
    @Test
    public void jenkinsclassTest() {
    	indexPage = new IndexPage();
    	boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
    }
}
