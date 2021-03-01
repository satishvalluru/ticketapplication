package com.java.controller;



import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.UserDTO;
import com.java.dto.UserLoginDTO;
import com.java.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public String authenticate(@RequestBody UserLoginDTO userLoginDTO) {
		Boolean isExists = userService.authenticateUser(userLoginDTO);
		if(isExists) return "Login Success";
		return "authentication failed! Please enter valid credentials";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String saveUser(@RequestBody UserDTO userDto) {
		userService.saveUser(userDto);
		return "Registration Success";
	}

}