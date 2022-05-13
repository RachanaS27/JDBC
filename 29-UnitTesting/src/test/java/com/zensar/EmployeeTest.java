package com.zensar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zensar.bean.Employee;
import com.zensar.bean.InvalidSalaryException;

public class EmployeeTest {

	Employee employee;
	
	@BeforeEach
	public void init() {
		this.employee=new Employee(); 
	}
	
	@Test
	public void test1() {
		Exception ex = assertThrows(InvalidSalaryException.class,()->this.employee.setBasicSalary(-1000));
		assertEquals("Salary cannot be negative", ex.getMessage());
	}
	
	@Test
	public void computeAllowanceTest1() throws InvalidSalaryException {
		employee.setBasicSalary(1000);
		double actualResult=employee.computeAllowance();
		double expectedResult=200.00;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void computeAllowanceTest2() throws InvalidSalaryException {
		employee.setBasicSalary(0);
		double actualResult=employee.computeAllowance();
		double expectedResult=0.00;
		assertEquals(expectedResult, actualResult);
	}
	

	
	
}
