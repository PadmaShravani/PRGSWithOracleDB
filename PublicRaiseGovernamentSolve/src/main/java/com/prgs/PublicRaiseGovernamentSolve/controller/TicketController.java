package com.prgs.PublicRaiseGovernamentSolve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.prgs.PublicRaiseGovernamentSolve.Service.TicketService;
import com.prgs.PublicRaiseGovernamentSolve.model.ServiceModel;
import com.prgs.PublicRaiseGovernamentSolve.model.TicketDetails;


@Controller		//This class perform the business logic (and can call the services) by its method
//session annotation is  used to store the model attribute in the session
@SessionAttributes({"msg","loggedInUserID", "loggedInUserEmail", "loggedInUserName"})
public class TicketController {
	@Autowired		//This annotation enables you to inject the object dependency implicitly
	private TicketService tservice;

	@RequestMapping("/home") //This annotation maps HTTP requests to handler methods of MVC 
	//After logging this page will Display
	public String viewVisitorPage(Model model) {
		return "userViewPage";
	}
	//Displays list of complaints and complaint page
	@RequestMapping("/complaint_page")
	public String viewComplaintPage(Model model) {
		TicketDetails td = new TicketDetails();
		model.addAttribute("ticketdetails", td);
		System.out.println("all complaints");
		int uId=(int) model.getAttribute("loggedInUserID");
		List<TicketDetails> listUserTickets=tservice.getUserTickets(uId, "complaint");
		System.out.println("No. of Tickets: "+listUserTickets.size());
		model.addAttribute("listtickets", listUserTickets);	
		return "cticket";
	}
	//User can raise a complaint and ticket will be saved in DB
	@RequestMapping(value="/saveComplaint", method=RequestMethod.POST)
	//modelAttribute binds a method parameter or method return value to a named model attribute and then exposes it to a web view
	public String saveComplaintTicket(@ModelAttribute("ticketdetails") TicketDetails ticket, Model model) {	
		System.out.println("action: "+model.getAttribute("loggedInUserID"));
		System.out.println("action: "+model.getAttribute("loggedInUserEmail"));
		ticket.setTicketType("complaint");
		ticket.setStatus("Open");
		ticket.setUserId((int) model.getAttribute("loggedInUserID"));
		ticket.setServiceId(1);
		tservice.save(ticket);	
		model.addAttribute("success", "Successfully created a ticket");
		return "cticket";
	}
	//User can view List of request tickets and raise ticket page
	@RequestMapping("/request_page")
	public String viewRequestPage(Model model) {
		TicketDetails td = new TicketDetails();
		model.addAttribute("requestdetails", td);
		System.out.println("request page");
		int uId=(int) model.getAttribute("loggedInUserID");
		List<TicketDetails> listRequests=tservice.getUserTickets(uId, "request");
		System.out.println("No. of Tickets: "+listRequests.size());
		model.addAttribute("listrequests", listRequests);	
		return "rticket";
	}
	//user can raise a Request ticket and save in DB
	@RequestMapping(value="/saveRequest", method=RequestMethod.POST)
	public String saveRequestTicket(@ModelAttribute("requestdetails") TicketDetails ticket, Model model) {
		System.out.println("action: "+model.getAttribute("loggedInUserID"));
		System.out.println("action: "+model.getAttribute("loggedInUserEmail"));
		ticket.setComplaintType("others");
		ticket.setTicketType("request");
		ticket.setStatus("Open");
		ticket.setUserId((int) model.getAttribute("loggedInUserID"));
		ticket.setServiceId(1);
		tservice.save(ticket);	
		model.addAttribute("success", "Successfully created a Request ticket");
		return "rticket";
	}
	//Admin can see list of complaints from all users			
	@RequestMapping("/complaints_received")
	public String viewAllComplaints(Model model) {
		System.out.println("all complaints");
		List<TicketDetails> listAllComplaints=tservice.getAllTickets("complaint");
		System.out.println(listAllComplaints.size()+"  size");	
		model.addAttribute("list_all_complaints", listAllComplaints);
		ServiceModel serviceticket=new ServiceModel();
		model.addAttribute("service", serviceticket);
		return "complaintsReceivedPage";
	}
	//Admin can see list of requests from all users
	@RequestMapping("/requests_received")
	public String viewAllRequests(Model model) {
		System.out.println("all complaints");
		List<TicketDetails> listAllRequests=tservice.getAllTickets("request");
		System.out.println(listAllRequests.size()+"  size");
		model.addAttribute("list_all_requests", listAllRequests);
		ServiceModel serviceticket=new ServiceModel();
		model.addAttribute("service", serviceticket);
		return "RequestsReceivedPage";
	}
		
}
