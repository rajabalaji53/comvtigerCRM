package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ToReadDataFromPropertyFIle {

	public static void main(String[] args) throws IOException {

		// Step 1:- Create an object of FIS
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\commonData.Properties");
		
		// Step 2:- Create an object of property
		Properties prop=new Properties();
		
		// Step 3:- Call the methods
		prop.load(fis);
		String url = prop.getProperty("url");
		System.out.println(url);
	}

}
