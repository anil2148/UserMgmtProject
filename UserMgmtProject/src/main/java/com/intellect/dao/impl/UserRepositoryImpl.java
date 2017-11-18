package com.intellect.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.intellect.dao.UserRepository;
import com.intellect.model.User;

@Transactional
public class UserRepositoryImpl {

	@Autowired
	UserRepository userRepo;

	public User createUser(User user) {
		return userRepo.save(user);
	}

	public void deleteUser(Long user) {
		userRepo.delete(user);

	}

	public User updateUser(User user) {
		return userRepo.save(user);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}
}
