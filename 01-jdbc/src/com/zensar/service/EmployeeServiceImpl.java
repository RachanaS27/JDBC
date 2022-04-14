package com.zensar.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zensar.bean.Employee;
import com.zensar.db.ConnectionManager;
import com.zensar.db.EmployeeDAO;
import com.zensar.db.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{

	
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	@Override
	public Employee addEmployee(Employee employee) throws Exception {
		Connection connection = new ConnectionManager().create();
		return 	employeeDAO.addEmployee(connection, employee);

	}

	@Override
	public Employee updateEmployee(Employee employee) throws Exception {
		Connection connection = new ConnectionManager().create();
		return employeeDAO.updateEmployee(connection, employee);
	}

	@Override
	public boolean removeEmployee(int employeeId) throws Exception {
		Connection connection = new ConnectionManager().create();
		return employeeDAO.removeEmployee(connection, employeeId);
	}

	@Override
	public Employee findEmployee(int employeeId) throws Exception {
		Connection connection = new ConnectionManager().create();
		return employeeDAO.findEmployee(connection, employeeId);
	}

	@Override
	public List<Employee> findAllEmployee() throws Exception {
		Connection connection = new ConnectionManager().create();
		return employeeDAO.findAllEmployee(connection);
	}

}
