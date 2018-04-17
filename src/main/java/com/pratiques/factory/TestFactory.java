package com.pratiques.factory;


public class TestFactory {


	public static void run() {
	
	
 	Shape shape1 = ShapeFactory.getShape("circle");  	
 	Shape shape2 = ShapeFactory.getShape("rectangle");  	
 	Shape shape3 = ShapeFactory.getShape("square");  	
  
 	   shape1.draw(); 	
 	   shape2.draw(); 	
 	   shape3.draw(); 	
	} 

}
