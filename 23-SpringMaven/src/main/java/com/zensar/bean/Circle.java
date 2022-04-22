package com.zensar.bean;

import javax.annotation.PostConstruct;

public class Circle {

	int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	
	
}
