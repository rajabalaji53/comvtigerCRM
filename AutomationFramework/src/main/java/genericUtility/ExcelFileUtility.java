package genericUtility;

/**
 * This class consists of method related to excel file
 */

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * This will read the data from the excel file based on the key value which we passed
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String toReadDataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream efis = new FileInputStream(IConstantUtility.excelfilepath);
		Workbook workbook=WorkbookFactory.create(efis);
		String lastname = workbook.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return lastname;
	}
}
