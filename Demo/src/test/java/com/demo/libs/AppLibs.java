package com.demo.libs;

import org.openqa.selenium.WebDriver;

public class AppLibs {
	private FlowLibs flow;
	private PageLibs page;
	protected WebDriver driver;
	
public AppLibs(WebDriver driver) {
	this.driver= driver;
	flow = new FlowLibs(driver);
	page = new PageLibs(driver);
}
FlowLibs flows() {
	return flow;
}
PageLibs pages() {
	return page;
}

}
