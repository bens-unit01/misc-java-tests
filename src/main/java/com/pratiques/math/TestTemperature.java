package com.pratiques.math;

public class TestTemperature {
	public static void run() {
		System.out.println(" input:1 " + convertCountToCelsiusTempAnalogic(-11)); 
		System.out.println(" input:2 " + convertCountToCelsiusTempAnalogic(2)); 
		System.out.println(" input:3 " + convertCountToCelsiusTempAnalogic(3)); 
		System.out.println(" input:70 " + convertCountToCelsiusTempAnalogic(70)); 
		System.out.println(" input:71 " + convertCountToCelsiusTempAnalogic(71)); 
		System.out.println(" input:72 " + convertCountToCelsiusTempAnalogic(72)); 
		System.out.println(" input:2369 " + convertCountToCelsiusTempAnalogic(2385)); 
		System.out.println(" input:1958 " + convertCountToCelsiusTempAnalogic(1958)); 
		System.out.println(" input:1548 " + convertCountToCelsiusTempAnalogic(1548)); 
		System.out.println(" input:1170 " + convertCountToCelsiusTempAnalogic(1170)); 
		System.out.println(" --------------------------          " ); 

		System.out.println(" input:-30 " + convertCelsiusTempToCountAnalogic(-30)); 
		System.out.println(" input:55 " + convertCelsiusTempToCountAnalogic(55)); 
		System.out.println(" input:56 " + convertCelsiusTempToCountAnalogic(56)); 
		System.out.println(" input:57 " + convertCelsiusTempToCountAnalogic(57)); 
		System.out.println(" input:58 " + convertCelsiusTempToCountAnalogic(58)); 
		System.out.println(" input:59 " + convertCelsiusTempToCountAnalogic(59)); 
		System.out.println(" input:0 " + convertCelsiusTempToCountAnalogic(0)); 
		System.out.println(" input:10 " + convertCelsiusTempToCountAnalogic(10)); 
		System.out.println(" input:20 " + convertCelsiusTempToCountAnalogic(20)); 
		System.out.println(" input:30 " + convertCelsiusTempToCountAnalogic(30)); 
		System.out.println(" input:40000 " + convertCelsiusTempToCountAnalogic(40000)); 
		System.out.println(" input:60000 " + convertCelsiusTempToCountAnalogic(60000)); 
		System.out.println(" input:3600" + convertCelsiusTempToCountAnalogic(3600)); 

		}

	public static int convertCelsiusTempToCountAnalogic(int temperature)
	{
		double count = 0.0f;
		
		count  = (-41.052 * temperature)+2369.1;
		
		return ((int)count);
	}
	
	
	public static float convertCountToCelsiusTempAnalogic(int u16Count)
	{
		/*double temperature = 0.0f;
		temperature  = (-0.0244 * count)+57.7;
		temperature = roundToHalf((float) temperature);

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
