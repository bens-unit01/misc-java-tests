package com.pratiques.lecture;

import java.util.Scanner;

public class TestScanner {
	
	public static void run() {
		
	Scanner sc = new Scanner(System.in); 
    System.out.println("Lecture avec Scanner"); 	
	new Thread(new Runnable() {
		
		@Override
		public void run() {
		    while(true) {
		      String input = sc.next(); 	
		      System.out.println("input: " + input); 
		    	
		    }	
		}
	}).start();
		
	}

}
