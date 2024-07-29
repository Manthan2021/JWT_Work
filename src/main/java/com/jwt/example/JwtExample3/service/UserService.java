package com.jwt.example.JwtExample3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.JwtExample3.models.User;

@Service
public class UserService {
	
	private List<User> store=new ArrayList<User>();
	
	public UserService() {
		
		store.add(new User(UUID.randomUUID().toString(),"Manthan","xyz@dev.in"));
		store.add(new User(UUID.randomUUID().toString(),"Sagar","xyz@dev.in"));
		store.add(new User(UUID.randomUUID().toString(),"Prateek","xyz@dev.in"));
		
	}
	
	public List<User> getUsers(){
		return this.store;
	}
	

}
