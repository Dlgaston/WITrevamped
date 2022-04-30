package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.OneRepMax;
import com.capstone.entity.Plan;
import com.capstone.entity.User;
import com.capstone.repo.OneRepMaxRepo;
import com.capstone.repo.PlanRepo;
import com.capstone.repo.UserRepo;
import com.capstone.service.PlanService;
import com.capstone.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OneRepMaxController {

	@Autowired
	OneRepMaxRepo ormRepo;
//	@Autowired
//	OneRepMaxService ormService;
	@Autowired
	UserService userService;
	@Autowired
	UserRepo userRepo;
	@Autowired
	PlanService planService;
	@Autowired
	PlanRepo planRepo;
	
	@RequestMapping(value = "/ormBody", method = RequestMethod.GET)
	public ResponseEntity<OneRepMax> ormBody(){
		OneRepMax orm = new OneRepMax();
		return new ResponseEntity<>(orm, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/addORM", method = RequestMethod.POST)
	public ResponseEntity<OneRepMax> createORM(@RequestBody OneRepMax orm) {
		ormRepo.save(orm);

		return new ResponseEntity<>(orm, HttpStatus.OK);

		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/specificPlanORM/{id}", method = RequestMethod.POST)
	public ResponseEntity<Plan> specificPlanORM(@RequestBody OneRepMax orm, @PathVariable("id") Long id) {
		Plan plan = planService.SpecificPlan(id);
		ormRepo.save(orm);
		plan.setOrmId(orm);
		planRepo.save(plan);
		return new ResponseEntity<>(plan, HttpStatus.OK);

	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/lastPlanORM/{id}", method = RequestMethod.POST)
	public ResponseEntity<Plan> lastPlanORM(@RequestBody OneRepMax orm, @PathVariable("id") Long id) {
		Plan plan = planService.LastPlan(id);
		ormRepo.save(orm);
		plan.setOrmId(orm);
		planRepo.save(plan);
		return new ResponseEntity<>(plan, HttpStatus.OK);

	}
}
