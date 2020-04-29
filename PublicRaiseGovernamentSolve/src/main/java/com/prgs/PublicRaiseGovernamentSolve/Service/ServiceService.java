package com.prgs.PublicRaiseGovernamentSolve.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prgs.PublicRaiseGovernamentSolve.model.ServiceModel;
import com.prgs.PublicRaiseGovernamentSolve.repository.ServiceRepository;
@Service
public class ServiceService {
	@Autowired
	private ServiceRepository srepo;
	
	//Method to save new Service tickets raised by admin
	public void save(ServiceModel service) {
		srepo.save(service);
	}
	//Method to Get list of all tickets based on department Id(Department User)
	public List<ServiceModel> getDepartmentTickets(int departmentId){
		return srepo.findByDepartmentId(departmentId);
		}
	//Method to get service ticket details for admin based on id
	public ServiceModel get(int id) {
		return srepo.findById(id).get();
		
	}
	//Method to get list of Service ticket raised by admin
	public List<ServiceModel> listAll(){
		
		return srepo.findAll();
	}
}
