package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.tests.BaseClass;
public class Login_Page extends BaseClass {
	WebDriver driver;
	public Login_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	@FindBy (xpath= "//input[@id='txtUsername']")
	@CacheLookup
	 WebElement txtusername;
	@FindBy (xpath= "//input[@id='txtPassword']") 
	WebElement txtpassword;
	@FindBy (xpath= "//input[@id='btnLogin']") 
	WebElement loginBtn;
	public void setUsername(String uname) {
		txtusername.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		loginBtn.click();
	}
	public String getCurrentUrl() {
		String acgt_Url= driver.getCurrentUrl();
		 return acgt_Url;
	}
	public void launchURL() {
		driver.get(base_URL);
	}
}
