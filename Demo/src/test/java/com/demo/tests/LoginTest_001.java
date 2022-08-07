package com.demo.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.demo.pages.LoginPage;
import com.demo.utilities.Screenshot;
import com.demo.utils.BaseClass;
public class LoginTest_001 extends BaseClass {
	@Test 
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		ass= new SoftAssert();
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
			
			Screenshot.captureScreen(driver, "loginTest");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("switched to login Page");
			ass.assertTrue(false);
			logger.info("login test failed");
		}
		else {
			
			
			ass.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("switched  f to login Page");
			logger.info("login test passed");
		
		}
		ass.assertAll();
	} 
	}
