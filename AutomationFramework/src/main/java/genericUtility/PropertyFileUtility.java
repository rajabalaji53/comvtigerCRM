package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 */
public class PropertyFileUtility {
	/**
	 * This method will extract the data from the property file using the key which we have passed
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String toReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantUtility.propertyfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
