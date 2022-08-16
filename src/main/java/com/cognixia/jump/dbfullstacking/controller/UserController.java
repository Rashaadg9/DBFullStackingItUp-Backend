package com.cognixia.jump.dbfullstacking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.dbfullstacking.model.User;
import com.cognixia.jump.dbfullstacking.repository.UserRepository;

@RestController
public class UserController
{
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/users")
	public Iterable<User> all()
	{
		List<User> user = userRepository.findAll();
		
		return user;
	}
}
