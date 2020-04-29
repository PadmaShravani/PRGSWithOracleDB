package com.prgs.PublicRaiseGovernamentSolve.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prgs.PublicRaiseGovernamentSolve.model.Users;
import com.prgs.PublicRaiseGovernamentSolve.repository.UsersRepository;


@Service	//using this annotation jvm understands this is a service class
public class UsersService {
	@Autowired		//This annotation enables you to inject the object dependency implicitly
	private UsersRepository repo;
	
	//method for different users based on role Id it returns different html pages
	public String loginWithRole(Users users) {
				
		if (users.getRoleId() == 1) {
			return "userViewPage";
		}
		else if (users.getRoleId() == 2) {
				System.out.println("Admin login");
				return "adminViewPage";
			} else if (users.getRoleId() == 3) {
				System.out.println("department login");
				
				return "departmentViewPage";
			}
		return "visitor";
	}
	
	//Method to Get list of all Users for this application
	public List<Users> listAll(){
		
		return repo.findAll();
	}
	
	//Method to save newly registered users
	public void save(Users users) {
		repo.save(users);
	}
	
	//Method to get a particular user details based on his Id
	public Users get(int userId) {
		return repo.findById(userId).get();
		
	}
	
//	public void delete(int userId) {
//		repo.deleteById(userId);
//	}
	
	//Method to get a particular user details based on his email
	public Users findByEmail(String email) {
		
	        return repo.findByEmail(email);	 
	        
	}
	
}
