package com.zensar.service;


import java.util.List;

import com.zensar.bean.Employee;

public interface EmployeeService {


	Employee addEmployee(Employee employee) throws Exception;
	Employee updateEmployee(Employee employee) throws Exception;
	boolean removeEmployee(int employeeId) throws Exception;
	Employee findEmployee(int employeeId) throws Exception;
	List<Employee> findAllEmployee() throws Exception;

}
