package com.cognixia.jump.dbfullstacking.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.dbfullstacking.model.Transactions;
import com.cognixia.jump.dbfullstacking.repository.TransactionsRepository;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	@GetMapping(value = "/transactions/recent/{uid}")
	public Iterable<Transactions> findRecent(@PathVariable("uid") Integer uid)
	{
		List<Transactions> transactions = transactionsRepository.findByUid(uid);
		
		Collections.reverse(transactions);

		List<Transactions> RecentTransactions = transactions.stream().limit(5).collect(Collectors.toList());
		
		return RecentTransactions;
	}
	
	@PostMapping(value = "/transactions")
	public Transactions saveNew(@RequestBody Transactions transactions)
	{
		return transactionsRepository.save(transactions);
	}
}
