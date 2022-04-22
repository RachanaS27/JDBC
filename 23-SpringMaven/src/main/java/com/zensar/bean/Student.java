package com.zensar.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {

	int rollNo;
	String name;
	
	@Autowired
	ExamMark examMark;

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", examMark=" + examMark + "]";
	}

	
	
	
}
