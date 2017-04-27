package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserActions {
	
	WebDriver driver;
	public BrowserActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getUrl(String url){
		driver.get(url);
	}
	
	public void clearAndSendKeysToElement(WebElement element, String text){
		element.clear();
		element.sendKeys(text);
	}
	
	public boolean isElementDisplayed(WebElement element){
		applyImplicitWait();
		return element.isDisplayed();
	}
	
	public void applyImplicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void clickOnElement(WebElement element){
		element.click();
	}
	
	public String getText(WebElement element){
		return element.getText();
	}
	
	public void navigateBack(){
		driver.navigate().back();
	}
	
	public void navigateForword(){
		driver.navigate().forward();
	}
}
