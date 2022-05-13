package com.zensar.bean;

public class PrimeNumberDecider {

	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public  boolean isPrimeNumber() {
		if(number<=0|| number==1) {
			return false;
		}else {
			for(int i=2;i<number;i++) {
				if(number%i==0) {
					return false;
				}
			}
		}
		return true;
	}
}
