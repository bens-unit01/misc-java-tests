package com.pratiques.math;

public class TestTemperature {
	public static void run() {
		System.out.println(" input:1 " + convertCountToCelsiusTempAnalogic(1)); 
		System.out.println(" input:2 " + convertCountToCelsiusTempAnalogic(2)); 
		System.out.println(" input:3 " + convertCountToCelsiusTempAnalogic(3)); 
		System.out.println(" input:70 " + convertCountToCelsiusTempAnalogic(70)); 
		System.out.println(" input:71 " + convertCountToCelsiusTempAnalogic(71)); 
		System.out.println(" input:72 " + convertCountToCelsiusTempAnalogic(72)); 
		System.out.println(" input:73 " + convertCountToCelsiusTempAnalogic(73)); 
		System.out.println(" input:74 " + convertCountToCelsiusTempAnalogic(74)); 
		System.out.println(" input:75 " + convertCountToCelsiusTempAnalogic(75)); 
		System.out.println(" --------------------------          " ); 

		System.out.println(" input:75 " + convertCelsiusTempToCountAnalogic(93)); 

		}

	public static int convertCelsiusTempToCountAnalogic(int temperature)
	{
		double count = 0.0f;
		
		count  = (-41.052 * temperature)+2369.1;
		
//		count = roundToHalf((float) temperature);
		
	
		return ((int)count);
	}
	
	
	public static float roundToHalf(float x) {

	    return (float) (Math.ceil(x * 2) / 2);

	}
	
	public static float convertCountToCelsiusTempAnalogic(int u16Count)
	{
		/*double temperature = 0.0f;
		temperature  = (-0.0244 * count)+57.7;
		temperature = roundToHalf((float) temperature);
	u	
		return ((float) temperature);*/
		float CONST_A = 0.002406134547f;
		float CONST_B =0.00002083433721f;
		float CONST_C =0.0000009675854454f;
		float ORCA_VOLT_DIV_R =20000.0f;  
		float fTemp;
		fTemp = (float)Math.log(ORCA_VOLT_DIV_R/(4096.0f/(float)u16Count-1));
		fTemp = 1 / (CONST_A + (CONST_B + (CONST_C * fTemp * fTemp ))* fTemp );
		fTemp = fTemp - 273.15f;                     // Convert Kelvin to Celcius
		
		return fTemp;
	}
}
