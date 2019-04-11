package com.example.demo.service;

import com.example.demo.model.Avatar;
import com.example.demo.model.User;

public interface AvatarAdminService {
	public Avatar findAvatarByEmail(String email);
	
	public void savePersone(Avatar avatar);
	 
	
	public Avatar getAvatarById(int id);


	
}
