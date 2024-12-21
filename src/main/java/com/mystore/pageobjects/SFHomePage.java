package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SFHomePage extends BaseClass{
	
	
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@placeholder=\"Search apps and items...\"]") private WebElement appSearchinput;
	@FindBy(xpath = "//div[@class=\"slds-icon-waffle\"]")private WebElement appLauncher;
	@FindBy(xpath = "//h1//span[contains(text(),\"Home\")]")private WebElement verifyHomeText;
	@FindBy(xpath = "(//h2[contains(text(),\"App Launcher\")]//following::b[contains(text(),\"Service\")])[1]")private WebElement ServiceApp;
	@FindBy(xpath = "//h1//span[contains(text(),\"Service\")]")private WebElement ServiceAppClickverify;
	@FindBy(xpath = "(//a[text()=\"Switch to Lightning Experience\"])[1]")private WebElement switchToLitening;
	
	public SFHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void verifyHomePage() {
		
		try {
		
		String url = driver.getCurrentUrl();
		String text = "home";
		System.out.println(url);
		Boolean Res = url.contains(text);
		System.out.println(Res);
		
		if(Res) {
			System.out.println("able to see home on URL & logged in Successfully.");
		}
		else {
			System.out.println("Login failed");
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
  }
	
	
	public void AppLauncherClickMoveToServiceApp() throws InterruptedException {
		
		Action.click(driver, appLauncher);
		Action.type(appSearchinput, "Service");
		Action.click(driver, ServiceApp);
		Thread.sleep(7000);
		Action.isDisplayed(driver, ServiceAppClickverify);
		Thread.sleep(2000);
		
	}

   public SFAccountPage AppLauncherClickMoveToServiceAppMovetoAccountPage() throws InterruptedException {
		
		Action.click(driver, appLauncher);
		Action.type(appSearchinput, "Service");
		Action.click(driver, ServiceApp);
		Thread.sleep(7000);
		Action.isDisplayed(driver, ServiceAppClickverify);
		Thread.sleep(2000);
		return new SFAccountPage();
		
		
	}
		
	public void SwitchToLigteningfromClassic() throws InterruptedException {
		
		
	try {
			
		Boolean result;
		
		result = Action.isDisplayed(driver, switchToLitening);
		
		if(result) {
			Action.click(driver, switchToLitening);
			Thread.sleep(5000);
		}
		
		else {
			
			System.out.println("Already in Ligtening");
			
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
