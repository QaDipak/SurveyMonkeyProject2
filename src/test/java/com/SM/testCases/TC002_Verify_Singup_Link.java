package com.SM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SM.testBase.BaseClass;

import come.SM.pageObject.LoginPage;

public class TC002_Verify_Singup_Link extends BaseClass {
	
	public String expVal = "Dashboard";//User in assert method

	//3.Check Sing up link
	@Test
	public void verifySignUpLinkExistTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		//lp.checkSignUpLink();//This will return boolean val..so we can store in variable and verify but below is other way we can verify	
		Assert.assertTrue(lp.checkSignUpLink(),"Sign Up is link missing");
		logger.info("*****Sing Up link launch successfully******");
	
		capturescreen(driver,"3. SingUp Link Exist");
		
	}

		
}

