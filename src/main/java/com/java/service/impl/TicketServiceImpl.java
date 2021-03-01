package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.TicketDAO;
import com.java.dto.TicketRequestDTO;
import com.java.dto.TicketResponseDTO;
import com.java.model.Ticket;
import com.java.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketDAO ticketDAO;

	@Override
	public void addTicketDetails(TicketRequestDTO ticketRequestDTO) {
		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(ticketRequestDTO, ticket);
		ticketDAO.addTicketDetails(ticket);
	}

	@Override
	public List<TicketResponseDTO> searchTicket(Integer userId) {
		List<TicketResponseDTO> ticketList = ticketDAO.searchTicket(userId);
		System.out.println(ticketList.size());
		
		List<TicketResponseDTO> ticketListFinal = new ArrayList<>();
		for (TicketResponseDTO ticket : ticketList) {
			ticket.getPassengerDetails().contains(userId);

			ticketListFinal.add(ticket);

		}
		return ticketListFinal;
	}
}
