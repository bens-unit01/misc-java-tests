package com.pratiques.factory;

public class ShapeFactory {


	public static Shape getShape(String shape) {

		if(shape.equalsIgnoreCase("circle")){
	 		return new Circle(); 	
		} else if(shape.equalsIgnoreCase("square")){
			return new Square();  
		} else if(shape.equalsIgnoreCase("rectangle")){
			return new Rectangle();  	
		} else return null; 

	} 
}
