package com.wiki.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wiki.pageObjects.IndexPage;
import com.wiki.pageObjects.LoginPg;
import com.wiki.pageObjects.SearchPage;
import com.wiki.utilities.Log;
import com.wiki.utilities.XLUtils;

public class TC_SearchBox_04 extends BaseClass {

	@Test(groups = {"Regression","Smoke"}, dataProvider="SearchData" )
	public void search(String searchVal) throws Throwable {
		
		Log.startTestCase("SearchBox");
		SearchPage sp=new SearchPage(driver);
		sp.txtSearchBox(searchVal);
	
		String actualURL= sp.validateSearchBox();
			
		if(actualURL.contains(searchVal))
		{
			Assert.assertTrue(true);
			Log.info("SearchTest- passed");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Log.info("SearchTest-failed");
		}
		
		
		
		Log.endTestCase("SearchBox");
	}

@DataProvider(name="SearchData")
String [][] getData() throws IOException
{
	//String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
	String path=System.getProperty("user.dir")+"/src/test/java/com/recruitment/testData/TestData.xlsx";

	int rownum=XLUtils.getRowCount(path, "Search");
	int colcount=XLUtils.getCellCount(path,"Search",1);

	String searchdata[][]=new String[rownum][colcount];

	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			searchdata[i-1][j]=XLUtils.getCellData(path,"Search", i,j);//1 0
		}

	}
	return searchdata;
}

}

