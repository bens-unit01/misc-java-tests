package com.pratiques.math;

public class TestCalculDistance {

	final static double PI = 3.1415926535f;
    final static double R = 6371e3; 

// 45.544436, -73.667399
// 45.544305, -73.667469    
    
	public static void run() {
		log("Test calcul de distance");
		log(" --   " + getDistance(45.544436, -73.667399, 45.544305,  -73.667469)); 
	}

	private static double toRadian(double deg) {
		return ((deg * PI) / 180.0f);
	}

	private static void log(String arg0) {
		System.out.println(arg0);
	}
	
	private static double getDistance(double lat1, double lon1, double lat2, double lon2) {
		double v1 = toRadian(lat1); 
		double v2 = toRadian(lat2); 
		double delta1 = toRadian(lat2 - lat1); 
		double delta2 = toRadian(lon2 - lon1); 
		double a = (Math.sin(delta1 / 2) * Math.sin(delta1 / 2)) + (Math.cos(v1) * Math.cos(v2) * Math.sin(delta2 / 2) * Math.sin(delta2 / 2)); 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); 

		return R * c; 
	}
}
