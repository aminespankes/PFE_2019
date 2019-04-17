package com.example.demo.service;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Booking;

public interface BookingService {
public Booking findByEmailuser(String emailuser);

public Booking findByEmailavatar(String emailavatar);


	
	public void saveBooking(Booking booking);
	
	
	public List<Booking> listAll() ;
	
	
	Booking getBookingById(int id);
	
	public void delete(int id);
	
	
	
	

}
