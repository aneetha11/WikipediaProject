package com.wiki.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wiki.reuseableMethods.ClickClass;
import com.wiki.reuseableMethods.SendKeysClass;
import com.wiki.testCases.BaseClass;
import com.wiki.utilities.Log;

public class LoginPg extends BaseClass{

	WebDriver ldriver;

	public LoginPg(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(id="wpName1")
	private WebElement userName;

	@FindBy(id="wpPassword1")
	private WebElement password;

	@FindBy(id="wpLoginAttempt")
	private WebElement logInBtn;

	@FindBy(xpath ="//span[text()='Log out']")
	private WebElement logoutBtn;

	public void login(String uname, String pwd) throws IOException  {

		SendKeysClass.sendKeysMethod(userName, uname, "userName");
		SendKeysClass.sendKeysMethod(password, pwd, "password");
		ClickClass.clickButton(logInBtn, "logInBtn");

	}

	public void logOut() throws IOException
	{
		//logoutBtn.click();

		ClickClass.clickButton(logoutBtn, "logoutBtn");
		Log.info("Clicked on LogOut");
	}	


}
