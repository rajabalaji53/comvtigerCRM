package practicedatadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		// Step 1: parse JSON physical file in to java object using JsonParse class
		
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\rajak\\Desktop\\commondata.json"));
		
		// Step 2:
		JSONObject map=(JSONObject)obj;
		
		// Step 3: get the value from the json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("timeout"));
	}

}
