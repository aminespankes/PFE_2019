package com.example.demo.service;

import com.example.demo.model.Avatar;

public interface AvatarAdminService {
	
	
	public void savePersone(Avatar avatar);
	 
	
	Avatar getAvatarById(int id);
}
