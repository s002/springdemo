package com.luv2code.springboot.demo.springdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.springdemo.entity.Department;
import com.luv2code.springboot.demo.springdemo.service.DepartmentService;
import com.luv2code.springboot.demo.springdemo.service.DepartmentServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class DepartmentController {
  
	   private DepartmentService departmentService;

@Autowired

public DepartmentController(DepartmentServiceImpl theDepartmentService) {
	
   departmentService = theDepartmentService;
}

@GetMapping("/departments")

	public List<Department> findAll1()
{
	return departmentService.findAll1();
}


@GetMapping("/departments/{departmentId}")

  public Department getDepartment(@PathVariable int DepartmentId ) {
	
	Department theDepartment = departmentService.findById1(DepartmentId);
	
	if (theDepartment==null)
	{
		throw new RuntimeException("DepartmentId is not found __________"+ DepartmentId);
	}
	
      return theDepartment;
}

@RequestMapping(method = RequestMethod.POST, value = "/departments")
public void addDepartment(@RequestBody Department department) {
	departmentService.save1(department);
	}

/*@PostMapping("/departments")

  public Department addDepartment(@RequestBody Department theDepartment) {
	
	
	//int companyId = 1;
	
	theDepartment.setId(0);
    departmentService.save1(theDepartment);
    
    return theDepartment;


}*/

@PutMapping("/departments")

public Department updateDepartment(@RequestBody Department theDepartment) {
	
	departmentService.save1(theDepartment);
	
	return theDepartment;
}

@DeleteMapping("/departments/{departmentId}")

public int deleteDepartment(@PathVariable int departmentId) {


Department tempDepartment = departmentService.findById1(departmentId);

      if(tempDepartment == null) {
    	  throw new RuntimeException("Department not found in the database -------"+ departmentId);
      }
	departmentService.deleteById1(departmentId);
	
	return departmentId;
}


}