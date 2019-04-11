package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Avatar;
import com.example.demo.model.Persone;
import com.example.demo.model.User;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AvatarAdminService;
import com.example.demo.service.ServicerResponseApi;

@RestController
public class ControllerApi {
	@Autowired
	AvatarRepository avatarRepository;
	@Autowired
	AvatarAdminService avatarAdminService;
	
	@GetMapping(path = { "/userHome/{email}", "/userHome/" })
	public ResponseEntity<Object> getAllUseres(@PathVariable(name = "email", required = false) Optional<String> email) {
		List<Avatar> avatar;
		avatarRepository.findAll();

		if (email.isPresent()) {
			String newEmail = email.get(); 
			avatar = avatarRepository.findLike(newEmail);
		} else {
			avatar = avatarRepository.findAll();
		}

		ServicerResponseApi response = new ServicerResponseApi();
		response.setData(avatar);
		response.setStatus("success");
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}
	
	
	
	
	
	
	
	

}
