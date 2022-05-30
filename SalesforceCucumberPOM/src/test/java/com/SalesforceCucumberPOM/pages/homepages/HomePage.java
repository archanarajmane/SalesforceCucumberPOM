package com.SalesforceCucumberPOM.pages.homepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesforceCucumberPOM.base.SFCucumberbasePagePOM;

public class HomePage extends SFCucumberbasePagePOM {
WebDriver driver;
		public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public String GetTextFromSalesforceHomePageTitle()
	{
		String text=getTitleOfThePage();
		System.out.println("this is a textt "+text);
		return text;
	}
	
}


