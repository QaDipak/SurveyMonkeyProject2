package com.SM.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class BaseClass {

	//1. Create a public Webdriver 
		public WebDriver driver;
		public Properties prop;//We have make public so we can use in different TCs
		
		public Logger logger = LogManager.getLogger(this.getClass());
				
	//2. BeforeClass Method
	@BeforeClass
	@Parameters("browser")
	
	public void setUp(String br) throws IOException {
		prop = new Properties();//Since we have public properties we dont have to add properties before this entry.
		FileInputStream fis = new FileInputStream(".\\resources\\config.properties");//.\\ will take path automatically upto resource folder 
		prop.load(fis);
				
		if (br.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("*****Chrome browser is launched succuessfully*********");
		}else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("*****Edge browser is launched succuessfully*********");
			
		}else if (br.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("*****Firefox browser is launched succuessfully*********");
			
		}else {
			logger.info("Please use browser anyone of chrome/edge/frirefox");
		}	
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		logger.info("*****URL launched is :- " + prop.getProperty("url") + "******" );
		
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		logger.info("*****Accept all cookiees********");
	}
	
	//4. Logout from application
		@AfterClass
		public void tearDown() {
			driver.quit();
			logger.info("****Application closed successfully****");
	
		}
		
	public void capturescreen(WebDriver driver, String testname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourse = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+ testname + ".png");
		FileUtils.copyFile(sourse,target);
		logger.info("****Captured screenshots successfully******");
				
		
}
	
}
