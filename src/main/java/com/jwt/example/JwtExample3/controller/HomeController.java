package com.jwt.example.JwtExample3.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.JwtExample3.models.User;
import com.jwt.example.JwtExample3.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;
	
	//http://localhost:8081/home/users
	@GetMapping("/users")
	public List<User> getUser() {
		System.out.println("getting users");
		return userService.getUsers();
	}
	
	@GetMapping("/current-users")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
	
	
}
