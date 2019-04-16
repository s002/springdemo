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

//import com.luv2code.springboot.demo.springdemo.entity.Company;
import com.luv2code.springboot.demo.springdemo.entity.Team;
import com.luv2code.springboot.demo.springdemo.service.TeamService;
import com.luv2code.springboot.demo.springdemo.service.TeamServiceImpl;

@RestController
@RequestMapping("/api")
public class TeamController {
	private TeamService teamService;

	
@Autowired

public TeamController(TeamServiceImpl theTeamService ) {
	
	teamService = theTeamService;
		
}

@GetMapping("/teams")
public List<Team> findAll()
{
	return teamService.findAll();

}


@GetMapping("/teams/{teamId}")

public Team getTeam(@PathVariable int teamId) {
	
	Team theTeam = teamService.findById(teamId);

	if (theTeam==null) {
		
		throw new RuntimeException("TeamId is not found __________"+ teamId);
		
	}
	
	return theTeam;
		
}


@PostMapping("/teams")

public Team addTeam(@RequestBody Team theTeam) {
	
	// if the usr pass an Id of 0 in the Json format , set the Id =0
	// else if save it as update of the Id
	
//	theTeam.setName("");
	teamService.save(theTeam);

	return theTeam;
	
}


@PutMapping("/teams")

public Team updateTeam(@RequestBody Team theTeam) {
	
	teamService.save(theTeam);
	
	return theTeam;
}
@DeleteMapping("/teams/{teamId}")

public int deleteTeam(@PathVariable int teamId) {


Team tempTeam = teamService.findById(teamId);

      if(tempTeam == null) {
    	  throw new RuntimeException("Team not found in the database -------"+ teamId);
      }
	teamService.deleteById(teamId);
	
	return teamId;
}

}