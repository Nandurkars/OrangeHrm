package common;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Operation.UIOperation;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void launchBrowser(){
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib//chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	@AfterClass
	public void quitBrowser(){
		driver.quit();
	}
	
	protected void readObectAndPerformOpertions(Properties allObjects, UIOperation operation, Sheet sheet, int rowCount) throws Exception {
		for (int i = 1; i < rowCount + 1 ; i++) {
		    Row row = sheet.getRow(i);
		    if(row.getCell(0).toString().length() == 0){
		        System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + 
		        row.getCell(3).toString() + "----" + row.getCell(4).toString());
		        operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
				row.getCell(3).toString(), row.getCell(4).toString());
		    }
		    else
		            System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
		    }
	}
}
