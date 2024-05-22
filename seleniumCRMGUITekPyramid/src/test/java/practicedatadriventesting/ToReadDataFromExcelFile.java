package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//Create an object of file input stream
		FileInputStream fis=new FileInputStream("C:\\Users\\rajak\\OneDrive\\RB\\testscript.xlsx");
		
		// Create on object of Workbook Factory
		Workbook workbook=WorkbookFactory.create(fis);
		
		// call the methods
		String data = workbook.getSheet("Sheet1").getRow(1).getCell(3).toString();
		System.out.println(data);
	}

}
