package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void launchBrowser(){
		 //setWebdriverCapabilities();
		 System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "//lib//geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get("http://opensource.demo.orangehrmlive.com/");
	}
	
	@AfterClass
	public void quitBrowser(){
		driver.quit();
	}
	
	public void setWebdriverCapabilities(){
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		dc.setCapability(FirefoxDriver.PROFILE, profile);
		driver =  new FirefoxDriver(dc);
	}
}
