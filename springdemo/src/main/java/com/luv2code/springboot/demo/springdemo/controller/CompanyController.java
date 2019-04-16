package com.luv2code.springboot.demo.springdemo.controller;
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

import com.luv2code.springboot.demo.springdemo.entity.Company;
import com.luv2code.springboot.demo.springdemo.service.CompanyService;
import com.luv2code.springboot.demo.springdemo.service.CompanyServiceImpl;

@RestController
@RequestMapping("/api")
public class CompanyController {
	
	private CompanyService companyService;

	
@Autowired

public CompanyController(CompanyServiceImpl theCompanyService ) {
	
	companyService = theCompanyService;

}

@GetMapping("/companies")
public List<Company> findAll()
{
	return companyService.findAll();
}


@GetMapping("/companies/{companyId}")

public Company getCompany(@PathVariable int companyId) {
	
	Company theCompany = companyService.findById(companyId);

	if (theCompany==null) {
		
		throw new RuntimeException("CompanyId is not found __________"+ companyId);
		
	}
	
	return theCompany;
		
		
}


@PostMapping("/companies")

public Company addCompany(@RequestBody Company theCompany) {
	
	// if the usr pass an Id of 0 in the Json format , set the Id =0
	// else if save it as update of the Id
	
	theCompany.setId(0);
	companyService.save(theCompany);

	return theCompany;
	
}

@PutMapping("/companies")

public Company updateCompany(@RequestBody Company theCompany) {
	
	companyService.save(theCompany);
	
	return theCompany;
}
@DeleteMapping("/companies/{companyId}")

public int deleteCompany(@PathVariable int companyId) {


Company tempCompany = companyService.findById(companyId);

      if(tempCompany == null) {
    	  throw new RuntimeException("Company not found in the database -------"+ companyId);
      }
	companyService.deleteById(companyId);
	
	return companyId;
}

}