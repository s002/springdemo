package com.luv2code.springboot.demo.springdemo.service;

import java.util.List;

import com.luv2code.springboot.demo.springdemo.entity.Team;

public interface TeamService {
	
public List<Team> findAll();
	
	public Team findById(int theId);
	
	public void save (Team theTeam);
	
	public void deleteById(int theId);
	

}
