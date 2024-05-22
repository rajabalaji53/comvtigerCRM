package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {

		// Step 1: Create an object of fis
		FileInputStream fis=new FileInputStream("C:\\Users\\rajak\\Desktop\\commondatas.properties");
		
		//Step 2: Create an object of properties file
		Properties prop=new Properties();
		
		// Step 3: call the methods
		prop.load(fis);
		System.out.println(prop.getProperty("url"));
		
	}

}
