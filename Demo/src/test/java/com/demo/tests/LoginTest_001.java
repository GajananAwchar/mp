package com.demo.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;

import com.demo.libs.FlowLibs;
import com.demo.pages.LoginPage;

public class LoginTest_001 extends BaseClass {
	@Test 
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.launchURL();
		//driver.get(base_URL);
		Thread.sleep(2000);
		logger.info("URL is opened");
		lp.setUsername(username);
		Thread.sleep(4000);
		logger.info("entered username");
		Thread.sleep(4000);
		lp.setPassword(password);
		Thread.sleep(2000);
		logger.info("entered password");
		lp.clickSubmit();
		Thread.sleep(2000);
		logger.info("clicked on submit button");
		if(isAlertPresent()==true) {
			Thread.sleep(2000);
			
			//Screenshot.captureScreen(driver, "login Test");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("switched to login Page");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		else {
			
			//Screenshot.captureScreen(driver, "login Test");
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("switched  f to login Page");
			logger.info("login test passed");
		}
	}
	}
