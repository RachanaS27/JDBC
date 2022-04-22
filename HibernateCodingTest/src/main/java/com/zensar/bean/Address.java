package com.zensar.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	int addressId;
	@Column
	String cityName;
	@Column
	String pinCode;
	

	@OneToOne
	@MapsId
	@JoinColumn(name="employee_id")
	Employee employee;

	public Address() {
		super();
	}

	public Address(String cityName, String pinCode) {
		super();
		this.cityName = cityName;
		this.pinCode = pinCode;
	}

	public Address(int addressId, String cityName, String pinCode) {
		super();
		this.addressId = addressId;
		this.cityName = cityName;
		this.pinCode = pinCode;
	}

	public Address(int addressId) {
		super();
		this.addressId = addressId;
	}

	public Address(int addressId, String cityName, String pinCode, Employee employee) {
		super();
		this.addressId = addressId;
		this.cityName = cityName;
		this.pinCode = pinCode;
		this.employee = employee;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", cityName=" + cityName + ", pinCode=" + pinCode + "]";
	}
	
	
}
