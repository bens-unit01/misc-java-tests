package com.pratiques.date;

import java.util.concurrent.TimeUnit;

public class TimeHelper {

	public static void delaySeconds(int delayInSeconds) {

		try {
			TimeUnit.SECONDS.sleep(delayInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void delayMilliseconds(int delayInSeconds) {

		try {
			TimeUnit.MILLISECONDS.sleep(delayInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
