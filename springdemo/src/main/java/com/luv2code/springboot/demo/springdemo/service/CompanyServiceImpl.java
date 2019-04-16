package com.luv2code.springboot.demo.springdemo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.demo.springdemo.dao.CompanyRepository;
import com.luv2code.springboot.demo.springdemo.entity.Company;


@Service
public class CompanyServiceImpl implements CompanyService {
	
	private CompanyRepository companyRepository;
	
	@Autowired
	public CompanyServiceImpl(CompanyRepository theCompanyRepository) {
		
     companyRepository = theCompanyRepository;
		
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public Company findById(int theId) {
		java.util.Optional<Company> Result = companyRepository.findById(theId);
        Company  theCompany = null;
        
        if(Result.isPresent()) {
			theCompany = Result.get();
        }
        else {
       	 // did not find the company
       	 throw new RuntimeException("Did not fimd company id______" + theId);
       	 		
        }

		return theCompany;
	}

	@Override
	public void save(Company theCompany) {
		// TODO Auto-generated method stub
		companyRepository.save(theCompany);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		companyRepository.deleteById(theId);

	}

}
