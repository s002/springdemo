package com.luv2code.springboot.demo.springdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.demo.springdemo.dao.EmployeeRepository;

import com.luv2code.springboot.demo.springdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
  private EmployeeRepository employeeRepository;

@Autowired
public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository) {
	
	employeeRepository = theEmployeeRepository;	
}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		java.util.Optional<Employee> Result = employeeRepository.findById(theId);
        Employee theEmployee= null;
        
        if(Result.isPresent()) {
			theEmployee = Result.get();
        }
        else {
       	 // did not find the company
       	 throw new RuntimeException("Did not fimd employee id______" + theId);
       	 		
        }
       return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);

	}

}
