package project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.M3.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet = workbook.getSheet("Contacts");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		String value = cell.toString();
		System.out.println(value);
	}

}
