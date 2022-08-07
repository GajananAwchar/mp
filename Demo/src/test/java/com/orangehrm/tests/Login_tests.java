package com.orangehrm.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.Add_Employee_Page;
import com.orangehrm.pages.Login_Page;

public class Login_tests extends BaseClass{
	@Test(groups = "add_Employee", priority= 0)
	public void Login_Test001() throws InterruptedException{
	Login_Page lp = new Login_Page(driver);
	lp.launchURL();
	driver.get(base_URL);
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
	if(lp.getCurrentUrl().contains(base_URL)) {
		Assert.assertTrue(false);
		logger.info(" invalid Credentials");
	}
	else {
		Assert.assertTrue(true);
		logger.info("logged in successfully");
	}
	}
	@Test(dependsOnMethods = "Login_Test001")
	public void add_Emp_Test001() throws InterruptedException{
		Add_Employee_Page add_emp = new Add_Employee_Page(driver);
	add_emp.txt_box_first_Name();
	Thread.sleep(2000);
	logger.info("User Entered FirstName");
	add_emp.Enter_Middle_Name();
	logger.info("User Entered MiddleName");
	add_emp.Enter_Last_Name();
	logger.info("User Entered Last Name");
	add_emp.Enter_Emp_Id();
	logger.info("User Entered UId");
	Thread.sleep(2000);
	add_emp.attach_Photofile();
	Thread.sleep(2000);
	logger.info("User Attached Photo");
	add_emp.click_checkbox();
	Thread.sleep(2000);
	logger.info("User clicked Checkbox");
	add_emp.setUsername();
	logger.info("User entered UserName");
	add_emp.setPassword();
	logger.info("User Entered Password");
	add_emp.setRePassword();
	logger.info("User ReEntered Password");
	add_emp.select_dropdown();
	logger.info("User Selected Dropdownn");
	add_emp.save_Btn_click();
	logger.info("User clicked on Save Button");	

}
	}

