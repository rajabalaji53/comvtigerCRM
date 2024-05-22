package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("C:\\Users\\rajak\\OneDrive\\RB\\testscript.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
//		String productname = workbook.getSheet("Multipledata").getRow(2).getCell(1).toString();
//		String brand = workbook.getSheet("Multipledata").getRow(2).getCell(0).toString();
		Sheet sh = wb.getSheet("Multipledata");
		int rowcount = sh.getLastRowNum();
		
		for(int i=1;i<=rowcount;i++) {
			Row row = sh.getRow(i);
		String brand = row.getCell(0).toString();
		String productname = row.getCell(1).toString();
		
		
		System.out.println(brand +"\t"+productname);
		}
	}

}
