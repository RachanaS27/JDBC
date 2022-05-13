package com.zensar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zensar.bean.Calculator;

public class CalculatorTest {

	Calculator cal;
	@BeforeAll
	public static void init() {
		System.out.println("Class loading");
	}
	
	@AfterAll
	public static void destroy() {
		System.out.println("class unloaded");
	}
	
	
	@BeforeEach
	public void f1() {
		 cal = new Calculator();
		 System.out.println("f1 executes --");
	}
	
	@AfterEach
	public void f2() {
		cal=null;
		System.out.println("f2 executes **");
	}
	
	
	@Test
	public void addTesting1() {
		cal.setNumber1(11);
		cal.setNumber2(23);
		int actualResult= cal.sum();
		int expectedResult=34;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void addTesting2() {
		cal.setNumber1(-11);
		cal.setNumber2(-23);
		int actualResult= cal.sum();	
		int expectedResult=-34;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void addTesting3() {
		cal.setNumber1(11);
		cal.setNumber2(-23);
		int actualResult= cal.sum();
		int expectedResult=-12;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void addTesting4() {
		cal.setNumber1(-11);
		cal.setNumber2(23);
		int actualResult= cal.sum();
		int expectedResult=12;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void multiplyTesting1() {
		cal.setNumber1(10);
		cal.setNumber2(5);
		int actualResult= cal.multiply();		
		int expectedResult=50;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void multiplyTesting2() {
		cal.setNumber1(-10);
		cal.setNumber2(-5);
		int actualResult= cal.multiply();
		int expectedResult=50;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void multiplyTesting3() {
		cal.setNumber1(-10);
		cal.setNumber2(5);
		int actualResult= cal.multiply();
		int expectedResult=-50;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void multiplyTesting4() {
		cal.setNumber1(10);
		cal.setNumber2(-5);
		int actualResult= cal.multiply();
		int expectedResult=-50;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void divideTesting1() {
		cal.setNumber1(10);
		cal.setNumber2(5);
		int actualResult= cal.divide();
		int expectedResult=2;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void divideTesting2() {
		cal.setNumber1(-10);
		cal.setNumber2(5);
		int actualResult= cal.divide();
		int expectedResult=-2;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void divideTesting3() {
		cal.setNumber1(-10);
		cal.setNumber2(-5);
		int actualResult= cal.divide();
		int expectedResult=2;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void divideTesting4() {
		cal.setNumber1(10);
		cal.setNumber2(-5);
		int actualResult= cal.divide();
		int expectedResult=-2;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtractTesting1() {
		cal.setNumber1(11);
		cal.setNumber2(23);
		int actualResult= cal.subtract();
		int expectedResult=-12;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtractTesting2() {
		cal.setNumber1(-11);
		cal.setNumber2(23);
		int actualResult= cal.subtract();
		int expectedResult=-34;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtractTesting3() {
		cal.setNumber1(11);
		cal.setNumber2(-23);
		int actualResult= cal.subtract();
		int expectedResult=34;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtractTesting4() {
		cal.setNumber1(-11);
		cal.setNumber2(23);
		int actualResult= cal.subtract();
		int expectedResult=-34;
		assertEquals(expectedResult, actualResult);
	}
}
