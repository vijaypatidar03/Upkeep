package com.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
}
