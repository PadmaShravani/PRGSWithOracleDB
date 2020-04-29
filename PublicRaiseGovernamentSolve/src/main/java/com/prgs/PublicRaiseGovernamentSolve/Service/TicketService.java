package com.prgs.PublicRaiseGovernamentSolve.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prgs.PublicRaiseGovernamentSolve.model.TicketDetails;
import com.prgs.PublicRaiseGovernamentSolve.repository.TicketDetailsRepository;

@Service
public class TicketService {
	@Autowired
	private TicketDetailsRepository trepo;

	//Method to Get list of all tickets for this application
	public List<TicketDetails> listAll() {

		return trepo.findAll();
	}
	//Method to Get list of all tickets based on status
	public List<TicketDetails> getByStatus(String status){
		return trepo.findByStatus(status);
	}
	//Method to save new tickets raised by user
	public void save(TicketDetails ticket) {
		trepo.save(ticket);
	}
	//Method to get ticket details for a particular user based on id
	public TicketDetails get(int id) {
		return trepo.findById(id).get();

	}
	//Method to Get list of all tickets raised by logged-in user (User view)
	public List<TicketDetails> getUserTickets(int UserId,String ticketType) {
		return trepo.findByUserIdAndTicketType(UserId,ticketType);
		
	}
	//Method to Get list of all tickets based on ticket type (Admin view)
	public List<TicketDetails> getAllTickets(String ticketType){
		return trepo.findByTicketType(ticketType);
	}

}
