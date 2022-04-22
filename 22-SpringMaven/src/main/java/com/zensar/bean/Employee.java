package com.zensar.bean;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int id=101;
	private String name="Rachana";
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}
