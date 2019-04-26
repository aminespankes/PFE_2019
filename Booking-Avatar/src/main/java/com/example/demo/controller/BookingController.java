package com.example.demo.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Avatar;
import com.example.demo.model.Booking;
import com.example.demo.model.Persone;
import com.example.demo.model.User;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.BookingRepository;
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
	@Autowired
	BookingRepository bookingRepository;
	
	

	/*--------------------------------Formulaire reservation-------------------------------*/
	@GetMapping(value="/user/FormulaireRes")
	public ModelAndView FormulaireRes(@ModelAttribute("booking") Booking booking,HttpServletRequest request ,Model model,@RequestParam("id") int id){
		ModelAndView modelAndView = new ModelAndView();
							
		/*----------------notification---------------*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		Principal principal= request.getUserPrincipal();
		User user = userAdminService.findUserByEmail(auth.getName());
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("pending" , bookingRepository.find(principal.getName(),date));
		List<Integer>iddd=bookingRepository.boo(principal.getName());
		
		for(int i = 0 ; i < iddd.size(); i++)
			
		{
			modelAndView.addObject("aaa",iddd.get(i));
		}
		modelAndView.addObject("confirmer" , bookingRepository.find3(principal.getName()));
		modelAndView.addObject("countnotif" , bookingRepository.countnotif(principal.getName()));
		int a=bookingRepository.countnotif(principal.getName());
		if (a!=0)
		{
		modelAndView.addObject("msgnoti" , "Confirm Your Reservation");
		} 
			modelAndView.addObject("msgnoti1" , "Reservation Canceled");
							
			/*----------------notification---------------*/
		
			
			
			
			
			
			model.addAttribute("booking", avatarRepository.findById(id));
			modelAndView.setViewName("/user/FormulaireRes");
		
			return modelAndView;
	}
	

	
	/*--------------------------------Make reservation -----------------------*/
	
	@PostMapping("/user/BookingPending")
	public ModelAndView createNewPersone(@ModelAttribute("booking") Booking booking, BindingResult bindingResult,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Principal principal= request.getUserPrincipal();
		User user=userRepository.findByEmail(principal.getName());
		booking.setEmailuser(user.getEmail());
		booking.setUsername(user.getUsername());
		booking.setUserimage(user.getImage());
		booking.setUsercountry(user.getCountry());
		booking.setUsercity(user.getCity());
		booking.setUserphone(user.getNumtel());
		bookingService.saveBooking(booking);
			
			modelAndView.addObject("booking", new Booking());
			
			modelAndView.addObject("pending" , bookingRepository.find(principal.getName(),date));
			
			modelAndView.setViewName("/user/BookingPending");
		return modelAndView;
	}
	
	/*--------------------------------Booking Confirmer-------------------------------*/
	@GetMapping(value="/user/ConfirmeBooking")
	public ModelAndView bookingConfirmed(@ModelAttribute("booking") Booking booking,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/ConfirmeBooking");
		
		/* pour le notification*/
		Principal principal= request.getUserPrincipal();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userAdminService.findUserByEmail(auth.getName());//username online
		modelAndView.addObject("username", user.getUsername());//username online
		
		modelAndView.addObject("confirmer" , bookingRepository.find3(principal.getName()));//reservation pour confiremr
		modelAndView.addObject("countnotif" , bookingRepository.countnotif(principal.getName()));//countnbre de noti
		modelAndView.addObject("msgnoti" , "Confirm Your Reservation");//notif
		modelAndView.addObject("msgnoti1" , "Reservation Canceled");//notif

	    
	
		return modelAndView;
		
	}
	
	/*--------------------------------Booking Paiements-------------------------------*/
	@GetMapping("/user/payment")
	public ModelAndView bookingPaiements(@ModelAttribute("booking") Booking booking,HttpServletRequest request,@RequestParam("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		
		
		/* pour le notification*/
		Principal principal= request.getUserPrincipal();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userAdminService.findUserByEmail(auth.getName());//username online
		modelAndView.addObject("username", user.getUsername());//username online
		
		modelAndView.addObject("confirmer" , bookingRepository.find3(principal.getName()));//reservation pour confiremr
		modelAndView.addObject("countnotif" , bookingRepository.countnotif(principal.getName()));//countnbre de noti
		modelAndView.addObject("msgnoti" , "Confirm Your Reservation");//notif
		modelAndView.addObject("msgnoti1" , "Reservation Canceled");//notif

	    modelAndView.addObject("user", userRepository.findByEmail(principal.getName()));
	    modelAndView.addObject("booking", bookingRepository.getOne(id));
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		 modelAndView.addObject("date",dateFormat.format(date));
	    
	    
	    
		modelAndView.setViewName("/user/payment");
		return modelAndView;
		
	}
	/*------------------Confirmer payment ------------*/
	@GetMapping("/user/paymentValider")
	public String paymentValider(@RequestParam("id") int id,@ModelAttribute("booking") Booking b) {
		
		 Booking booking=bookingService.getBookingById(b.getId());
			booking.setPayement(1);
			bookingService.saveBooking(booking);
	    return "redirect:/user/bookingUser";       
	}
	
	
	
}
