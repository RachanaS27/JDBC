package com.zensar.bean;

import org.springframework.stereotype.Component;

@Component
public class ExamMark {

	int mark1=90;
	int mark2=95;
	int mark3=85;
	
	
	@Override
	public String toString() {
		return "ExamMark [mark1=" + mark1 + ", mark2=" + mark2 + ", mark3=" + mark3 + "]";
	}
	
	
}
