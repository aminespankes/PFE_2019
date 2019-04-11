package com.example.demo.repository;

import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>  {
	Booking findByEmailuser(String emailuser);
	Booking findByEmailavatar(String emailavatar);

}
