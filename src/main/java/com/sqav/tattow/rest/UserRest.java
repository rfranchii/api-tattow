package com.sqav.tattow.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqav.tattow.service.UserService;
import com.sqav.tattow.vo.LoginRequest;
import com.sqav.tattow.vo.UserRequest;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/user")
public class UserRest extends BaseRest {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/login")
	public ResponseEntity<?> login(HttpServletRequest request, @RequestBody LoginRequest loginRequest) {
		return createObjectReturn(userService.login(loginRequest));
	}
	
	@PostMapping(value="/register-collaborator")
	public ResponseEntity<?> registerCollaborator(@RequestBody UserRequest userRequest) {
		userService.registerCollaboratorUser(userRequest);
		return createObjectReturn(Boolean.TRUE);
	}
	
}
