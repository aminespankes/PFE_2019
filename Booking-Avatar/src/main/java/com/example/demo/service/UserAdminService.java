package com.example.demo.service;


import com.example.demo.model.Persone;
import com.example.demo.model.User;

public interface UserAdminService  {
	public User findUserByEmail(String email);
	
	public void savePersone(User user);
	public User getUserById(int id);

}
