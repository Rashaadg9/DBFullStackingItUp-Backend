package com.cognixia.jump.dbfullstacking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.dbfullstacking.model.User;
import com.cognixia.jump.dbfullstacking.model.cashUpdate;
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
	
	@GetMapping(value = "/user/{userId}")
	public User findUserById(@PathVariable("userId") Integer userId)
	{
		User user = userRepository.findByUserId(userId);
		
		return user;
	}
	
	@PutMapping(value = "/user")
	public User update(@RequestBody cashUpdate update)
	{
		User user = findUserById(update.getId());
		
		if(update.getType().equals("deposit"))
		{
			user.setCash(user.getCash()+ update.getAmount());
		}
		else if (update.getType().equals("withdrawal"))
		{
			user.setCash(user.getCash()- update.getAmount());
		}
		
		return userRepository.save(user);
	}
}
