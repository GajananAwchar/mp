package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver, this);
	}
	//public LoginPage page= PageFactory.initElements( driver, LoginPage.class);
	@FindBy(how= How.XPATH, using="//input[@name='uid']")
	@CacheLookup
	WebElement txtusername;
	
	//@FindBy (xpath= "//input[@name='uid']")
	//@CacheLookup
	// WebElement txtusername;
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
}