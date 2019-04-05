package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Regi;

public interface RegiRepository extends JpaRepository<Regi, Integer> {
	Regi findByRegi(String regi);

}
