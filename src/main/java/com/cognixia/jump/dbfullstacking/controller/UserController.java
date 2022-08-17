package com.cognixia.jump.dbfullstacking.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.dbfullstacking.model.Transactions;
import com.cognixia.jump.dbfullstacking.model.Transfer;
import com.cognixia.jump.dbfullstacking.model.User;
import com.cognixia.jump.dbfullstacking.model.cashUpdate;
import com.cognixia.jump.dbfullstacking.model.loginForm;
import com.cognixia.jump.dbfullstacking.controller.TransactionController;
import com.cognixia.jump.dbfullstacking.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController
{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionController transactionController;
	
	@GetMapping(value = "/users")
	public Iterable<User> all()
	{
		List<User> user = userRepository.findAll();
		
		return user;
	}
	
	@PostMapping(value = "/user/login")
	public User findByUsernameAndPass(@RequestBody loginForm loginForm)
	{
		User user = userRepository.findByUsernameAndPass(loginForm.getUsername(), loginForm.getPassword());
		
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
		Date date = Date.valueOf(LocalDate.now());
		Transactions transactions = new Transactions(null, date, update.getType(), update.getAmount(), update.getId() );
		
		
		if(update.getType().equals("deposit"))
		{
			user.setCash(user.getCash()+ update.getAmount());
			transactionController.saveNew(transactions);
		}
		else if (update.getType().equals("withdrawal"))
		{
			user.setCash(user.getCash()- update.getAmount());
			transactionController.saveNew(transactions);
		}
		
		return userRepository.save(user);
	}
	
	@PutMapping(value = "/user/transfer")
	public User transfer(@RequestBody Transfer transfer)
	{
		Date date = Date.valueOf(LocalDate.now());
		
		User userMe = findUserById(transfer.getId());
		Transactions transactionsMe = new Transactions(null, date, "transfered", transfer.getAmount(), transfer.getId() );
		
		User userOther = userRepository.findByUsername(transfer.getUsername());
		Transactions transactionsOther = new Transactions(null, date, "received", transfer.getAmount(), userOther.getUserId() );
		
		userOther.setCash(userOther.getCash() + transfer.getAmount());
		transactionController.saveNew(transactionsOther);
		
		userMe.setCash(userMe.getCash() - transfer.getAmount());
		transactionController.saveNew(transactionsMe);
		
		
		userRepository.save(userOther);
		return userRepository.save(userMe);
	}
}
