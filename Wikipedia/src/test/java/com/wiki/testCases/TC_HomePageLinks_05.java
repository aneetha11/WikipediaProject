package com.wiki.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wiki.pageObjects.HomePage;
import com.wiki.pageObjects.IndexPage;
import com.wiki.pageObjects.LoginPg;
import com.wiki.pageObjects.SearchPage;
import com.wiki.utilities.Log;

public class TC_HomePageLinks_05 extends BaseClass {

	@Test(groups = {"Regression"})

	public void statusLinks() throws Throwable {

		LoginPg lp=new LoginPg(driver);
		IndexPage indexpage = new IndexPage(driver);
		HomePage hp=new HomePage(driver);

		indexpage.clickOnSignIn();
		lp.login(username, password);

		String actualURL=HomePage.getCurrURL();
		String expectedURL="https://en.wikipedia.org/wiki/Main_Page";

		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);

		Log.startTestCase("Hyperlinks In the Page");

		boolean status=hp.getLinksStatus();
		if(status==true){
			Assert.assertTrue(true);
			Log.info("Link is Enabled/Displayed- passed");
		}else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Log.info("Link is NOT Enabled/Displayed-failed");
		}
		
		
		lp.logOut();	
	

		Log.endTestCase("Total Links Enabled or not");
		

	}

	@Test(priority = 1)

	public void countLinks() throws Throwable {

		Log.startTestCase("TotalLinks in Page");
		HomePage hp=new HomePage(driver);
		int totLink=hp.getTotalLinks();
		if(totLink != 0){
			Assert.assertTrue(true);
			Log.info("TotalLinks are:"+totLink);
		}else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Log.info("TotalLinks Empty"+totLink);
		}

		Log.endTestCase("TotalLinks in Page");

	}

	
	
	
	
}
