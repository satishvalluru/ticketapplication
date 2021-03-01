package com.java.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.TicketDAO;
import com.java.dto.TicketResponseDTO;
import com.java.model.Ticket;

@Repository
public class TicketDAOImpl implements TicketDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTicketDetails(Ticket ticket) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ticket);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<TicketResponseDTO> searchTicket(Integer userId) {
		List<Ticket> response = new ArrayList<>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.add(Restrictions.eq("userId", userId));
		response = criteria.list();
		session.getTransaction().commit();
		session.close();

		List<TicketResponseDTO> responseDTOList = new ArrayList<>();
		TicketResponseDTO responseDTOObject = new TicketResponseDTO();

		for (Ticket ticket : response) {
			BeanUtils.copyProperties(ticket, responseDTOObject);
			responseDTOList.add(responseDTOObject);

		}

		return responseDTOList;
	}

}
