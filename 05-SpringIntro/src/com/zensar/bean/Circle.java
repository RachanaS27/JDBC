package com.zensar.bean;

public class Circle implements Shape{
	int radius;
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double calculateArea(){
		return 3.142*radius*radius;
	}

	@Override
	public void setSize(int size) {
		this.setRadius(size);
	}

	@Override
	public double getArea() {
		return this.calculateArea();
	}
}
