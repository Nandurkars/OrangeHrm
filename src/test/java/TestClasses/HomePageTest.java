package TestClasses;

import java.util.Properties;

import Operation.ReadObjectRepo;
import common.BaseTest;
import utilities.ExcelUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

	@Test
	public void testLogin() throws Exception {
		
		ExcelUtils file = new ExcelUtils();
		ReadObjectRepo object = new ReadObjectRepo();
		Properties allObjects = object.getObjectRepository();
		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "Keyword");
	    String tag = "login";
	    readObectAndPerformOpertions(allObjects, sheet, tag, driver);
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
