package com.orangehrm.tests;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Practicea {
	public SoftAssert ass;
	protected static WebDriver driver;
	@BeforeMethod
	public void launch() {
		WebDriverManager.chromedriver().browserVersion("103.0.5060.114").setup();
		 driver= new ChromeDriver();
		 driver.get("https://www.google.co.in/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	@Test (enabled=false)
	public void start() {
		ass = new SoftAssert();
	
	 // global wait, applied for entire driver session, hence hard coding this 
	// wait for longer time duration will increase execution time.
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	 String title= driver.getTitle();
	 
String exp_title= "Google";
	 if(title.contains(exp_title)) {
		 ass.assertTrue(true);
		 System.out.println("validated google page url");
	 }
	 else {
		 ass.assertTrue(false);
	 }
	//explicit wait it is used to tell wabdriver to wait for certain conditions
	 // expected conditions or maximum time 
	 //exceeded before throwing "ElementNotVisibleException"
	 //applied to on single statement
	 WebElement txt_box= driver.findElement(By.name("q"));
	 // explicit wait>> type  WebDriver wait
	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));  // explicit wait
	 wait.until(ExpectedConditions.visibilityOf(txt_box));// wait until visibility of ele
	 txt_box.sendKeys("w3c schools");
WebElement btn_search= 	 driver.findElement(By.xpath("(//input[@value='Google Search'])[2]"));
btn_search.click();
String search_title= driver.getTitle();
String searchPage_title= "w3c schools - Google Search";
if(search_title.contains(searchPage_title)) {
	 ass.assertTrue(true);
	 System.out.println("passed search test");
}
else {
	 ass.assertTrue(false);
}
ass.assertAll();

driver.close();
}

//wait.until(ExpectedConditions.elementToBeClickable(btn_search)); // wait until element to be clickable
//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframe"));
// wait to frame be available and switch to it
//wait.until(ExpectedConditions.invisibilityOf(txt_box));// returns true if ele is not visibile/ stale element
//other conditions
// wait.until(ExpectedConditions.alertIsPresent()); // wait until alert is present / timeout
	
	@Test
	public void FluentWait() {
		
		
		/*FluentWait can define the maximum amount of time to wait for a specific 
		 * condition and frequency with which to check the condition before throwing an “ElementNotVisibleException” exception.
		To say in effortless manner, it tries to find the web element 
		repeatedly at regular intervals of time until the timeout or till 
		the object gets found.
		We use FluentWait commands mainly when we have web elements which 
		sometimes visible in few seconds and some times take more time than 
		usual. Mainly in Ajax applications. We could set the default pooling period 
		based on our requirement. We could ignore any exception while polling an element.
		*/
		 final WebElement txt_box= driver.findElement(By.name("q"));
		WebElement btn_search= 	 driver.findElement(By.xpath("(//input[@value='Google Search'])[2]"));
		//explicit wait>> type  fluent wait
		Wait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(4))
				.ignoring(NoSuchElementException.class);
		WebElement test= fluentWait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return txt_box;
			}
		});
		test.sendKeys("w3c schools");
btn_search.click();
	}
	@Test
	public void threadConcept() throws InterruptedException {
		try {
			// thread.sleep utilisation
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 WebElement txt_box= driver.findElement(By.name("q"));
		 txt_box.sendKeys("Thread.sleep meaning in java");
		WebElement btn_search= 	 driver.findElement(By.xpath("(//input[@value='Google Search'])[2]"));
		Thread.sleep(5);
		btn_search.click();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}}
