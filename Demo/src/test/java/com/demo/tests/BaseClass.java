package com.demo.tests;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import com.demo.utilities.ReadConfig;
public class BaseClass {
	public static WebDriver driver;
	ReadConfig rd=new ReadConfig();
	public static Logger logger;
	public  String base_URL=rd.getAppURL();
	public String username= rd.getUsername();
	public String password = rd.getPassword();
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger("netBanking");
		PropertyConfigurator.configure("Log4j.Properties");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rd.getChromePath());
			 driver= new ChromeDriver();
		}
		else if(br.equals("edge")){
			System.setProperty("webdriver.edge.driver", rd.getEdgepath());
			 driver= new EdgeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rd.getFirefoxPath());
			 driver= new FirefoxDriver();
		}
		else if(br.equals("opera")) {
			System.setProperty("webdriver.opera.driver", rd.getOperaPath());
			 driver= new OperaDriver();
		} 
		else {
			System.out.println("please provide a valid browser");
		}
		//System.setProperty("webdriver.edge.driver", + System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}
	public boolean isAlertPresent() throws InterruptedException { // user defined method to check alert is present or not
		try {
			Thread.sleep(2000);
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}