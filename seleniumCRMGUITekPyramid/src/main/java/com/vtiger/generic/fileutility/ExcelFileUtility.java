package com.vtiger.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String ToReadDataFromExcelFile(String sheetName, int rowNum, int CellNum) throws Throwable {

		FileInputStream fis=new FileInputStream("./testData/vtigerTestScript.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(rowNum).getCell(CellNum).toString();
		return value;
	}

	
	public int ToGetRowCount(String SheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./testData/vtigerTestScript.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		int rowcount = workbook.getSheet(SheetName).getLastRowNum();
		return rowcount;
	}
	
	public void ToSetDataIntoExcel(String sheetName, int rowNum, int CellNum, String Data) throws Throwable {
		FileInputStream fis=new FileInputStream("./testData/vtigerTestScript.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.getSheet(sheetName).getRow(rowNum).createCell(CellNum);
		
		FileOutputStream fos=new FileOutputStream("./testData/vtigerTestScript.xlsx");
		workbook.write(fos);
		workbook.close();
	}
}
