package com.pratiques.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThreads01 {

	public static void run() {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		SecondaryTask t = new SecondaryTask();

		for (int i = 0; i < 30; i++) {
			executorService.submit(() -> t.task01());
			executorService.submit(() -> t.task02());
			System.out.println("---- i " + i);
		}

		try {
			executorService.shutdown();
			executorService.awaitTermination(60, TimeUnit.SECONDS);
			System.out.println("main task ...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void run1() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Counter counter = new Counter();

		for (int i = 0; i < 1000; i++) {
			executorService.submit(() -> counter.increment());
		}

		executorService.shutdown();
		try {
			executorService.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final count is : " + counter.getCount());
	}
}
