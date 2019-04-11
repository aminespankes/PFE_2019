package com.example.demo.service;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Persone;
import com.example.demo.repository.BookingRepository;
@Service("BookingServiceImp")
public class BookingServiceImp implements BookingService {
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Booking findByEmailuser(String emailuser) {
		return bookingRepository.findByEmailuser(emailuser);
		
	}

	@Override
	public Booking findByEmailavatar(String emailavatar) {
		return bookingRepository.findByEmailavatar(emailavatar);
	}

	@Override
	public void saveBooking(Booking booking) {
		bookingRepository.save(booking);
		
	}

	@Override
	public List<Booking> listAll() {
		 return (List<Booking>) bookingRepository.findAll();
	}

	@Override
	public Booking getBookingById(int id) {
		 return bookingRepository.getOne(id);
	}

	@Override
	public void delete(int id) {
		bookingRepository.deleteById(id);
		
	}

	

}
