package com.java.dao;

import com.java.dto.UserDTO;
import com.java.dto.UserLoginDTO;

public interface UserDAO {

	public void saveUser(UserDTO userDto);

	public Boolean authenticate(UserLoginDTO userLoginDTO);

}
