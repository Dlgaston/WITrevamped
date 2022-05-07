package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.User;
import com.capstone.repo.UserRepo;
import com.capstone.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
 
	@Autowired
	UserRepo userRepo;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/create-account", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> createAccount() {
		User account = new User();

		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public User handleCreateAccount(@RequestBody User account) {
		userRepo.save(account);
		return account;
	}
	@RequestMapping(value = "/login",

			method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> loginAccount(@RequestBody User account) {
		User loginAccount = userRepo.login(account.getEmail(), account.getPassword());
		return new ResponseEntity<>(loginAccount, HttpStatus.OK);
	}
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getAccount(@PathVariable("id") Long id) {

		return new ResponseEntity<>(userService.getAccount(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account-update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> updateAccount(@PathVariable("id") Long id, @RequestBody User account) {

		return new ResponseEntity<>(userService.handleUpdateAccount(id, account), HttpStatus.OK);
	}
	@RequestMapping(value = "/account-delete", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<User> deleteAccount(@RequestBody User account) {
			System.out.println();
		userRepo.delete(account);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
