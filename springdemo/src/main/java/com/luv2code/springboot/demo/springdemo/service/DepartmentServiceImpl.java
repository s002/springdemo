package com.luv2code.springboot.demo.springdemo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luv2code.springboot.demo.springdemo.dao.DepartmentRepository;
import com.luv2code.springboot.demo.springdemo.entity.Department;



@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;
	
	
	@Autowired
	public  DepartmentServiceImpl(DepartmentRepository theDepartmentRepository) {
		
		departmentRepository = theDepartmentRepository;
		
	}

	@Override
	public List<Department>findAll1() {
		return departmentRepository.findAll();
	}

	@Override
	public Department findById1(int theId) {
		
		java.util.Optional<Department> Result = departmentRepository.findById(theId);
        Department theDepartment= null;
        
        if(Result.isPresent()) {
			theDepartment = Result.get();
        }
        else {
       	 // did not find the company
       	 throw new RuntimeException("Did not fimd department id______" + theId);
       	 		
        }
       return theDepartment;
	}
		
	

	@Override
	public void save1(Department theDepartment) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				departmentRepository.save(theDepartment);

	}

	@Override
	public void deleteById1(int theId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(theId);

	}

}

