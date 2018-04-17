package com.pratiques.regex;


public class TestRegex01{


	public static void run() {
	
	
         String s = "humbapumpa jim";
         System.out.println("1- " +s.matches(".*(jim|joe).*"));  
         s = "hummarsim";
         System.out.println("2- " +s.matches(".*(jim|joe|mars).*"));  
         s = "1hum joellll";
         System.out.println("3- " +s.matches("^\\d+"));  
         System.out.println("4- " +s.matches("^\\d+.*"));  
         s = "bens@yahoo.fr";
         System.out.println("5- " +s.matches("\\w+@\\w+\\.\\w{1,3}"));  
	 

	} 

}
