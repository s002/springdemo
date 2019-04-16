package com.luv2code.springboot.demo.springdemo.service;

import java.util.List;


import com.luv2code.springboot.demo.springdemo.entity.Company;

public interface CompanyService {
	
	public List<Company> findAll();
	
	public Company findById(int theId);
	
	public void save (Company theCompany);
	
	public void deleteById(int theId);

	//public void deleteById(Long theId);
	

}
