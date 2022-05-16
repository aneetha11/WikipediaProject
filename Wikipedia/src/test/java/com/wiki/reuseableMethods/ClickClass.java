package com.wiki.reuseableMethods;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.wiki.testCases.BaseClass;
import com.wiki.utilities.Log;

public class ClickClass extends BaseClass{

	public static void clickButton(WebElement element,String methodName) throws IOException {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
		
				element.click();
				Log.info("Able to click:"+methodName);
				
			}
		} catch (Exception e) {
			captureScreen(driver,methodName);
			Log.info("Not Able to click:"+methodName);
			//Assert.assertTrue(false);

		}

	}



}
