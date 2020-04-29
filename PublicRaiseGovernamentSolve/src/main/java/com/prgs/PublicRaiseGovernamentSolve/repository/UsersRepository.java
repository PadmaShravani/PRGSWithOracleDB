package com.prgs.PublicRaiseGovernamentSolve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prgs.PublicRaiseGovernamentSolve.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	//method Declaration
	Users findByEmail(String email);
	
}
