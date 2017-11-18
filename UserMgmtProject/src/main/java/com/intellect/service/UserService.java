package com.intellect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.dao.impl.UserRepositoryImpl;
import com.intellect.model.User;

@Service
public class UserService {
	@Autowired
	UserRepositoryImpl userRepo;

	public User createUser(User user) {
		System.out.println("UserService : createUser method");
		
		return userRepo.createUser(user);
	}

	public void deleteUser(long user) {
		System.out.println("UserService : deleteUser method");
		
		userRepo.deleteUser(user);
	}

	public User updateUser(User user) {
		System.out.println("UserService : updateUser method");
		
		return userRepo.updateUser(user);

	}

	public List<User> findAll() {
		System.out.println("UserService : findAll method");
		
		return userRepo.findAll();
	}
}
