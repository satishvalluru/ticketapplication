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

import com.java.dao.TrainDAO;
import com.java.dto.TrainResponseDTO;
import com.java.model.Train;

@Repository
public class TrainDAOImpl implements TrainDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTrainDetails(Train train) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(train);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<TrainResponseDTO> searchTrain(String from, String to) {
		List<Train> response = new ArrayList<>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		Criteria criteria = session.createCriteria(Train.class);
		criteria.add(Restrictions.like("source", from));
		criteria.add(Restrictions.like("destination", to));
		response = criteria.list();
		session.close();

		List<TrainResponseDTO> responseDTOList = new ArrayList<>();
		for (Train train:response) {
			TrainResponseDTO responseDTOObject = new TrainResponseDTO();
			BeanUtils.copyProperties(train, responseDTOObject);
			responseDTOList.add(responseDTOObject);
		}

		return responseDTOList;
	}

}
