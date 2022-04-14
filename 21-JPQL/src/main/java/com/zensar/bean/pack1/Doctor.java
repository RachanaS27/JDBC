package com.zensar.bean.pack1;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="doctor10")

@NamedQueries({
		@NamedQuery(name="findAll", query = "select d from Doctor d"),
		@NamedQuery(name="findById", query = "select d from Doctor d where d.id=:did"),
		@NamedQuery(name="findByFee", query = "select d from Doctor d where d.fee between :a and :b")

})

@NamedNativeQueries({
	@NamedNativeQuery(name = "readAll", query = "select * from doctor10",resultClass=Doctor.class),
	@NamedNativeQuery(name = "readById", query = "select * from doctor10 where id=?",resultClass=Doctor.class),
	@NamedNativeQuery(name = "readByFee", query = "select * from doctor10 where fee between ? and ?",resultClass=Doctor.class),

})

public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	double fee;
	String gender;
	LocalDate practicingSince;
	public Doctor() {
		super();
	}
	public Doctor(String name, double fee, String gender, LocalDate practicingSince) {
		super();
		this.name = name;
		this.fee = fee;
		this.gender = gender;
		this.practicingSince = practicingSince;
	}
	public Doctor(int id, String name, double fee, String gender, LocalDate practicingSince) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
		this.gender = gender;
		this.practicingSince = practicingSince;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getPracticingSince() {
		return practicingSince;
	}
	public void setPracticingSince(LocalDate practicingSince) {
		this.practicingSince = practicingSince;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", fee=" + fee + ", gender=" + gender + ", practicingSince="
				+ practicingSince + "]";
	}
	
	
}
