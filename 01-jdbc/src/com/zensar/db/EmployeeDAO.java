package com.zensar.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zensar.bean.Employee;

public interface EmployeeDAO {

	String INSERT_QRY="insert into Temployee(empName,basic,grade,cityName,doj,gender) values(?,?,?,?,?,?)";
	String UPDATE_QRY="update Temployee set empName=?, basic=?, grade=?, cityName=?, doj=?, gender=? where id=?";
	String DELETE_QRY="delete from Temployee where id = ?";
	String FIND_QRY="select * from Temployee where id = ?";
	String FINDALL_QRY="select * from Temployee";

	Employee addEmployee(Connection connection,Employee employee) throws Exception;
	Employee updateEmployee(Connection connection,Employee employee) throws Exception;
	boolean removeEmployee(Connection connection,int employeeId) throws Exception;
	Employee findEmployee(Connection connection,int employeeId) throws Exception;
	List<Employee> findAllEmployee(Connection connection) throws Exception;

}
