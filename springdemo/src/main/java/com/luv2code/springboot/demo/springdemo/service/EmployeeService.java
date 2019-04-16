package com.luv2code.springboot.demo.springdemo.service;

import java.util.List;

import com.luv2code.springboot.demo.springdemo.entity.Employee;

public interface EmployeeService {
	
public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save (Employee theEmployee);
	
	public void deleteById(int theId);
	

}
