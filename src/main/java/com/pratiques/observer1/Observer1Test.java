package com.pratiques.observer1;

import java.util.Observable;
import java.util.Observer;

public class Observer1Test {

	
	public static void run() {
		
		System.out.println("Observer1 test - Enter Text: ");
        EventSource eventSource = new EventSource();

        eventSource.addObserver(new Observer() {
            public void update(Observable obj, Object arg) {
                System.out.println("Received response: " + arg);
            }
        });

        new Thread(eventSource).start();	
	}
}
