package com.zensar.bean;

public class Student {

	String name;
	int mark1;
	int mark2;
	int mark3;

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if (name.length() < 5) {
			Exception e = new Exception("Name too short");
			throw e;
		}
		this.name = name;
	}

	public int getMark1() {
		return mark1;
	}

	public void setMark1(int mark1) throws Exception {
		if (mark1 < 0 | mark1 > 100) {
			Exception e = new Exception("Marks should lie between 0 and 100");
			throw e;
		}
		this.mark1 = mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public void setMark2(int mark2) throws Exception {
		if (mark2 < 0 | mark2 > 100) {
			Exception e = new Exception("Marks should lie between 0 and 100");
			throw e;
		}
		this.mark2 = mark2;
	}

	public int getMark3() {
		return mark3;
	}

	public void setMark3(int mark3) throws Exception {
		if (mark3 < 0 | mark3 > 100) {
			Exception e = new Exception("Marks should lie between 0 and 100");
			throw e;
		}
		this.mark3 = mark3;
	}

	public int computeTotal() {
		return this.mark1 + this.mark2 + this.mark3;
	}

}
