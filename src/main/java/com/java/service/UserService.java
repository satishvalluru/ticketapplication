package com.java.service;

import com.java.dto.UserDTO;
import com.java.dto.UserLoginDTO;

public interface UserService {
	

	public void saveUser(UserDTO userDto);

	public Boolean authenticateUser(UserLoginDTO userLoginDTO);

}
