package com.zensar.bean.pack1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject1")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int subjectId;
	
	String subjectName;
	
	int durationInHours;

	public Subject() {
		super();
	}

	public Subject(int subjectId) {
		super();
		this.subjectId = subjectId;
	}

	public Subject(String subjectName, int durationInHours) {
		super();
		this.subjectName = subjectName;
		this.durationInHours = durationInHours;
	}

	public Subject(int subjectId, String subjectName, int durationInHours) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.durationInHours = durationInHours;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(subjectName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(subjectName, other.subjectName);
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", durationInHours="
				+ durationInHours + "]";
	}
	
	
}
