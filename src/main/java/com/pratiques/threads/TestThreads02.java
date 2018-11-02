package com.pratiques.threads;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.pratiques.date.TimeHelper;

public class TestThreads02 {

	static List<Module> listModules; 
	public static void run() {
       testGps();		
	}
	
	private static void testGps() {

		Instant startTime = Instant.now();
         Module mod1 = new Module(); 
         Module mod2 = new Module(); 

         mod1.setTimeout(100);
         mod2.setTimeout(200);
         listModules = new ArrayList<Module>(); 
         listModules.add(mod1);  
         listModules.add(mod2);  
         
		 System.out.println("--\tTest du GPS");
		 System.out.println("--\tce test peut prendre plusieurs minutes, veuillez patienter ...");

		ExecutorService esGps = Executors.newFixedThreadPool(10);
		TimeHelper.delayMilliseconds(700);

		for (Module orca : listModules) {
			esGps.submit(() -> orca.testGps());
			TimeHelper.delayMilliseconds(200);
		}

		// point de sync, on attend pour la fin de tout les threads

		try {
			//esGps.shutdown();
			esGps.awaitTermination(2000, TimeUnit.SECONDS);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		Instant endTime = Instant.now();
		long gpsTestDuration = ChronoUnit.MILLIS.between(startTime, endTime);
		String duration = TimeHelper.durationToString(gpsTestDuration);


		System.out.println("--\ttroubleshoot:  " + mod1.getTimeout() + " " + mod2.getTimeout());
		System.out.println("--\tTest GPS termine   temps: " + duration);

	}


}
