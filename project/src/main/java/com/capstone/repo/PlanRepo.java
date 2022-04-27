package com.capstone.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Plan;


@Repository
public interface PlanRepo extends JpaRepository<Plan, Long>{

}
