package com.capstone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capstone.entity.User;
import com.capstone.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	
	public User getAccount(Long id) {
		Optional<User> getAccount = userRepo.findById(id);
		if (getAccount.isPresent()) {
			User accountFound = getAccount.get();
			return userRepo.save(accountFound);
		}
		return null;
	
}
	
	public User handleUpdateAccount(User account) {
		Optional<User> updateAccount = userRepo.findById(account.getId());
		if (updateAccount.isPresent()) {
			User accountFound = updateAccount.get();
			accountFound.setFirstName(account.getFirstName());
			accountFound.setLastName(account.getLastName());
			accountFound.setUsername(account.getUsername());
			accountFound.setEmail(account.getEmail());
			accountFound.setPassword(account.getPassword());
			return userRepo.save(accountFound);
		}
		return null;

	}
}
