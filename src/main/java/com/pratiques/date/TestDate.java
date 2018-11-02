package com.pratiques.date;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestDate {
	
	public static void run() {
	
		System.out.println(" .. Test date");
	
		test01(); 
	}
	
	
  private static void test01() {
	  
	Calendar c =  Calendar.getInstance();  
	System.out.println("-- " + c.getTime());   
	TimeHelper.delaySeconds(2);
	Calendar d =  Calendar.getInstance();  
	System.out.println("-- " + d.getTime());   
    
    Instant t1 = Instant.now(); 
	TimeHelper.delaySeconds(2);
    Instant t2 = Instant.now(); 
	System.out.println("-- "  +  t1 + " " + t2 + " " + ChronoUnit.MILLIS.between(t1, t2));   

	long minutes = TimeUnit.MILLISECONDS.toMinutes(65000);
	long seconds = TimeUnit.MILLISECONDS.toSeconds((65000 - (minutes * 60 * 1000)));
	System.out.println("-- "  +  minutes + " " + seconds );  
	String min = minutes + "";  
	String sec = (seconds <= 9)? "0" + seconds : seconds + "" ;  
	System.out.println("-- "  +  minutes + ":" + sec);  

  }	

}
