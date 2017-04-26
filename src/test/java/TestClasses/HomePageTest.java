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
	
	private void executeTest(String path, String sheetName, String keyword, String objectPath) throws Exception{
		Properties allObjects = object.getObjectRepository(objectPath);
		Sheet sheet = file.readExcel(path, sheetName, keyword);
	    String tag = "login";
	    readObectAndPerformOpertions(allObjects, sheet, tag);
	}

	@Test
	public void testLogin() throws Exception {
		executeTest(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "login", System.getProperty("user.dir") + "//ObjectRepo//object.properties");
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/dashboard", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
    }
	
	@Test(dependsOnMethods = { "testEmployeeSearch" })
	public void testLogout() throws Exception {
		
		executeTest(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "logout", System.getProperty("user.dir") + "//ObjectRepo//object.properties");
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
	}
	
	@Test(dependsOnMethods = { "testLogin" })
	public void testEmployeeSearch() throws Exception {
		
		executeTest(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx","HomePageTest.xlsx", "searchEmployee", System.getProperty("user.dir") + "//ObjectRepo//object.properties");
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
	}
	
}
