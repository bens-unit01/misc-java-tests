package com.pratiques.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestMisc01 {

	private static boolean run;

	public static void run() {

		 //solution01();
		 //solution02();
		 //solution03();
		 //solution04();
		 solution05();
	}

	private static void solution01() {
		System.out.println("-- test misc");
		Scanner in = new Scanner(System.in);
		try {
			int input = in.nextInt();
			System.out.println("Input OK : " + input);
		} catch (InputMismatchException ex) {

			System.out.println("Bad input ");
		}

	}

	private static void solution02() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Lecture avec BufferedReader");
		try {
			System.out.println("Enter ignored stuff");
			delaySeconds(5);
			run = true;
            String input = " "; 

            // we give 2 sec to the next loop to flush the input 
			new Thread(() -> {
				delaySeconds(2);
				run = false;
			}).start();

			System.out.println("Enter the right stuff");
			while (run) {
				System.out.println("ignored: " + input);
				input = br.readLine();
			}
			
			System.out.println("The right stuff is: " + input);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void solution03() {
		System.out.println("Enter some ignored stuff ");
		Scanner in = new Scanner(System.in);
		delaySeconds(5);
		run = true;

            // we give 2 sec to the next loop to flush the input 
			new Thread(() -> {
				delaySeconds(2);
				run = false;
			}).start();


		System.out.println("Enter the right stuff here ...");

		//loop to flush the old inputs  
			while (in.hasNextLine() && run) {
				String s = in.nextLine();
				System.out.println("ignored: " + s);
			}

		String s = in.nextLine();
		System.out.println("Right stuff: " + s); 

	}
	
	private static void solution04() {
		System.out.println("Enter some ignored stuff ");
		Scanner in = new Scanner(System.in);
		delaySeconds(5);
		run = true;

            // we give 2 sec to the next loop to flush the input 


		//loop to flush the old inputs  
			while (in.hasNextLine() && in.hasNext()) {
				String s = in.nextLine();
				System.out.println("ignored: " + s);
			}

		System.out.println("Enter the right stuff here ...");
		String s = in.nextLine();
		System.out.println("Right stuff: \'" + s  + " \'"); 

	}
	

	public static void delaySeconds(int delayInSeconds) {

		try {
			TimeUnit.SECONDS.sleep(delayInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	 private static String prompt(String prompt) {

	        try {
	            int a = 0;
	            if((a = System.in.available()) > 0) {
	                System.in.read(new byte[a]);
	            }
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        System.out.println(prompt);
	        Scanner scanner = new Scanner(System.in);
	        String username = scanner.nextLine();
	        return username;

	    }

	

	    private static void solution05() {

	        String ignored = prompt("Ignore this: ");
	        delaySeconds(8);
	        System.out.println(ignored);
	        System.out.println("I ignored all of the above\n\n\n");

	        String good = prompt("Enter the right stuff here ...");
	        System.out.println(good);

	    }
	
	
}
