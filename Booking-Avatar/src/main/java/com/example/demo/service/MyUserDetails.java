package com.example.demo.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Admin;
import com.example.demo.model.Avatar;
import com.example.demo.model.Persone;
import com.example.demo.model.User;


public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	//Persone  user;
	Optional<User> user=null;
	Avatar avatar=null;
	Admin admin=null;
	
	String ROLE_PREFIX = "ROLE_";


	public MyUserDetails(Optional<User> user2) {
		super();
		this.user = user2;
		
	}
	public MyUserDetails(Avatar avatar) {
		super();
		this.avatar=avatar;	
	}
	public MyUserDetails(Admin admin) {
		super();
		this.admin=admin;
	}
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        if(user!=null) {
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + user.get().getRole()));
        }
        else if(avatar!=null) {
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + avatar.getRole()));
        }else
        {
        	list.add(new SimpleGrantedAuthority(ROLE_PREFIX +"ADMIN"));
        }
        return list;
    }/*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("Admin"));
	}*/

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.get().getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.get().getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

