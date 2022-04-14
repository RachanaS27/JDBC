package com.zensar.bean.pack1;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Employee {

	@Id
	private int employeeId;
	@Column
	private String name;
	@Column
	private double salary;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;

	public Employee() {
		super();
	}

	public Employee(String name, double salary, Address address) {
		super();
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public Employee(int employeeId, String name, double salary, Address address) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", address=" + address
				+ "]";
	}
	
	
}
