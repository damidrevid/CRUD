package com.drevid.springboot.CRUDdemo.DAO;

import java.util.List;

import com.drevid.springboot.CRUDdemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int id);
}
