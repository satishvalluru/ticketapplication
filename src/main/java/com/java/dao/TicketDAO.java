package com.java.dao;

import java.util.List;

import com.java.dto.TicketResponseDTO;
import com.java.model.Ticket;

public interface TicketDAO {

	void addTicketDetails(Ticket ticket);

	List<TicketResponseDTO> searchTicket(Integer userId);

}
