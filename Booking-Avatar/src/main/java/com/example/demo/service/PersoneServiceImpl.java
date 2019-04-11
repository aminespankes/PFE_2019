package com.example.demo.service;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.Persone;
import com.example.demo.model.Regi;

import com.example.demo.repository.PersoneRepository;
import com.example.demo.repository.RegiRepository;
import com.example.demo.repository.UserRepository;


@Service("PersoneServiceImpl")
public  class PersoneServiceImpl implements PersoneService{
	@Autowired
	private PersoneRepository personeRepository;
	
	@Autowired
    private RegiRepository roleRepository;
    
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Autowired
    PersoneService personeservice;
	@Autowired
	UserRepository userRepository;
    
    
   
    @Override
	public Persone findPersoneByEmail(String email) {
		return personeRepository.findByEmail(email);
	}
	
	

	@Override
	public void savePersone(Persone persone) {
		persone.setPassword(bCryptPasswordEncoder.encode(persone.getPassword()));
		//persone.setActive(1);
       // Regi personeRegi = roleRepository.findByRegi("ADMIN");
		 //persone.setRegis(new HashSet<Regi>(Arrays.asList(personeRegi)));
		/*if(persone.getActive()==1)
       
        { persone.setActive(1);
			Regi personeRegi1 = roleRepository.findByRegi("Avatar");
        persone.setRegis(new HashSet<Regi>(Arrays.asList(personeRegi1)));
        personeRepository.save(persone);}
		else 
			if(persone.getActive()==2)
			{
        
       
	*/		
				personeRepository.save(persone);
	}


	
	
	
	
	public List<Persone> listAll() {
        return (List<Persone>) personeRepository.findAll();
    }
     
   
    public void delete(int id) {
    	personeRepository.deleteById(id);
    }



	@Override
	public Persone getPersoneById(int id) {
		 return personeRepository.getOne(id);
	}



	@Override
	public void updatePersone(Persone persone) {
		personeservice.updatePersone(persone);
		  
	}



	
}

