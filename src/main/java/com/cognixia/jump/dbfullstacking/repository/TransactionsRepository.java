package com.cognixia.jump.dbfullstacking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.dbfullstacking.model.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer>
{
	List<Transactions> findByUid(Integer uid);
}
