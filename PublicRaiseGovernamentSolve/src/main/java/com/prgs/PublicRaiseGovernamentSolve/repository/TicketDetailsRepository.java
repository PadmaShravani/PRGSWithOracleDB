package com.prgs.PublicRaiseGovernamentSolve.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prgs.PublicRaiseGovernamentSolve.model.TicketDetails;

public interface TicketDetailsRepository extends JpaRepository<TicketDetails,Integer> {
	//methods Declaration
	List<TicketDetails> findByUserIdAndTicketType(int UserId,String ticketType);
	List<TicketDetails> findByTicketType(String ticketType);
	List<TicketDetails> findByStatus(String status);
 }
