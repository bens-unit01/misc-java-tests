package com.pratiques.observer2;

public class ConcreteObserverA implements Observer {

  @Override
  public void update(Object arg) {
   System.out.println(" ConcreteObserverA " + arg); 	  
  }

}
