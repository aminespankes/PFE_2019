package com.example.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.Avatar;
import com.example.demo.model.User;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.adminRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AvatarRepository avatarRepository;
	@Autowired
	private adminRepository adminrepository;
	Optional<User> user=null;
	Optional<Avatar> avatar=null;
	Optional<Admin> admin=null;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		user = userRepository.findByEmailNul(username);
		avatar = avatarRepository.findByEmailNul(username);
		admin = adminrepository.findByEmailnul(username);
		 if(user!=null) {
			 return new MyUserDetails(user);
		        }
		        else if(avatar!=null) {
		        	return new MyUserDetails(avatar.get());
		        }else if(admin!=null)
		        {
		        	return new MyUserDetails(admin.get());
		        }else {
			throw new UsernameNotFoundException("utilisateur n'exist pas ");
	}
		
}
}
