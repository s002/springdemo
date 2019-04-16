package com.luv2code.springboot.demo.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.demo.springdemo.dao.TeamRepository;

import com.luv2code.springboot.demo.springdemo.entity.Team;


@Service
public class TeamServiceImpl implements TeamService {
	
	private TeamRepository teamRepository;
	
@Autowired

public TeamServiceImpl(TeamRepository theTeamRepository) {
	
	 teamRepository = theTeamRepository;
}

	@Override
	public List<Team> findAll() {
		// TODO Auto-generated method stub
		return teamRepository.findAll();
	}

	@Override
	public Team findById(int theId) {
		java.util.Optional<Team> Result = teamRepository.findById(theId);
        Team theTeam= null;
        
        if(Result.isPresent()) {
			theTeam = Result.get();
        }
        else {
       	 // did not find the company
       	 throw new RuntimeException("Did not fimd department id______" + theId);
       	 		
        }
       return theTeam;
	}

	@Override
	public void save(Team theTeam) {
		// TODO Auto-generated method stub
		teamRepository.save(theTeam);


	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		teamRepository.deleteById(theId);

	}

}
