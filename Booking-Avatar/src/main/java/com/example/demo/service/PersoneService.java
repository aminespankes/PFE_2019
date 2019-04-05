package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Persone;

public interface PersoneService  {
	
	
	
	public Persone findPersoneByEmail(String email);
	
	public void savePersone(Persone persone);
	
	
	public List<Persone> listAll() ;
	
	
	Persone getPersoneById(int id);
	
	public void delete(int id);
	
	public void updatePersone(Persone persone);
	 
	  

}


