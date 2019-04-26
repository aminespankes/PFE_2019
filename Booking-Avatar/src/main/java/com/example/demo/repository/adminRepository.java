package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
import com.example.demo.model.Persone;


@Repository
public interface adminRepository extends JpaRepository<Admin, Integer> {
	@Query(value="select * from admin where email=?1",nativeQuery=true)
	Optional<Admin> findByEmailnul(String email);
	Admin findByEmail(String email);

}
