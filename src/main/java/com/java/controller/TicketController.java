package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.TicketRequestDTO;
import com.java.dto.TicketResponseDTO;
import com.java.service.TicketService;

@Controller
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@RequestMapping(value = "/tickets", method = RequestMethod.POST)
	@ResponseBody
	public String addTicketDetails(@RequestBody TicketRequestDTO ticketRequestDTO) {
		ticketService.addTicketDetails(ticketRequestDTO);
		return "Ticket details added successfully";
	}
	
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	@ResponseBody
	public List<TicketResponseDTO> searchTickets(@RequestParam Integer userId) {
		List<TicketResponseDTO> ticketResponse = ticketService.searchTicket(userId);
		return ticketResponse;
	}

}
