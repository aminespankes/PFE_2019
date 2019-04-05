package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.demo.model.Persone;

public interface AppCrudRepo extends CrudRepository<Persone,Long>{
	
	///List<Persone> findByUsername(String username);

	

}
