package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Avatar;
import com.example.demo.model.Booking;
import com.example.demo.model.Persone;
import com.example.demo.model.User;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AvatarAdminService;
import com.example.demo.service.BookingService;
import com.example.demo.service.UserAdminService;

@Controller
public class BookingController {

	@Autowired
	BookingService bookingService;
	@Autowired
	AvatarRepository avatarRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AvatarAdminService avatarAdminService;
	@Autowired
	UserAdminService userAdminService;
 	
	/*
	@PostMapping("/booking")
	public ModelAndView createNewBooking(@ModelAttribute("booking") Booking booking, BindingResult bindingResult,HttpServletRequest request,@ModelAttribute("avatar") Avatar a,@ModelAttribute("user") User p) {
		ModelAndView modelAndView = new ModelAndView();
		
		Principal principal= request.getUserPrincipal();
		
		//modelAndView.addObject("avatar", avatarRepository.findByEmail(principal.getName()));
		modelAndView.addObject("user",  userRepository.findByEmail(principal.getName()));
		
		Avatar avatar=(Avatar) avatarAdminService.getAvatarById(a.getId());
		
		User user=(User) userAdminService.getUserById(p.getId());	
		
		booking.setAvatarname(avatar.getUsername());
		booking.setUsername(user.getUsername());
		booking.setEmailavatar(avatar.getEmail());
		booking.setEmailuser(user.getEmail());
		
		
		
		bookingService.saveBooking(booking);
			modelAndView.addObject("Message", "reservation sent, wait for the acceptance of avatar");
			modelAndView.addObject("booking", new Booking());
			modelAndView.setViewName("userHome");
			

			
		
		return modelAndView;
	}*/
	
	
	
}
