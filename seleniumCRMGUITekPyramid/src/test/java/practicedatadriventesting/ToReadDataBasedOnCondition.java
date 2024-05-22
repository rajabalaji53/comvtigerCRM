package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String expectedTestId = "tc_12";
		String column1 = "";
		String column2 = "";
		String column3 = "";
		boolean flag=false;

		FileInputStream fis = new FileInputStream("C:\\Users\\rajak\\OneDrive\\RB\\testscript.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet("Org");

		int rowcount = sh.getLastRowNum();

		for (int i = 0; i <= rowcount; i++) {
			String data = "";
			try {
				data = sh.getRow(i).getCell(0).toString();
				if (data.equals(expectedTestId)) {
					flag=true;
					column1 = sh.getRow(i).getCell(1).toString();
					column2 = sh.getRow(i).getCell(2).toString();
					column3 = sh.getRow(i).getCell(3).toString();
				}
			} catch (Exception e) {
			}

		}
		if(flag==true) {
		System.out.println(column1);
		System.out.println(column2);
		System.out.println(column3);
		}else {
			System.out.println(expectedTestId + " is not available");
		}

	}

}
