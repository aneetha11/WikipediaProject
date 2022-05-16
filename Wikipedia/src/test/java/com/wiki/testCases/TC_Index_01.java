package com.wiki.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wiki.pageObjects.IndexPage;
import com.wiki.utilities.Log;
public class TC_Index_01 extends BaseClass
{
	IndexPage indexpage;
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		indexpage= new IndexPage(driver);
		boolean result=indexpage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle=indexpage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "Wikipedia, the free encyclopedia");
		Log.endTestCase("verifyTitle");
	}
	
}