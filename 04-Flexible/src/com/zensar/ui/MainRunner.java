package com.zensar.ui;

import com.zensar.bean.Circle;
import com.zensar.bean.Shape;
import com.zensar.bean.Square;

public class MainRunner {

	public static void main(String[] args) {

		Circle circle = new Circle();
		circle.setRadius(5);
		System.out.println(circle.calculateArea());
		
		Square square = new Square();
		square.setSize(10);
		System.out.println(square.computeArea());
		
		Shape shape = new Circle();
		shape.setSize(5);
		System.out.println(shape.getArea());
		
		Shape shape2 = new Square();
		shape2.setSize(10);
		System.out.println(shape2.getArea());
	
	
	
	
	
	
	}

}
