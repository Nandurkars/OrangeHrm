package TestClasses;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtils;
import Operation.ReadObjectRepo;

import common.BaseTest;

public class HomePageTest extends BaseTest{
	
	ExcelUtils file = new ExcelUtils();
	ReadObjectRepo object = new ReadObjectRepo();

	@Test
	public void testLogin() throws Exception {
		
		Properties allObjects = object.getObjectRepository();
		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "Keyword");
	    String tag = "login";
	    readObectAndPerformOpertions(allObjects, sheet, tag, driver);
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/dashboard", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
    }
	
	@Test(dependsOnMethods = { "testEmployeeSearch" })
	public void testLogout() throws Exception {
		
		Properties allObjects = object.getObjectRepository();
		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "Keyword");
	    String tag = "Logout";
	    readObectAndPerformOpertions(allObjects, sheet, tag, driver);
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
	    
		}
	
	@Test(dependsOnMethods = { "testLogin" })
	public void testEmployeeSearch() throws Exception {
		
		Properties allObjects = object.getObjectRepository();
		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "Keyword");
	    String tag = "SearchEmployee";
	    readObectAndPerformOpertions(allObjects, sheet, tag, driver);
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
		
	}
	
}
