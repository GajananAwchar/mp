package com.demo.sikulipracticeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SikuliPractice {
	public WebDriver driver;
	
@Test
public void testSikuli() throws Exception {
	//System.setProperty("webdriver.edge.driver", "C:\\Users\\Mobile Programming\\eclipse-workspace\\Demo\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
	WebDriverManager.edgedriver().setup();	
	driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	String login = "./Photo//login.png";
	String uname = "./Photo//uname.png";
	String pass = "./Photo//pass.png";
	Screen s= new Screen();
	
    Pattern txt_uname = new Pattern(uname);
    Pattern txt_pass = new Pattern(pass);
    Pattern click_login = new Pattern(login);
    try {
		s.wait(txt_uname,5);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    s.type(txt_uname,"admin");
    s.type(txt_pass, "admin@123");
    s.click(click_login													);
    
}
}
