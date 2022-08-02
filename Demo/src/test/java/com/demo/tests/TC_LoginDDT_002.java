package com.demo.tests;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.*;
import com.demo.pages.LoginPage;
import com.demo.utilities.XLUtils;
public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.launchURL();
		//driver.get(base_URL);
		logger.info("URL is opened");
		
		lp.setUsername(user);
		logger.info("entered username");
		Thread.sleep(2000);
		lp.setPassword(pwd);
		Thread.sleep(2000);
		logger.info("entered password");
		lp.clickSubmit();
		Thread.sleep(2000);
		logger.info("clicked on submit button");
		if(isAlertPresent()==true) {
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("switched to login Page");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("login test passed");
			lp.clickLogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("switched to login Page");
		}
	}
	public boolean isAlertPresent() throws InterruptedException { // user defined method to check alert is present or not
		try {
			Thread.sleep(2000);
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		String path= System.getProperty("user.dir") +"//TestData//data.xlsx";
	int rownum= XLUtils.getRowCount(path, "sheet1");
	int colcount= XLUtils.getCellCount(path, "sheet1", 1);
	String logindata [][] = new String [rownum][colcount];
	for (int i=1; i<=rownum; i++) {
		for(int j=0; j<colcount; j++) {
			// j is column number
			// i is row number
			logindata[i-1][j] = XLUtils.getCellData(path, "sheet1", i, j);
		}
	}
	return logindata;
	}
	
}
