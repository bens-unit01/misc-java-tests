package com.pratiques.observer2;

import java.util.Scanner; 
public class Observer2Test {

	public static void run() {
	
	ConcreteObserverA  observerA = new ConcreteObserverA(); 
	Subject subject = new Subject(); 
	
    subject.registerObserver(observerA);	
	
	System.out.println("Observer2 test - Enter Text: "); 	
	Thread readingThread = new Thread(new Runnable() {
		
		@Override
		public void run() {
		  while(true) {
			 String response = new Scanner(System.in).next();
			 subject.notifyObservers(response);
		  }	
		}
	}); 
	
	readingThread.start(); 

	}
}
