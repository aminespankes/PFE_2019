package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Avatar;



public interface AvatarRepository extends JpaRepository<Avatar, Integer>{
	@Query(value = "SELECT * FROM avatar WHERE email=?1"
			, nativeQuery = true)

	Optional<Avatar> findByEmailNul(String email);
	Avatar findByEmail(String email);
	@Query(value = "SELECT * FROM avatar WHERE email LIKE CONCAT('%',?1,'%') OR username LIKE CONCAT('%',?1,'%') OR city LIKE CONCAT('%',?1,'%')  OR country LIKE CONCAT('%',?1,'%')"
			, nativeQuery = true)
	List<Avatar> findLike(String email);//
	Avatar findById(int id);
	

}
