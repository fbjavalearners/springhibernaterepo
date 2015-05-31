package org.jl.service;

import java.util.List;

import org.jl.to.EmployeeTo;

public interface EmployeeService {

	public EmployeeTo isValidUser(String fname,String lname);
	public List<EmployeeTo> getAllEmployees();
	public void deleteEmployee(int id );
	public void addEmployee(EmployeeTo emp);
	public EmployeeTo getEmployee(int id);
	public void editEmployee(int id);
	public void updateEmployee(EmployeeTo emp);
	public EmployeeTo emailAlreadyExists(EmployeeTo email);
	public List getJobIds(String name);
}
