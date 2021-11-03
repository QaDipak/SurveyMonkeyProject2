package com.SM.testCases;
//Create Test cases class without public static void selected as we are useing testNG concept. 

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SM.testBase.BaseClass;

import come.SM.pageObject.DashboardPage;
import come.SM.pageObject.LoginPage;

public class TC003_CheckingApplicationTitle extends BaseClass {
	
	
	public String expVal = "Dashboard";//User in assert method
	
		
	//3.Test Case to login
	@Test
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		
		//Calling all the method from LoginPage.java
		lp.setUsername(prop.getProperty("username"));
		logger.info("*****Username entered is :- " + prop.getProperty("username") + "********");
		lp.setPassword(prop.getProperty("password"));
		logger.info("*****Password entered is :- " + prop.getProperty("password") + "*******");
		
		capturescreen(driver,"1. LoginPage Before Login");
		
		boolean val1 = lp.checkOfficeLink();
		System.out.println(val1);
		
		lp.clickLoginbutton();
		logger.info("*****Clicked on Login Button*******");
		
		capturescreen(driver,"2. LoginPage After Login");
				
		//Get the linkname and verify it
		DashboardPage dp = new DashboardPage(driver);
		String retval = dp.getDashboardLnkTxt();
		System.out.println("Value Return from the method is :- " + retval);//This will print "Dashboard"
		//Now,we can validate through assert method
		Assert.assertEquals(retval, expVal, "User didnt logged in successfully");
		logger.info("*****************User logged in successfully****************");
			
		
	}
	
		
}
