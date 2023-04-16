package com.qa.hybridrediff.testdata;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SupplyTestData {
	
	public static 	FileInputStream ip;
	public static 	XSSFWorkbook workbook; 
	public static   XSSFSheet sheet;
	
	@DataProvider(name="rediffDataProviderSupply")
	
	public static Object[][] dataSupplyForm2DimentionalArray() {
		Object[][] data = {{"chowdhurygs@rediffmail.com", "Shajlee1@"},
				           {"seleniumpanda@rediffmail.com", "Selenium@123"},
				           {"sarthakkumarpanda@rediffmail.com", "Selenium@123"},
				           {"Mohamedboudguig@rediffmail.com", "Medbdg0707@"}};
		return data;

	}
	
	@DataProvider(name="rediffExcellDataWithDataProvider")
	public static Object[][] excelSheetDataSupply() throws Exception {
		Object[][] data = SupplyTestData.getRediffTestDataFromExcelSheet("Login");
		return data;
		
	}
 
	public static Object[][] getRediffTestDataFromExcelSheet(String sheetName) throws Exception {
		//Step1: We have to create the object of the FileInputStream
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\hybridrediff\\testdata\\Rediff Test Data.xlsx");
		//Step2: We have to create the object of XSSFWorkbook
		workbook = new XSSFWorkbook(ip);
		//Step3: XSSFSheet
		sheet = workbook.getSheet(sheetName);
		//Step4: Determine the number of rows and columns:
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		for(int i=0; i<rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0; j<cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
		
		
		
		
	}

}

	



