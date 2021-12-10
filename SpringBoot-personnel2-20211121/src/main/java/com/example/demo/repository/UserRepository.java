package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
   
	
	public User findByUsernameAndPassword(String username, String password);

	public List<User> findByUsername(String username);
}
