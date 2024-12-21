package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SFAccountPage extends BaseClass{
	//@FindBy(xpath="//input[@value=\" New \"]") private WebElement newBtn;
	//div[@title="New"]
	//@FindBy(xpath = "//li[@id=\"Account_Tab\"]//following::a[1]")private WebElement aacountTabBtn;
	@FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[3]/a/span")private WebElement aacountTabBtn;
	@FindBy(xpath="//div[@title=\"New\"]") private WebElement newBtn;
	@FindBy(xpath = "//p[text()='Welcome to your account. Here you can manage all of your personal information and orders.']")private WebElement ele;
	@FindBy(xpath="//*[contains(text(),\"Your account has been created\")]") private WebElement accCreationMsg;
	@FindBy(id="search_query_top") WebElement searchProductBox;
	@FindBy(xpath="//input[@name=\"Name\"]") WebElement AccName;
	@FindBy(xpath="//label[text()=\"Rating\"]//following::button[1]") WebElement Rating;
	@FindBy(xpath="//label[text()=\"Type\"]//following::button[1]") WebElement Type;
	@FindBy(xpath="//label[text()=\"Industry\"]//following::button[1]") WebElement Industry;
	@FindBy(xpath="//button[text()=\"Save\"]") WebElement Save;
	@FindBy(xpath="//*[text()=\"Hot\"]") WebElement Hot;
	@FindBy(xpath="(//span[text()=\"Prospect\"])[1]") WebElement Prospect;
	@FindBy(xpath="(//span[text()=\"Banking\"])[1]") WebElement Banking;
	@FindBy(xpath="//a[text()=\"Details\"]") WebElement Detail;
	@FindBy(xpath="//button[@name=\"NewCase\"]") WebElement NewrelatedCase;
	@FindBy(xpath="//label[text()=\"Case Origin\"]//following::button[1]") WebElement CaseOrigin;
	@FindBy(xpath="(//span[text()=\"Web\"])[1]") WebElement Web;
	
	//label[text()="Case Origin"]//following::button[1]
	//button[@name="NewCase"]
	//button[text()="Save"]
	////*[text()="Hot"]
	//a[text()="Details"]
	public SFAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void AccCreationwithrelatedCase() throws InterruptedException {
		
		
		try {
		Action.click(driver, aacountTabBtn);
		Action.click(driver, newBtn);
		Action.type(AccName, "TestNa58634");
		
		//Dropdown for selecting rating
		Action.click(driver, Rating);
		Action.click(driver, Hot);
		Thread.sleep(3000);
		
		
		//DropDown
		Action.click(driver, Type);
		Action.click(driver, Prospect);
		Thread.sleep(3000);
		
		//DropDown
		Action.click(driver, Industry);
		Action.click(driver, Banking);
		Thread.sleep(3000);
		
		
		
		
//		Select dropdown = new Select(Rating);
//		dropdown.selectByVisibleText("Hot");
//		Thread.sleep(5000);
//		
//		//Dropdown for selecting rating
//		Select dropdown1 = new Select(Type);
//		dropdown1.selectByVisibleText("Prospect");
//		Thread.sleep(5000);
//		
//		//Dropdown for selecting rating
//		Select dropdown2 = new Select(Industry);
//		dropdown2.selectByVisibleText("Banking");
//		Thread.sleep(5000);
		
		Action.click(driver, Save);
		Thread.sleep(7000);
		
//		Action.click(driver, Detail);
//		Thread.sleep(7000);
//		
//		Action.click(driver, Related);
		
		
		Action.click(driver, NewrelatedCase);
		Thread.sleep(7000);
		Action.click(driver, CaseOrigin);
		Action.click(driver, Web);
		
		Thread.sleep(7000);
		Action.click(driver, Save);
		Thread.sleep(7000);
		
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
