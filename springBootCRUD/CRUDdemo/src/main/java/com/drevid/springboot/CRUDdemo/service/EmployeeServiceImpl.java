package com.drevid.springboot.CRUDdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drevid.springboot.CRUDdemo.DAO.EmployeeDAO;
import com.drevid.springboot.CRUDdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeDAO thisEmployeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO thatEmployeeDAO) {
		thisEmployeeDAO = thatEmployeeDAO;
	}
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return thisEmployeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return thisEmployeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		thisEmployeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void delebeById(int theId) {
		thisEmployeeDAO.deleteById(theId);
	}

}
