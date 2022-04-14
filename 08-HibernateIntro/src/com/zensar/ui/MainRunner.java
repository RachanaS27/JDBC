package com.zensar.ui;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zensar.bean.Person;
import com.zensar.util.HibernateUtil;

public class MainRunner {

	static void demo1(){
		HibernateUtil.init();
		Session session= HibernateUtil.getSession();
        Person person = new Person();
        person.setId(2);
        person.setName("Manish");
        person.setSalary(35000);
        
        Transaction tx= session.beginTransaction();
        
        session.save(person);
        tx.commit();
        HibernateUtil.cleanUp();
	}
	
	static void demo2(){
		HibernateUtil.init();
		Session session= HibernateUtil.getSession();
        
        Person person = null;

        person= session.load(Person.class, 3);
        System.out.println(person);
               
        HibernateUtil.cleanUp();
	}
	
	static void demo3(){
		HibernateUtil.init();
		Session session= HibernateUtil.getSession();
        
        Person person = null;

        person= session.load(Person.class, 1);
        person.setSalary(40000);
        
        Transaction tx = session.beginTransaction();
        tx.commit();
        System.out.println(person);
               
        HibernateUtil.cleanUp();
	}
	
	static void demo4(){
		HibernateUtil.init();
		Session session= HibernateUtil.getSession();
        
        String str = "from Person";
        
        Query<Person> query = session.createQuery(str);
        List<Person> allPersons = query.list();
        System.out.println(allPersons);
               
        HibernateUtil.cleanUp();
	}
	
	static void demo5(){
		HibernateUtil.init();
		Session session= HibernateUtil.getSession();
        
        Person person = null;

        person= session.load(Person.class, 4);
        session.delete(person);
        
        
        Transaction tx = session.beginTransaction();
        tx.commit();
        System.out.println(person);
               
        HibernateUtil.cleanUp();
	}
	
	
	public static void main(String[] args) {
		
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
	}

}
