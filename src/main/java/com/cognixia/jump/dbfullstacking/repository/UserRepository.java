package com.cognixia.jump.dbfullstacking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.dbfullstacking.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	User findByUserId(Integer userId);
}
