package project;

import java.io.IOException;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;

public class ToWorkOnGenericUtility {

	public static void main(String[] args) throws IOException {

		PropertyFileUtility putil=new PropertyFileUtility();
		String value = putil.toReadDataFromPropertyFile("password");
		System.out.println(value);
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String lastname = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		System.out.println(lastname);
		
	}

}
