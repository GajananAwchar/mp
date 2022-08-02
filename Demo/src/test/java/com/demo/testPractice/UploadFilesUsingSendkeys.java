package com.demo.testPractice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class UploadFilesUsingSendkeys {
	public static void main (String [] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		WebElement ele= driver.findElement(By.id("uploadFile"));
		//ele.click();
		ele.sendKeys("D:\\backup\\sample.txt.txt");
		Thread.sleep(10000);
	}

	}
