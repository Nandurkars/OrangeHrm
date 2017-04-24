package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void launchBrowser(){
		 //setWebdriverCapabilities();
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib//chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://opensource.demo.orangehrmlive.com/");
	}
	
	@AfterClass
	public void quitBrowser(){
		driver.quit();
	}
	
	
}
