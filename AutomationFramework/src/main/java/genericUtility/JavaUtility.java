package genericUtility;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;


/**
 * This class will have the methods related to java
 */
public class JavaUtility {

	/**
	 * This method will generate random numbers
	 * @return
	 */
	public int toCreateRandomNumber() {
		Random r=new Random();
		int randomValue = r.nextInt(1000);
		return randomValue;
	}
	
	/**
	 * This method will get actual time and date of system
	 * @return
	 */
	@Test
	public String toGetSystemDateAndTime() {
		Date d=new Date();
		String date[]=d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String finaldate = day+" "+month+" "+date1+" "+time+" "+year;
	//	System.out.println(finaldate); //Wed Mar 20 08-46-40 2024
		return finaldate;
	}
}
