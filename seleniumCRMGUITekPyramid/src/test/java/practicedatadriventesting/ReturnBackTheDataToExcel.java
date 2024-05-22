package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReturnBackTheDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("C:\\Users\\rajak\\OneDrive\\RB\\testscript.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Org");
		Row row = sh.getRow(1);
		Cell cells = row.createCell(4);
		cells.setCellType(CellType.STRING);
		cells.setCellValue("FAIL");
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\rajak\\OneDrive\\RB\\testscript.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("end");
		
	}

}
