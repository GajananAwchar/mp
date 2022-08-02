package com.demo.webelements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class GoogleSearch_elements {
	public WebDriver driver;
	@FindBy (xpath="//form[@action='/search']/div/div/div/div/div[2]/input") public WebElement search_textbox;

	public GoogleSearch_elements(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
}
