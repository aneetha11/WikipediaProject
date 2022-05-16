package com.wiki.reuseableMethods;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.wiki.testCases.BaseClass;
import com.wiki.utilities.Log;

public class SendKeysClass extends BaseClass{
	
	public static void sendKeysMethod(WebElement Element,String txtFieldValue,String methodName) throws IOException {
	
		try {
			if (Element.isDisplayed() && Element.isEnabled()) {
				
				Element.clear();
				Element.sendKeys(txtFieldValue);
				Log.info("Entered text:"+methodName);
			
			}
		} catch (Exception e) {
						
			captureScreen(driver,methodName);
			Log.info("Unable to enter text:"+methodName);
	
			
		}
	}
		
}
