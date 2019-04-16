package com.luv2code.springboot.demo.springdemo.service;

import java.util.List;


import com.luv2code.springboot.demo.springdemo.entity.Department;

public interface DepartmentService {

public List<Department> findAll1();
	
	public Department findById1(int Id);
	
	public void save1 (Department theDepartment);
	
	public void deleteById1(int Id);

	
	
	
	
}
