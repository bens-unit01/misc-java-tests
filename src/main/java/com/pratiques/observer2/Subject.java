package com.pratiques.observer2;

import java.util.List;
import java.util.ArrayList; 
public class Subject {

	
	private List<Observer> observerCollection; 
	
	public Subject() {
	  observerCollection = new ArrayList<Observer>(); 
	}
	
	public void registerObserver(Observer obs) {
	   observerCollection.add(obs); 	
	}
	
	public void notifyObservers(Object arg) {
	
	   for(Observer obs:observerCollection) {
		  obs.update(arg); 
	   }	
	} 
}
