package com.zensar.ui;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.zensar.bean.Employee;
import com.zensar.util.HibernateUtil;

public class MainRunner {

	static void demo1() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Employee employee = new Employee();
		employee.setName("Pooja");
		employee.setDateOfJoin(LocalDate.of(2020, 05, 01));
		employee.setBasic(45000);
		employee.setGrade('A');

		Transaction tx = session.beginTransaction();

		session.save(employee);
		tx.commit();
		HibernateUtil.cleanUp();
	}

	static void demo2() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Employee employee = null;

		employee = session.load(Employee.class, 1);
		System.out.println(employee);

		
		HibernateUtil.cleanUp();
	}

	static void demo3() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Employee employee = null;

		employee = session.load(Employee.class, 1);
		employee.setBasic(55000);

		Transaction tx = session.beginTransaction();
		tx.commit();
		System.out.println(employee);

		HibernateUtil.cleanUp();
	}

	static void demo4() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		String str = "from Employee";

		Query<Employee> query = session.createQuery(str);
		List<Employee> allEmployess = query.list();
		System.out.println(allEmployess);

		HibernateUtil.cleanUp();
	}

	static void demo5() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Employee employee = null;

		employee = session.load(Employee.class, 3);
		session.delete(employee);

		Transaction tx = session.beginTransaction();
		tx.commit();
		System.out.println(employee);

		HibernateUtil.cleanUp();
	}

	public static void main(String[] args) {

		 demo1();
		// demo2();
		 //demo3();
		 //demo4();
		//demo5();

	}

}
