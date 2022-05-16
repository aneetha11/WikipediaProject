package com.wiki.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wiki.reuseableMethods.ClickClass;
import com.wiki.reuseableMethods.SendKeysClass;
import com.wiki.testCases.BaseClass;

public class SearchPage extends BaseClass {

	WebDriver ldriver;

	public SearchPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id='searchInput']")
	WebElement txtSearchBox;	

	@FindBy(xpath = "//input[@id='searchButton']")
	public static WebElement searchBtn;
	
	@FindBy(xpath = "//h1[@id='firstHeading']")
	public static WebElement validationTxt;
	

	public void txtSearchBox(String searchVal) throws IOException {
		txtSearchBox.clear();
		SendKeysClass.sendKeysMethod(txtSearchBox, searchVal, "txtSearchBox");
		ClickClass.clickButton(searchBtn, "searchBtn");
	}

public String validateSearchBox() {
	String actVal=validationTxt.getText();
	driver.navigate().back();
	return actVal;
}
}
