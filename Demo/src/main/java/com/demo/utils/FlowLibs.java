package com.demo.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FlowLibs extends BaseClass {
	public static Actions act= new Actions(driver);
	public static Select select;
	public static void mouseOver(WebElement ele) {
		act.moveToElement(ele).perform();
	}
	public static void mouseOver_click(WebElement ele) {
		 
		act.moveToElement(ele).click().build().perform();
	}
	public static void  select_dropdown(WebElement ele, String value) {
		select= new Select(ele);
		select.selectByValue(value);
	}
}
