package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    
    public Sheet readExcel(String filePath, String fileName) throws IOException{
    File file = new File(filePath);
    FileInputStream inputStream = new FileInputStream(file);
    Workbook workbook = null;
    String fileExtension = fileName.substring(fileName.indexOf("."));
    if(fileExtension.equals(".xlsx"))
    	workbook = new XSSFWorkbook(inputStream);
    else if(fileExtension.equals(".xls"))
    	workbook = new HSSFWorkbook(inputStream);
    Sheet sheet = workbook.getSheet(fileName.replace(".xlsx", ""));
    workbook.close();
    return sheet;   
    } 
}

