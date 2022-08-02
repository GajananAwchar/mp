package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.tests.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements( rdriver, this);
	}
	
	@FindBy (xpath= "//input[@name='uid']")
	@CacheLookup
	 WebElement txtusername;
	@FindBy (xpath= "//input[@name='password']") 
	WebElement txtpassword;
	@FindBy (xpath= "//input[@name='btnLogin']") 
	WebElement loginBtn;
	@FindBy (xpath="//a[text()='Log out']") 
	WebElement logout;
	
	public void setUsername(String uname) {
		txtusername.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		loginBtn.click();
	}
	public void clickLogout() {
		logout.click();
	}
	public void launchURL() {
		driver.get(base_URL);
	}

}