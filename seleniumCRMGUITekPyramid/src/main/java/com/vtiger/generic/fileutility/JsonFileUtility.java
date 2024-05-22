package com.vtiger.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileUtility {
	
	public String ToReadDataFromJsonFile(String Key) throws Throwable {
		
		FileReader fileR=new FileReader("./configAppData/commondata.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse((fileR));
		JSONObject map = (JSONObject) obj;

		String value=(String) map.get(Key);
		return value;
	}

}
