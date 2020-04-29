package com.prgs.PublicRaiseGovernamentSolve.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prgs.PublicRaiseGovernamentSolve.model.ServiceModel;

public interface ServiceRepository extends JpaRepository<ServiceModel,Integer> {
	//method Declaration
	List<ServiceModel> findByDepartmentId(int departmentId);

	
}
