package com.demo.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot extends BaseClass {
	public  static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="screenshot"+timeStamp+".png";
		File target= new File(System.getProperty("uswer.dir") + "/Screenshots/" + tname + repName);
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
