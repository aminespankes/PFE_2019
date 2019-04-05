package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Persone;

@Repository
public interface PersoneRepository extends JpaRepository<Persone, Integer> {
	
	Persone findByEmail(String email);


	

}
