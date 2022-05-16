package com.wiki.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wiki.pageObjects.HomePage;
import com.wiki.pageObjects.IndexPage;
import com.wiki.pageObjects.LoginPg;
import com.wiki.utilities.Log;
import com.wiki.utilities.XLUtils;


public class TC_LoginDDT_03 extends BaseClass{


	@Test(groups = {"Regression"},dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws Throwable
	{
		
		LoginPg lp=new LoginPg(driver);
		IndexPage indexPage= new IndexPage(driver);
		indexPage.clickOnSignIn();
		
		Log.startTestCase("loginTest");
		lp.login(user, pwd);

		String actualURL=HomePage.getCurrURL();
		String expectedURL="https://en.wikipedia.org/wiki/Main_Page";
		
		Log.info("Verifying if user is able to login");
		if(actualURL.equals("https://en.wikipedia.org/wiki/Main_Page"))
		{
			Assert.assertTrue(true);
			Log.info("LoginTest- passed");
			lp.logOut();
			Log.info("Logot of application");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Log.info("LoginTest-failed");
		}
	
		Log.endTestCase("loginTest");
	}




	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		//String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		String path=System.getProperty("user.dir")+"/src/test/java/com/recruitment/testData/TestData.xlsx";

		int rownum=XLUtils.getRowCount(path, "LoginSheet");
		int colcount=XLUtils.getCellCount(path,"LoginSheet",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"LoginSheet", i,j);//1 0
			}

		}
		return logindata;
	}

}

