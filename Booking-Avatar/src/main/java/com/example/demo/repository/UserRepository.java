package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM user WHERE email=?1"
			, nativeQuery = true)
	Optional<User>  findByEmailNul(String email);
	User findByEmail(String email);
	User findById(int id);
	
	
/*	@Query(value = "SELECT * FROM user WHERE email LIKE CONCAT('%',?1,'%') OR username LIKE CONCAT('%',?1,'%') OR city LIKE CONCAT('%',?1,'%')  OR country LIKE CONCAT('%',?1,'%')"
			, nativeQuery = true)
	List<User> findLike(String email);
	*/

}
