package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persone;
import com.example.demo.repository.PersoneRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private PersoneRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Persone user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("utilisateur n'exist pas ");
		return new MyUserDetails(user);
	}

}
