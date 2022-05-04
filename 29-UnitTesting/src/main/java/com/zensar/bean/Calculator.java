package com.zensar.bean;

public class Calculator {

	int number1;
	int number2;

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public int sum() {
		return this.number1 + this.number2;
	}

	public int subtract() {
		return this.number1 - this.number2;
	}

	public int multiply() {
		return this.number1 * this.number2;
	}

	public int divide() {
		return this.number1 / this.number2;
	}
}
