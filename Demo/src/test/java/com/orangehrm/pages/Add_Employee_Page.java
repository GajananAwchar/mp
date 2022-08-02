package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.utils.FlowLibs;
import com.orangehrm.tests.BaseClass;

public class Add_Employee_Page extends BaseClass  {
		WebDriver driver;
		public Add_Employee_Page(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements( driver, this);
		}
		@FindBy (xpath= "//b[text()='PIM']")
		@CacheLookup
		 WebElement PIM_Btn;
		@FindBy (id= "firstName")
		@CacheLookup
		 WebElement txt_First_Name;
		@FindBy (id= "middleName")
		@CacheLookup
		 WebElement txt_Middle_Name;
		@FindBy (id= "lastName")
		@CacheLookup
		 WebElement txt_Last_Name;
		@FindBy (id= "employeeId")
		@CacheLookup
		 WebElement txt_Emp_Id;
		@FindBy (id= "photofile")
		@CacheLookup
		 WebElement attach_Photofile;
		
		@FindBy (id= "chkLogin")
		@CacheLookup
		 WebElement checkbox_createLogin;
		@FindBy (id= "user_name")
		@CacheLookup
		 WebElement txt_setUsername;
		
		@FindBy (id= "user_password")
		@CacheLookup
		 WebElement txt_setPassword;
		@FindBy (id= "re_password")
		@CacheLookup
		 WebElement txt_setRePassword;
		
		@FindBy (id= "status")
		@CacheLookup
		 WebElement select_dropdown;
		
		@FindBy (id= "btnSave")
		@CacheLookup
		 WebElement save_Btn;
		
		public void moveto_add_Emp_click() {
			FlowLibs.mouseOver_click(PIM_Btn);
		}
		public void txt_box_first_Name() {
			FlowLibs.mouseOver_click(PIM_Btn);
		}
		public void Enter_First_Name() {
			txt_First_Name.clear();
			txt_First_Name.sendKeys("Nanasaheb");
		}
		public void Enter_Middle_Name() {
			txt_Middle_Name.clear();
			txt_Middle_Name.sendKeys("Kakasaheb");
		}
		public void Enter_Last_Name() {
			txt_Last_Name.clear();
			txt_Last_Name.sendKeys("Deshmukh");
		}
		public void Enter_Emp_Id() {
			txt_Emp_Id.clear();
			txt_Emp_Id.sendKeys("20");
		}
		public void attach_Photofile() {
			txt_Emp_Id.click();
			txt_Emp_Id.sendKeys("./Photo//test.png");
		}
		public void click_checkbox() {
			checkbox_createLogin.click();
		}
		public void setUsername() {
			txt_setUsername.sendKeys("Nanasaheb@123");
		}
		public void setPassword() {
			txt_setPassword.sendKeys("Pass@123");
		}
		public void setRePassword() {
			txt_setRePassword.sendKeys("Pass@123");
		}
		public void select_dropdown() {
	
			FlowLibs.select_dropdown(select_dropdown, "Enabled");
		}
	
		public void save_Btn_click() {
			save_Btn.click();
		}
		
}
