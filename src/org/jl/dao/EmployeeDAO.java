package org.jl.dao;

import org.jl.to.EmployeeTo;
import java.util.List;

public interface EmployeeDAO {

	
	public EmployeeTo isValidUser(String fname,String lname);
	public List getAllEmployees();
	public void deleteEmployee(int id);
	public void addEmployee(EmployeeTo emp);
	public EmployeeTo getEmployee(int id);
	public void updateEmployee(EmployeeTo emp);
	public EmployeeTo emailAlreadyExists(EmployeeTo emp);
	public List getJobIds(String jobId);
}
