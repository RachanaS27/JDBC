package com.zensar.ui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.zensar.bean.Address;
import com.zensar.bean.Student;
import com.zensar.util.HibernateUtil;

public class MainRunner {

	public static void demo1() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();
		
		Address address = new Address();
		address.setDoorNo("F-4");
		address.setAreaName("Jayanagar");
		address.setCityName("Bangalore");
		
		Student student = new Student();
		student.setName("Shivani");
		student.setAddress(address);
		
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		
		HibernateUtil.cleanUp();
	}

	public static void demo2() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();
		Student student = null;
		student= session.load(Student.class, 1);
		System.out.println(student);
		HibernateUtil.cleanUp();
	}

	public static void demo3() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Student student = null;

		student = session.load(Student.class, 2);
		Address address = new Address();
		address.setDoorNo("F-1");
		address.setAreaName("BDA");
		address.setCityName("Bangalore");
		
		//student.setName("Raksha");
		student.setAddress(address);

		Transaction tx = session.beginTransaction();
		tx.commit();
		System.out.println(student);
		HibernateUtil.cleanUp();
	}

	public static void demo4() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();


		String str = "from Student";

		Query<Student> query = session.createQuery(str);
		List<Student> allStudents = query.list();
		System.out.println(allStudents);
		HibernateUtil.cleanUp();
	}

	public static void demo5() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Student student = null;

		student = session.load(Student.class, 3);
		session.delete(student);

		Transaction tx = session.beginTransaction();
		tx.commit();
		System.out.println(student);
		HibernateUtil.cleanUp();
	}

	public static void main(String[] args) {

		//demo1();
		//demo2();
		//demo3();
		demo4();
		//demo5();

	}

}
