package TestClasses;

import java.util.Properties;

import Operation.ReadObjectRepo;
import Operation.UIOperation;
import common.BaseTest;
import utilities.ExcelUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

	@Test(priority = 0)
	public void testLogin() throws Exception {
		
		ExcelUtils file = new ExcelUtils();
		ReadObjectRepo object = new ReadObjectRepo();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(driver);
		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "Keyword");
	    int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	    readObectAndPerformOpertions(allObjects, operation, sheet, rowCount);
	    Thread.sleep(5000);
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/dashboard", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
    }
	
	/*@Test(dependsOnMethods = { "testEmployeeSearch" })
	public void testLogout() throws Exception {
		
		ExcelUtils file = new ExcelUtils();
		ReadObjectRepo object = new ReadObjectRepo();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(driver);
		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "Keyword");
	    int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	    readObectAndPerformOpertions(allObjects, operation, sheet, rowCount);
		
		}
	
	@Test(dependsOnMethods = { "testLogin" })
	public void testEmployeeSearch() throws Exception {
		ExcelUtils file = new ExcelUtils();
		ReadObjectRepo object = new ReadObjectRepo();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(driver);
		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "Keyword");
	    int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	    readObectAndPerformOpertions(allObjects, operation, sheet, rowCount);
		
	}*/
	
}
