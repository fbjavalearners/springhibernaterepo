package org.jl.service;

import java.util.List;

import org.jl.dao.EmployeeDAO;
import org.jl.to.EmployeeTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmployeeSerImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;
	
	@Override
	public EmployeeTo isValidUser(String fname, String lname) {
		
		return empDAO.isValidUser(fname,lname);
		
	}

	@Override
	public List getAllEmployees() {
		// TODO Auto-generated method stub
		return empDAO.getAllEmployees();
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empDAO.deleteEmployee(id);
		
	}

	@Override
	public void addEmployee(EmployeeTo emp) {
		// TODO Auto-generated method stub
		empDAO.addEmployee(emp);
		
	}

	@Override
	public EmployeeTo getEmployee(int id) {
		// TODO Auto-generated method stub
		return empDAO.getEmployee(id);
	}

	@Override
	public void editEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(EmployeeTo emp) {
		// TODO Auto-generated method stub
		empDAO.updateEmployee(emp);
		
	}

	@Override
	public EmployeeTo emailAlreadyExists(EmployeeTo emp) {
		// TODO Auto-generated method stub
		return empDAO.emailAlreadyExists(emp);
	}

	@Override
	public List getJobIds(String name) {
		// TODO Auto-generated method stub
		return empDAO.getJobIds(name);
	}

}
