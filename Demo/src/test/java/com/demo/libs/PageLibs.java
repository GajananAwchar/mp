package com.demo.libs;

import org.openqa.selenium.WebDriver;

import com.demo.pages.LoginPage;

public class PageLibs {
	private WebDriver driver;
	private LoginPage lp;
	
	public  PageLibs(WebDriver driver) {
		this.driver= driver;
		lp = new LoginPage(this.driver);
	}
	public LoginPage login() {
		return lp;
	}

}
