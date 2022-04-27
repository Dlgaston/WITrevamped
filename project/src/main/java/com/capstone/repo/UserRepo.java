package com.capstone.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	@Query("SELECT S FROM User S WHERE S.email = ?1 and S.password = ?2")
	public User login(String email, String password);

	@Query("SELECT S FROM User S WHERE S.email = ?1")
	public Optional<User> getEMail(String email);
	
}
