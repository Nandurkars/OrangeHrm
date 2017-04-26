package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;

public class HomePageTest extends BaseTest{
	
	@Test
	public void testLogin() throws Exception {
		
		executeTest(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx", "HomePageTest.xlsx", "Keyword", "login");
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/dashboard", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
    }

	@Test(dependsOnMethods = { "testEmployeeSearch" })
	public void testLogout() throws Exception {
		
		executeTest(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx", "HomePageTest.xlsx", "Keyword", "l");
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
	    
		}
	
	@Test(dependsOnMethods = { "testLogin" })
	public void testEmployeeSearch() throws Exception {
		
		executeTest(System.getProperty("user.dir") + "//InputData//HomePageTest.xlsx", "HomePageTest.xlsx", "Keyword", "SearchEmployee");
	    Assert.assertEquals("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers", driver.getCurrentUrl(), "Expected URL doesn't match with the actual URL.");
		
	}
	
}
