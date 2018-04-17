package com.pratiques.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBufferedReader {

	
	
	public static void run() {
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
        System.out.println("Lecture avec BufferedReader"); 	
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
		         try {
					String input = br.readLine();
                    System.out.println("input : " + input); 	
				} catch (IOException e) {
					e.printStackTrace();
				} 	
				}
				
			}
		}).start(); 
	} 
}
