package TestClasses;

import java.util.Properties;
import Operation.ReadObjectRepo;
import Operation.UIOperation;
import common.BaseTest;
import utilities.ExcelUtils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

	@Test
	public void testLogin() throws Exception {
		
	ExcelUtils file = new ExcelUtils();
	ReadObjectRepo object = new ReadObjectRepo();
	Properties allObjects = object.getObjectRepository();
	UIOperation operation = new UIOperation(driver);
	Sheet sheet = file.readExcel(System.getProperty("user.dir") + "\\InputData\\","HomePageTest.xlsx", "Keyword");
    int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    for (int i = 1; i < rowCount + 1 ; i++) {
        Row row = sheet.getRow(i);
        if(row.getCell(0).toString().length() == 0){
            System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + 
            row.getCell(3).toString() + "----" + row.getCell(4).toString());
            operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
    		row.getCell(3).toString(), row.getCell(4).toString());
        }
        else{
                System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
            }
        }
    }
}
