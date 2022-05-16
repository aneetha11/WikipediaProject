package com.wiki.pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.wiki.reuseableMethods.ClickClass;
import com.wiki.reuseableMethods.ImplicitwaitMeth;
import com.wiki.testCases.BaseClass;
import com.wiki.utilities.Log;


public class IndexPage extends BaseClass {

	WebDriver ldriver;

	public IndexPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@class='mw-wiki-logo']")
	WebElement wikipediaLogo;	

	@FindBy(xpath = "//span[text()='Log in']")
	public static WebElement signInBtn;

	public String getMyStoreTitle() {
		String myStoreTitel=driver.getTitle();
		return myStoreTitel;
	}

	public boolean validateLogo() throws Throwable {

		boolean flag = false;

		flag = wikipediaLogo.isDisplayed();
		System.out.println("element status:"+flag);
		if (flag) {
			Log.info("The element is Displayed");
		} else {
			Log.info("The element is NOT Displayed");
		}
		return flag;
	}

	public  void clickOnSignIn() throws IOException, InterruptedException{
		ImplicitwaitMeth.implicitWait();
		ClickClass.clickButton(signInBtn, "signInBtn");
	}
}









