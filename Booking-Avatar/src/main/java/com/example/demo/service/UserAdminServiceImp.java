package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service("UserAdminServiceImp")
public class UserAdminServiceImp implements UserAdminService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserById(int id) {
		return userRepository.getOne(id);
	}

	@Override
	public void savePersone(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	
	
}
