package com.pratiques.lecture;

import java.io.Console; 

public class TestConsole {

	
	public static void run() {
		
	System.out.println(" Lecture avec Console"); 
	
	new Thread(new Runnable() {
		
		@Override
		public void run() {
	
			 String input = System.console().readLine(); 
			 System.out.println(" Input: " + input); 
			 
		}
	}).start(); 
	} 
}
