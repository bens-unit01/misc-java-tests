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

	private static void testInputInt() {
		System.out.println("-- test misc");
		Scanner in = new Scanner(System.in);
		try {
			int input = in.nextInt();
			System.out.println("Input OK : " + input);
		} catch (InputMismatchException ex) {

			System.out.println("Bad input ");
		}

	}

	private static void testBufferedReader() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Lecture avec BufferedReader");
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
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

	private static void testInputCR() {
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

	private static void delaySeconds(int delayInSeconds) {

		try {
			TimeUnit.SECONDS.sleep(delayInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
