package com.zensar.bean.pack1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	@Column
	private String doorNo;
	@Column
	private String areaName;
	@Column
	private String cityName;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name="employee_id")
	private Employee employee;


	public Address() {
		super();
	}


	public Address(String doorNo, String areaName, String cityName, Employee employee) {
		super();
		this.doorNo = doorNo;
		this.areaName = areaName;
		this.cityName = cityName;
		this.employee = employee;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getDoorNo() {
		return doorNo;
	}


	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", doorNo=" + doorNo + ", areaName=" + areaName + ", cityName="
				+ cityName + "]";
	}
	
	
}
