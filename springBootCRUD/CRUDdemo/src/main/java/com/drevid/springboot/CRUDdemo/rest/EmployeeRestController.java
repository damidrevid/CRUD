package com.drevid.springboot.CRUDdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.drevid.springboot.CRUDdemo.DAO.EmployeeDAO;
import com.drevid.springboot.CRUDdemo.entity.Employee;
import com.drevid.springboot.CRUDdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// the field
	private EmployeeService realEmployee;
	
	// Inject Employee DAO
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		realEmployee = theEmployeeService;
	}
	
	
	//Expose "/Employees" and return list of employee
	@GetMapping
	public List<Employee> findAll(){
		return realEmployee.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getById(@PathVariable int employeeId) {
		
		Employee theEmployee = realEmployee.findById(employeeId);
			
			if (theEmployee == null ) {
				throw new RuntimeException ("Employee Id not found - " + employeeId); 
			}
			return theEmployee;
			
		}
	
	// Save an employee using PostMapping
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		realEmployee.save(theEmployee);
		
		return theEmployee;		
	}
	
	// Update an employee using 
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		realEmployee.save(theEmployee);
		
		return theEmployee;
	}
	
	//Delete Employee by Id using DELETE Mapping
	@DeleteMapping("employees/{employeeId}")
	public String delEmployee(@PathVariable int theId) {
		// First, find out if employee exist
		Employee temp_employ = realEmployee.findById(theId);
		
		//throw as exception if it doesn't
		if (temp_employ == null) {
			throw new RuntimeException ("The employee Id: " + theId + " is invalid");
			}
		realEmployee.delebeById(theId);
		
		return "The Id " + theId + " has been deleted";
	}
		
		
}

