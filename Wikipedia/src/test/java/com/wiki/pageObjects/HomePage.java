/**
 * 
 */
package com.wiki.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wiki.testCases.BaseClass;
import com.wiki.utilities.Log;

public class HomePage extends BaseClass {
	
	
	
	public HomePage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public static String getCurrURL() throws Throwable {
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
	}
	
	public int getTotalLinks()
	{
		
		 boolean flag = false;
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 int totalLinks=links.size();
		 Log.info("The toal links in page are"+totalLinks);
		 return totalLinks;
	}
	
	public boolean getLinksStatus()
	{
		
		 boolean flag = false;
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 int totalLinks=links.size();
		 Log.info("The toal links in page are"+totalLinks);
		 try {
			 
	    	  for (WebElement link : links) {	
	    				if(link.isEnabled() && link.isDisplayed())
					{
						flag=true;
						logger.info("Links are displayed and Enabled");
					} else {
						flag=false;
						logger.info("Linkss NOT DISPLAYED/ENABLED");	
					}
	    	  }
		 }catch (Exception e) {							
					logger.info("exeception-Links NOT DISPLAYED/ENABLED");	
					flag=false;
				}
	    	  return flag;
		 }
	

	
}
