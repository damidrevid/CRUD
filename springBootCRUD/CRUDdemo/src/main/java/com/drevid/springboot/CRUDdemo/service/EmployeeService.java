package com.drevid.springboot.CRUDdemo.service;

import java.util.List;

import com.drevid.springboot.CRUDdemo.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void delebeById(int theId);
}
