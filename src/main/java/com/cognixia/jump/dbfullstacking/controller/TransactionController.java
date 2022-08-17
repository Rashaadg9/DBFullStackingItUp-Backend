package com.cognixia.jump.dbfullstacking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.dbfullstacking.model.Transactions;
import com.cognixia.jump.dbfullstacking.repository.TransactionsRepository;

@RestController
public class TransactionController
{
	
	@Autowired
	private TransactionsRepository transactionsRepository;
	
	@GetMapping(value = "/transactions")
	public Iterable<Transactions> all()
	{
		List<Transactions> transactions = transactionsRepository.findAll();
		
		return transactions;
	}
	
	@GetMapping(value = "/transactions/{uid}")
	public Iterable<Transactions> findByUid(@PathVariable("uid") Integer uid)
	{
		List<Transactions> transactions = transactionsRepository.findByUid(uid);
		
		return transactions;
	}
	
	@PostMapping(value = "/transactions")
	public Transactions saveNew(@RequestBody Transactions transactions)
	{
		return transactionsRepository.save(transactions);
	}
}
