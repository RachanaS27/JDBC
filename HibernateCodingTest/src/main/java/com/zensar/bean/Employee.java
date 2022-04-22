package com.zensar.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int employeeId;
	@Column
	String name;
	@Column
	double basicSalary;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JoinColumn(name="address_Id",referencedColumnName = "addressId")
	Address address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="skill_Id",referencedColumnName = "skillName")
	List<Skill> skillList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bank_Id",referencedColumnName = "bankId")
	BankAccount bankAccount;
	
	public Employee() {
		super();
	}
	
	

	public Employee(int employeeId, String name, double basicSalary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.basicSalary = basicSalary;
	}



	public Employee(String name, double basicSalary, Address address, List<Skill> skillList, BankAccount bankAccount) {
		super();
		this.name = name;
		this.basicSalary = basicSalary;
		this.address = address;
		this.skillList = skillList;
		this.bankAccount = bankAccount;
	}

	public Employee(String name, double basicSalary) {
		super();
		this.name = name;
		this.basicSalary = basicSalary;
	}

	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public Employee(int employeeId, String name, double basicSalary, Address address, List<Skill> skillList,
			BankAccount bankAccount) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.basicSalary = basicSalary;
		this.address = address;
		this.skillList = skillList;
		this.bankAccount = bankAccount;
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

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", basicSalary=" + basicSalary + ", address="
				+ address + ", skillList=" + skillList + ", bankAccount=" + bankAccount + "]";
	}
	
	
}
