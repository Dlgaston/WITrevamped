package com.capstone.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Plan;
import com.capstone.entity.User;
import com.capstone.repo.PlanRepo;
import com.capstone.repo.UserRepo;
import com.capstone.service.PlanService;
import com.capstone.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlanController {

	@Autowired
	PlanRepo planRepo;
	@Autowired
	PlanService planService;
	@Autowired
	UserService userService;
	@Autowired
	UserRepo userRepo;
	
	
	@RequestMapping(value="/createworkout", method = RequestMethod.GET)
	public ResponseEntity<Plan> createPlan() {
		Plan plan = new Plan();
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/createPlan/{id}",
	method = RequestMethod.POST)
	public ResponseEntity<Plan> CreatePlan(@RequestBody Plan plan, @PathVariable("id") Long id) {
		Plan newPlan = planService.createPlan(id, plan);
		return new ResponseEntity<>(newPlan, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/planHistory/{id}",
	method = RequestMethod.GET)
	public ResponseEntity<List<Plan>> PlanHistory(@PathVariable("id")Long id){
		User account = userService.getAccount(id);
		List<Plan> planHistory = account.getPlan();
		
		return new ResponseEntity<>(planHistory, HttpStatus.OK);
		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/currentPlan/{id}",
	method = RequestMethod.GET)
	public ResponseEntity<Plan> LastPlan(@PathVariable("id")Long id){
		Plan currentPlan = planService.LastPlan(id);
				
		if(currentPlan.getPlanEnd() == null) {
		return new ResponseEntity<>(currentPlan, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/endPlan/{id}",
	method = RequestMethod.POST)
	public ResponseEntity<Plan> endPlan(@PathVariable("id")Long id){
		Plan currentPlan = planService.LastPlan(id);
		currentPlan.setPlanEnd(LocalDate.now());
		planRepo.save(currentPlan);

		return new ResponseEntity<>(currentPlan, HttpStatus.OK);
		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/findSpecificPlan/{id}",
	method = RequestMethod.GET)
	public ResponseEntity<Plan> SpecificPlan(@PathVariable("id")Long id){
		Optional<Plan> specificPlan = planRepo.findById(id);
				
		if(specificPlan != null) {
			Plan setPlan = specificPlan.get();
		return new ResponseEntity<>(setPlan, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
