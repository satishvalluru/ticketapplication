package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDAO;
import com.java.dto.UserDTO;
import com.java.dto.UserLoginDTO;
import com.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public void saveUser(UserDTO userDto) {
		userDAO.saveUser(userDto);
	}

	@Override
	public Boolean authenticateUser(UserLoginDTO userLoginDTO) {
		return userDAO.authenticate(userLoginDTO);
	}

}
