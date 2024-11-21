package com.klu.ReactIntegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.ReactIntegration.model.DemoUser;

@Repository
public interface DemoUserRepo extends JpaRepository<DemoUser, Integer>{

}
