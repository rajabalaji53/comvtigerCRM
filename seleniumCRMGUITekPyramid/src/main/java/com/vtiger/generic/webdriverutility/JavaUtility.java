package com.vtiger.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random=new Random();
		int randomNumber = random.nextInt(3000);
		return randomNumber;
	}
	
	public String toGetSystemDateYYYYDDMM() {
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateobj);
		return date;
	}
	
	public String getEndDateYYYYDDMM(int days) {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date=sim.format(dateobj);

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String enddate = sim.format(cal.getTime());
		return enddate;
	}
	
//	/**
//	 * This method is used to take the system date and time to attach with screen Shot( method 1) 
//	 * @return
//	 */
//	public String DateAndTime() {
//		String sysdatetime = new Date().toString().replace(" ", "_").replace(":", "_"); //Before===>//Wed May 15 12:40:11 IST 2024
//		System.out.println(sysdatetime);   // After==> //Wed_May_15_12_44_40_IST_2024
//		return sysdatetime;
//		
	//}
	/**
	 * This method is used to take the system date and time to attach with screen Shot( Method 2)
	 * @return 
	 */
	@Test
	public String SystemDateAndTime() {
		Date d=new Date();
	    String date[]=d.toString().split(" ");
	    String day=date[0];
	    String month=date[1];
	    String date1=date[2];
	    String time=date[3].replace(":", "_");
	    String year=date[5];
	    
	    String finaldatetime = day+" "+month+" "+date1+" "+time+" "+year;
	    System.out.println(finaldatetime); //Wed Wed May 15 12_59_40 2024
		return finaldatetime;
	}
	

}
