package com.capstone.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Plan;
import com.capstone.entity.User;
import com.capstone.repo.PlanRepo;
import com.capstone.repo.UserRepo;

@Service
public class PlanService {

	@Autowired
	PlanRepo planRepo;
	@Autowired
	UserService userService;
	@Autowired
	UserRepo userRepo;
	
 public Plan FiveThreeOne (Long id) {
	 User account = userService.getAccount(id);
	 Plan plan = new Plan();
		plan.setName("Five Three One");
		plan.setPlanStart(LocalDate.now());
		account.getPlan().add(plan);
		planRepo.save(plan);
		userRepo.save(account);
		return plan;
 }
 
 public Plan LastPlan(Long id) {
	 	User account = userService.getAccount(id);
		int lastPlan = account.getPlan().size() -1;
		Plan currentPlan = account.getPlan().get(lastPlan);
		
		return currentPlan;
 }
}
