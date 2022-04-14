package com.zensar.bean.pack1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course1")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int courseId;
	String courseName;
	double fee;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="course1_subject1",
	joinColumns=@JoinColumn(name="course_id"),
	inverseJoinColumns=@JoinColumn(name="subjet_id"))
	Set<Subject> subjects;
	
	private void init() {
		if(this.subjects==null) {
			this.subjects=new HashSet<Subject>();
		}
	}

	public Course() {
		super();
		init();
	}
	
	

	public Course(int courseId) {
		super();
		this.courseId = courseId;
		init();
	}

	public Course(String courseName, double fee) {
		super();
		this.courseName = courseName;
		this.fee = fee;
		init();
	}

	public Course(String courseName, double fee, Set<Subject> subjects) {
		super();
		this.courseName = courseName;
		this.fee = fee;
		this.subjects = subjects;
		init();
	}

	public Course(int courseId, String courseName, double fee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fee = fee;
		init();
	}

	public Course(int courseId, String courseName, double fee, Set<Subject> subjects) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fee = fee;
		this.subjects = subjects;
		init();
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public boolean addSubject(Subject subject) {
		return this.subjects.add(subject);
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", fee=" + fee + ",\n subjects=" + subjects
				+ "]";
	}
	
	
	
}
