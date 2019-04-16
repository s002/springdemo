package com.luv2code.springboot.demo.springdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.springboot.demo.springdemo.entity.Employee;

import com.luv2code.springboot.demo.springdemo.service.EmployeeService;
import com.luv2code.springboot.demo.springdemo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
@Autowired
public EmployeeController(EmployeeServiceImpl theEmployeeService) {
	employeeService = theEmployeeService;
	
}
@GetMapping("/employees")
public List<Employee> findAll()
{
	return employeeService.findAll();

}


@GetMapping("/employees/{employeeId}")

public Employee getEmployee(@PathVariable int employeeId) {
	
	Employee theEmployee = employeeService.findById(employeeId);

	if (theEmployee==null) {
		
		throw new RuntimeException("EmployeeId is not found __________"+ employeeId);
		
	}
	
	return theEmployee;

}


@PostMapping("/employees")

public Employee addEmployee(@RequestBody Employee theEmployee) {
	
	// if the usr pass an Id of 0 in the Json format , set the Id =0
	// else if save it as update of the Id
	
//	theTeam.setName("");
	employeeService.save(theEmployee);

	return theEmployee;

}


@PutMapping("/employees")

public Employee updateEmployee(@RequestBody Employee theEmployee) {
	
	employeeService.save(theEmployee);
	
	return theEmployee;
}

@DeleteMapping("/employees/{employeeId}")

public int deleteTeam(@PathVariable int employeeId) {


Employee tempEmployee = employeeService.findById(employeeId);

      if(tempEmployee == null) {
    	  throw new RuntimeException("Employee not found in the database -------"+ employeeId);
      }
	employeeService.deleteById(employeeId);
	
	return employeeId;
}



}



