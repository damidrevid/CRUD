package com.drevid.springboot.CRUDdemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.drevid.springboot.CRUDdemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define entity manage
	private EntityManager entityManager;
	
	// Constructor injection
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	// @Transactional - We only use the @Transactional if we are not creating  Service
	public List<Employee> findAll() {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//run query and get result list
		List<Employee> employee = theQuery.getResultList();
		
		//return result
		return employee;
	}

	@Override
	public Employee findById(int id) {
		//Get Session
		Session thisSession = entityManager.unwrap(Session.class);
		
		// Get Employee by Id
		Employee thisEmployee = thisSession.get(Employee.class, id);
		
		// Return result
		return thisEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// Get Session
		Session thisSession = entityManager.unwrap(Session.class);
		
		// Save 
		thisSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// Get Session
		Session thisSession = entityManager.unwrap(Session.class);
		
		// Delete Id
		Query theQuery = thisSession.createQuery("Delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
				
		
	}

}
