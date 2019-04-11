package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
import com.example.demo.model.Persone;


@Repository
public interface adminRepository extends JpaRepository<Admin, Integer> {
	Admin findByEmail(String email);

}
