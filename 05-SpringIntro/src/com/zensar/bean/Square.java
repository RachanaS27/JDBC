package com.zensar.bean;

public class Square implements Shape{

	int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public double computeArea(){
		return this.size*this.size;
	}

	@Override
	public double getArea() {
		return this.computeArea();
	}
}
