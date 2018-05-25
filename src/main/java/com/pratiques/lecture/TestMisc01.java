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

		// testInputInt();
		// testInputCR();
		testBufferedReader();
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

			while (run) {

				input = br.readLine();
				System.out.println("ignored: " + input);
			}
			
			// we read the right stuff here 
			System.out.println("Enter the right stuff");
			String s = br.readLine();
			System.out.println("The right stuff is: " + s);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void solution03() {
		System.out.println("Enter some ignored stuff ");
		Scanner in = new Scanner(System.in);
		delaySeconds(5);
		run = true;
		new Thread(() -> {
			while (in.hasNextLine() && run) {
				String s = in.nextLine();
				System.out.println("--" + s);
			}

			System.out.println("####--");
		}).start();
		delaySeconds(3);
		run = false;
		delaySeconds(2);
		in.close();
		System.out.println("press enter ...");
		Scanner in2 = new Scanner(System.in);
		String s = in2.nextLine();
		System.out.println("Configuration de l\'APN, veuillez patienter ...");

	}

	public static void delaySeconds(int delayInSeconds) {

		try {
			TimeUnit.SECONDS.sleep(delayInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
