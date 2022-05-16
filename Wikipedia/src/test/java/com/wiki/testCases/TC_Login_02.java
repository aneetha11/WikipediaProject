package com.wiki.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wiki.pageObjects.HomePage;
import com.wiki.pageObjects.IndexPage;
import com.wiki.pageObjects.LoginPg;
import com.wiki.utilities.Log;



public class TC_Login_02 extends BaseClass {

	@Test(groups = {"Smoke","Sanity"})
	public void loginTest() throws Throwable {
		LoginPg lp=new LoginPg(driver);

		IndexPage indexpage = new IndexPage(driver);
		indexpage.clickOnSignIn();

		Log.startTestCase("loginTest");

		lp.login(username, password);

		String actualURL=HomePage.getCurrURL();
		String expectedURL="https://en.wikipedia.org/wiki/Main_Page";

		Log.info("Verifying if user is able to login");
		//	Assert.assertEquals(actualURL, expectedURL);

		if(actualURL.equals("https://en.wikipedia.org/wiki/Main_Page"))
		{
			Assert.assertTrue(true);
			Log.info("LoginTest- passed");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Log.info("LoginTest-failed");
		}

		Log.endTestCase("loginTest");
	}

}