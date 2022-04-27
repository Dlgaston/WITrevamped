package com.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.entity.OneRepMax;


@Repository
public interface OneRepMaxRepo extends JpaRepository<OneRepMax, Long>{

}

