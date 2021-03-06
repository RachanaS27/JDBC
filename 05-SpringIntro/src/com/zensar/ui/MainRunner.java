package com.zensar.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.bean.Circle;
import com.zensar.bean.Shape;
import com.zensar.bean.Square;

public class MainRunner {

	public static void main(String[] args) {

		ApplicationContext context;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Circle c =(Circle)context.getBean("circleBean");
		//c.setRadius(5);
		System.out.println(c.getArea());
		
		Square s =(Square)context.getBean("squareBean");
		//s.setSize(10);
		System.out.println(s.computeArea());
	}

}
