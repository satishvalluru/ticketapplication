package com.java.service;

import java.util.List;

import com.java.dto.TicketRequestDTO;
import com.java.dto.TicketResponseDTO;

public interface TicketService {

	void addTicketDetails(TicketRequestDTO ticketRequestDTO);

	List<TicketResponseDTO> searchTicket(Integer userId);


}
