package com.wiki.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.wiki.utilities.ExtentManager;
import com.wiki.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;


	public static Logger logger;

	@Parameters("browser")
	@BeforeClass(groups = {"Smoke","Sanity","Regression"})
	//	@BeforeTest
	public void setup(String br) throws InterruptedException
	{			
		logger = Logger.getLogger("Recruitment Portal");
		PropertyConfigurator.configure("Log4j.properties");

		if(br.equals("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver =new ChromeDriver();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		//Implicit TimeOuts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//PageLoad TimeOuts
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("URL is opened");

	}

	@AfterClass(groups = {"Smoke","Sanity","Regression"})

	//	@AfterClass
	public void tearDown()
	{
		//driver.quit();
		driver.close();
	}

	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	public static String decryptPassword(String encodedBytes) {
		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		return new String(decodedBytes);
	}

	protected static String decodeString(String pass)
	{
		byte[] decodedString = Base64.decodeBase64(pass);
		//System.out.println("decodedBytes "+ new String(decodedBytes));
		return new String(decodedString);
	}


}
