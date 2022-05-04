package com.capstone.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.entity.OneRepMax;
import com.capstone.entity.Plan;
import com.capstone.entity.User;
import com.capstone.repo.OneRepMaxRepo;
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
	@Autowired
	OneRepMaxRepo ormRepo;

	public Plan createPlan(Long id, Plan plan) {
		User account = userService.getAccount(id);
		Plan newPlan = plan;
		plan.setPlanStart(LocalDate.now());
		planRepo.save(newPlan);
		account.getPlan().add(newPlan);
		userRepo.save(account);
		return newPlan;
	}

	public Plan LastPlan(Long id) {
		User account = userService.getAccount(id);
		int lastPlan = account.getPlan().size() - 1;
		Plan currentPlan = account.getPlan().get(lastPlan);

		return currentPlan;
	}
	
	public Plan SpecificPlan(@PathVariable("id")Long id){
		Optional<Plan> specificPlan = planRepo.findById(id);
				
		if(specificPlan != null) {
			Plan setPlan = specificPlan.get();
		return setPlan;
		} else {
			return null;
		}
		
	}
}