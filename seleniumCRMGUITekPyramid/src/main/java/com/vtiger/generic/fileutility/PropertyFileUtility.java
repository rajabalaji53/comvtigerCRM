package com.vtiger.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String ToReadDataFromPropertyFile(String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./configAppData/commondatas.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
