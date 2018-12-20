package com.vbgps.jarslink.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.alipay.jarslink.api.Action;
import com.vbgps.jarslink.dto.UserDTO;
import com.vbgps.jarslink.service.UserService;

public class HelloWorldAction implements Action<Integer, UserDTO> {

	@Autowired
	private UserService userService;

	public UserDTO execute(Integer arg0) {
		return userService.findUser(arg0);
	}

	public String getActionName() {
		return "findUser";
	}

}
