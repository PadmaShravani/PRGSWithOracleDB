package com.prgs.PublicRaiseGovernamentSolve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prgs.PublicRaiseGovernamentSolve.Service.DepartmentService;
import com.prgs.PublicRaiseGovernamentSolve.Service.TicketService;
import com.prgs.PublicRaiseGovernamentSolve.Service.UsersService;
import com.prgs.PublicRaiseGovernamentSolve.model.Department;
import com.prgs.PublicRaiseGovernamentSolve.model.TicketDetails;
import com.prgs.PublicRaiseGovernamentSolve.model.Users;

@Controller		//This class perform the business logic (and can call the services) by its method
//session annotation is  used to store the model attribute in the session
@SessionAttributes({"msg","loggedInUserID", "loggedInUserEmail", "loggedInUserName"})
public class LoginAndRegistrationController {

	@Autowired		//This annotation enables you to inject the object dependency implicitly
	private UsersService service;
	@Autowired		//This annotation enables you to inject the object dependency implicitly
	private DepartmentService dService;
	@Autowired		//This annotation enables you to inject the object dependency implicitly
	private TicketService tService;
	
	private String loggedInUser = null;
	
	@RequestMapping("/prgs")	//This annotation maps HTTP requests to handler methods of MVC 
	//Method to get first view page
	public String viewVisitorPage(Model model) {
		
		List<TicketDetails> listAllTickets=tService.listAll();
		System.out.println(listAllTickets.size()+"  size");	
		model.addAttribute("list", listAllTickets.size());
		
		List<TicketDetails> solvedTickets=tService.getByStatus("Closed");
		System.out.println(solvedTickets.size()+"  size");	
		model.addAttribute("closedList", solvedTickets.size());
		return "visitor";
	}
	//Method to display signUp page
	@RequestMapping("/new_user")
	public String showNewUserForm(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		return "signUp";
	}
	//Method to save new user and display success message if registered
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	//modelAttribute binds a method parameter or method return value to a named model attribute and then exposes it to a web view
	public String saveUser(@ModelAttribute("users") Users users,Model model) {
		users.setRoleId(1);
		service.save(users);
		model.addAttribute("success", "Successfully Registered");
		return "login";
	}
	//Method to show login page
	@RequestMapping("/existing_user")
	public String showLoginForm(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		return "login";
	}
	
	//Method to validate  users credentials 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateLoginInfo(@ModelAttribute Users user, Model model) {
		System.out.println("Entered :" + user.getEmail());
		System.out.println("Entered :" + user.getPassword());
		Users exist_user;
		try {
			exist_user = service.findByEmail(user.getEmail());
			System.out.println("From DB :" + exist_user.getEmail());
			System.out.println("From DB :" + exist_user.getPassword());
			if (!exist_user.getPassword().equals(user.getPassword())) {
				
				System.out.println("Not a valid password. Please click forgot password");	
				model.addAttribute("errorMessage", "Please enter valid Password ");
				return "login";
			} else {
				// loggedInUser = user.getEmail();
			
				loggedInUser = exist_user.getFirstName() + " " + exist_user.getLastName();				
				model.addAttribute("msg", "Logged in as " + loggedInUser);
				model.addAttribute("loggedInUserEmail", exist_user.getEmail());
				model.addAttribute("loggedInUserName",  exist_user.getUserName());
				model.addAttribute("loggedInUserID",  exist_user.getUserId());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not a valid email. Please register using sign up");
			model.addAttribute("erroremail", "Please enter valid email ");
			return "login";
		}
		 System.out.println("role id "+exist_user.getRoleId());
		 if(exist_user.getRoleId()==3) {
			 List<Department> dList = dService.listAll();
				model.addAttribute("departments", dList);
		 }
		return service.loginWithRole(exist_user);
	}

}
