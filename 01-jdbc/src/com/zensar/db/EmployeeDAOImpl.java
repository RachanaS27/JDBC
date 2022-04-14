package com.zensar.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.zensar.bean.Employee;
import com.zensar.bean.Gender;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public Employee addEmployee(Connection connection, Employee employee) throws Exception {
		PreparedStatement pst = connection.prepareStatement(INSERT_QRY,Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, employee.getName());
		pst.setDouble(2, employee.getBasicSalary());
		pst.setString(3, employee.getGrade()+"");
		pst.setString(4, employee.getCityName());
		
		java.sql.Date sdoj = DateConversion.convertToSQLDate(employee.getDateOfJoin());
		pst.setDate(5, sdoj);
		
		char charGender = employee.getGender().toString().charAt(0);
		pst.setString(6,charGender+"");
		int rowCount = pst.executeUpdate();
		if(rowCount==1){
			ResultSet rs = pst.getGeneratedKeys();
			rs.next();
			int generatedKey = rs.getInt(1);
			employee.setId(generatedKey);
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Connection connection, Employee employee) throws Exception {
		PreparedStatement pst = connection.prepareStatement(UPDATE_QRY);
		pst.setString(1, employee.getName());
		pst.setDouble(2, employee.getBasicSalary());
		pst.setString(3, employee.getGrade()+"");
		pst.setString(4, employee.getCityName());
		
		java.sql.Date sdoj = DateConversion.convertToSQLDate(employee.getDateOfJoin());
		char charGender = employee.getGender().toString().charAt(0);

		pst.setDate(5, sdoj);
		pst.setString(6,charGender+"");
		pst.setInt(7, employee.getId());
		
		pst.executeUpdate();
		return employee;
	}

	@Override
	public boolean removeEmployee(Connection connection, int employeeId) throws Exception {
		boolean result = false;
		PreparedStatement pst = connection.prepareStatement(DELETE_QRY);
		pst.setInt(1, employeeId);
		
		int rowCount = pst.executeUpdate();
		if(rowCount==1){
			result=true;
		}
		return result;
	}

	@Override
	public Employee findEmployee(Connection connection, int employeeId) throws Exception {
		PreparedStatement pst = connection.prepareStatement(FIND_QRY);
		pst.setInt(1, employeeId);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			Employee employee = new Employee();
			employee.setId(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setBasicSalary(rs.getDouble(3));
			employee.setGrade(rs.getString(4).charAt(0));
			employee.setCityName(rs.getString(5));
			
			LocalDate localDate = DateConversion.convertToLocalDate(rs.getDate(6));
			employee.setDateOfJoin(localDate);
			
			char gender = rs.getString(7).charAt(0);
			if(gender=='M')
			{
				employee.setGender(Gender.MALE);
			}
			else
			{
				employee.setGender(Gender.FEMALE);
			}
			return employee;
		}

		return null;
	}

	@Override
	public List<Employee> findAllEmployee(Connection connection) throws Exception {
		List<Employee> allEmployees = new ArrayList<>();
		
		PreparedStatement pst = connection.prepareStatement(FINDALL_QRY);
	
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			Employee employee = new Employee();
			employee.setId(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setBasicSalary(rs.getDouble(3));
			employee.setGrade(rs.getString(4).charAt(0));
			employee.setCityName(rs.getString(5));
			
			LocalDate localDate = DateConversion.convertToLocalDate(rs.getDate(6));
			employee.setDateOfJoin(localDate);
			
			char gender = rs.getString(7).charAt(0);
			if(gender=='M')
			{
				employee.setGender(Gender.MALE);
			}
			else
			{
				employee.setGender(Gender.FEMALE);
			}
			 allEmployees.add(employee);
		}

		return allEmployees;
	}

}
