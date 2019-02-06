package com.pratiques.math;

public class TestCalculDistance {

	final static double PI = 3.1415926535f;
    final static double R = 6371e3; 

// 45.544436, -73.667399
// 45.544305, -73.667469    
    
	public static void run() {

/*		log("Test calcul de distance");
		log(" --   " + getDistance(45.544436, -73.667399, 45.544305,  -73.667469)); 
		log(" --   " + getDistance(45.747593, -73.700272,45.748234, -73.701225)); 
		log(" --   " + getDistance(45.751064, -73.70546, 45.748234, -73.701225)); 
		log(" --   " + getDistance(45.747551, -73.700218, 45.747593, -73.700272)); 
		log(" --   " + getDistance(45.769035, -73.818199, 45.768887, -73.817924)); 
		log(" --   " + getDistance(45.725594, -73.668312, 45.72562, -73.667763)); 
		log(" --   " + getDistance(45.568928, -73.910324, 45.568825, -73.9105)); 
		log(" --   " + getDistance(45.563332, -73.903885, 45.563248, -73.903793));// points 22 et 23 Asplundh 05-02-2019 
		log(" --   " + getDistance(4532.303223/60, 7339.505859/60, 4532.302246/60, 7339.503906/60 )); 
		log(" --   " + getDistance(4532.302246, 7339.503906, 4532.298340, 7339.503906));  
		log(" --   " + getDistance(45.568409, -73.910591, 45.56823, -73.910355)); 
		*/
		log(" --   " + getDistance(45.568863, -73.91053, 45.56876, -73.910645)); 
		log(" --   " + getDistance(45.540234, -73.910896, 45.539925, -73.910515)); 

//		log(" --   " + toDecimal(4532.302246)); 

	}
   static private double toDecimal(double deg) {
		   int u = (int)(deg / 100);
		   double b1 = (double)((deg - (u * 100)) / 60.0);
		   double b2 = (double)((u) + b1);
	      return   b2;
		}

	private static double toRadian(double deg) {
		return ((deg * PI) / 180.0f);
	}

	private static void log(String arg0) {
		System.out.println(arg0);
	}
	
	private static double getDistance(double lat1, double lon1, double lat2, double lon2) {
		// source de la formule https://www.movable-type.co.uk/scripts/latlong.html
		double v1 = toRadian(lat1); 
		double v2 = toRadian(lat2); 
		double delta1 = toRadian(lat2 - lat1); 
		double delta2 = toRadian(lon2 - lon1); 
		double a = (Math.sin(delta1 / 2) * Math.sin(delta1 / 2)) + (Math.cos(v1) * Math.cos(v2) * Math.sin(delta2 / 2) * Math.sin(delta2 / 2)); 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); 

		return R * c; 
	}
}
