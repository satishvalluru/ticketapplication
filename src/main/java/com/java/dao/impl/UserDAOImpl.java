package com.java.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.UserDAO;
import com.java.dto.UserDTO;
import com.java.dto.UserLoginDTO;
import com.java.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveUser(UserDTO userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Boolean authenticate(UserLoginDTO userLoginDTO) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userLoginDTO.getUserName()));
		criteria.add(Restrictions.eq("password", userLoginDTO.getPassword()));

		if (criteria.list().size() == 1)
			return true;
		return false;
	}

}