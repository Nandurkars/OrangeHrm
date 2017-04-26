package common;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Operation.UIOperation;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		 driver = new SafariDriver();
		 driver.manage().window().maximize();
	}
	
	@AfterClass
	public void quitBrowser(){
		driver.quit();
	}
	
	protected void readObectAndPerformOpertions(Properties allObjects, Sheet sheet, String tag, WebDriver driver) throws Exception {
		UIOperation uIoperation = new UIOperation(driver);
		boolean isRowStarted = false;
		tag="signin";
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
	        Row row = sheet.getRow(i);
	       // System.out.println(row.getCell(0));
	        if((row.getCell(0) !=null && row.getCell(0).toString().trim().equalsIgnoreCase(tag)) || isRowStarted){
	        	
	        	if(row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty() && isRowStarted){
	        		break;
	        	}
	        	isRowStarted = true;
	        	System.out.println(row.getCell(1).toString() + "*****" + row.getCell(2).toString() + "*****" + row.getCell(3).toString() + "*****" + row.getCell(4).toString());
	        	String operation = row.getCell(1).toString();
	        	String objectName = row.getCell(2).toString();
	        	String objectType = row.getCell(3).toString();
	        	String objectValue = row.getCell(4).toString();
	        	//uIoperation.perform(allObjects, operation, objectName, objectType, objectValue);
	        }
	    }
	}
}
