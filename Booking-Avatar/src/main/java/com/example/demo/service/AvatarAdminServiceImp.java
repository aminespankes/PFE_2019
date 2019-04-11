package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Avatar;
import com.example.demo.repository.AvatarRepository;

@Service("AvatarAdminServiceImp")
public class AvatarAdminServiceImp implements AvatarAdminService {
	String req;
	@Autowired
	AvatarRepository avatarRepository;

	@Override
	public Avatar getAvatarById(int id) {
		 return avatarRepository.getOne(id);
	}

	@Override
	public void savePersone(Avatar avatar) {
		avatarRepository.save(avatar);
		
	}
	
	public List<Avatar> getAvatarByMail(String email) {
		// TODO Auto-generated method stub
		List<Avatar> utilisateurs=null;
		if(email.equals("ALL")) {
			 utilisateurs=avatarRepository.findAll();
		}
		else {
			utilisateurs=avatarRepository.findLike(email);
		}
		return utilisateurs ;
	}

	@Override
	public Avatar findAvatarByEmail(String email) {
		return avatarRepository.findByEmail(email);
	}
	

	
	

}
