package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Booking;
import com.example.demo.model.Persone;
import com.example.demo.model.User;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.UserAdminService;


@Controller
public class UserHome {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserAdminService userAdminService;
	
	@Autowired
	AvatarRepository avatarRepository;
	@Autowired
	BookingService bookingService;
	@Autowired
	BookingRepository bookingRepository;
	
	/*--------------------------------User-Home------------------------------*/
	@RequestMapping(value="/user/userHome", method = RequestMethod.GET)
	public ModelAndView userHome(@ModelAttribute("booking") Booking booking,HttpServletRequest request){
		
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Principal principal= request.getUserPrincipal();
		User user = userAdminService.findUserByEmail(auth.getName());
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("lists",userRepository.findAll());
		modelAndView.addObject("pending" , bookingRepository.find(principal.getName()));
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
			
		
			
		
			
		modelAndView.setViewName("/user/userHome");
		return modelAndView;
		
	
	
}
	
	
	
	
	/*--------------------------------Booking Accepted-------------------------------*/
	@GetMapping(value="/user/bookingUser")
	public ModelAndView bookingUser(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		/*----------------notification---------------*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Principal principal= request.getUserPrincipal();
		User user = userAdminService.findUserByEmail(auth.getName());
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("pending" , bookingRepository.find(principal.getName()));
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
		
		
		
		modelAndView.setViewName("/user/bookingUser");
		return modelAndView;
		
	}
	
	/*--------------------------------Booking pending User-------------------------------*/
	@GetMapping(value="/user/BookingPending")
	public ModelAndView bookingpendinguser(@ModelAttribute("booking") Booking booking,HttpServletRequest request){
		
	
		ModelAndView modelAndView = new ModelAndView();
		/*----------------notification---------------*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Principal principal= request.getUserPrincipal();
		User user = userAdminService.findUserByEmail(auth.getName());
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("pending" , bookingRepository.find(principal.getName()));
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
			
		
		
		
		
		
		modelAndView.addObject("pending" , bookingRepository.find(principal.getName()));
		modelAndView.setViewName("/user/BookingPending");
		return modelAndView;
		
	}
	
	

	
	
	
	

	
	/*--------------------------------Booking Historique-------------------------------*/
	@RequestMapping(value="/user/Bookinghistorical", method = RequestMethod.GET)
	public ModelAndView bookingHistoriqueUser(@ModelAttribute("booking") Booking booking,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		/*----------------notification---------------*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Principal principal= request.getUserPrincipal();
		User user = userAdminService.findUserByEmail(auth.getName());
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("pending" , bookingRepository.find(principal.getName()));
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
			
		
		
		
		
		
		
		modelAndView.setViewName("/user/Bookinghistorical");
		return modelAndView;
		
	}
	
	/*--------------------------------Booking Cancelation-------------------------------*/
	@RequestMapping(value="/user/cancellationUser", method = RequestMethod.GET)
	public ModelAndView bookingCancelationUser(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/cancellationUser");
		
		return modelAndView;
		
	}
	
	
	
	
	
	/*--------------------------------Settings compte-------------------------------*/
	
@GetMapping(value="/ProfileSettingsUser/")
    public String edit(@ModelAttribute("booking") Booking booking,HttpServletRequest request ,Model model) {
		
	
	
	
	/*----------------notification---------------*/
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	Principal principal= request.getUserPrincipal();
	User user = userAdminService.findUserByEmail(auth.getName());
	model.addAttribute("username", user.getUsername());
	model.addAttribute("pending" , bookingRepository.find(principal.getName()));
	List<Integer>iddd=bookingRepository.boo(principal.getName());
	
	for(int i = 0 ; i < iddd.size(); i++)
		
	{
		model.addAttribute("aaa",iddd.get(i));
	}
	model.addAttribute("confirmer" , bookingRepository.find3(principal.getName()));
	model.addAttribute("countnotif" , bookingRepository.countnotif(principal.getName()));
	int a=bookingRepository.countnotif(principal.getName());
	if (a!=0)
	{
		model.addAttribute("msgnoti" , "Confirm Your Reservation");
	} 
	model.addAttribute("msgnoti1" , "Reservation Canceled");
		
		
		
		
		model.addAttribute("user", userRepository.findByEmail(principal.getName()));
		return "user/ProfileSettingsUser";
    }

	@PostMapping(value="/update")
	 public ModelAndView editUSer(@ModelAttribute("user") User p ) {
 User user=userAdminService.getUserById(p.getId());
		user.setName(p.getName());
		user.setImage(p.getImage());
		user.setNumtel(p.getNumtel());
		user.setCountry(p.getCountry());
		user.setCity(p.getCity());
		user.setStreet(p.getStreet());
		user.setZip(p.getZip());
		userAdminService.savePersone(user);
		return new ModelAndView("redirect:/user/userHome");
	}
	
	
	
	
	/*--------------------------------View Profile AVATAR-------------------------------*/
	
	@GetMapping("/user/ViewAVA")
	public String AVView(@ModelAttribute("booking") Booking booking,HttpServletRequest request,@RequestParam("id") int id,Model model){
		
						
						/*----------------notification---------------*/
						Authentication auth = SecurityContextHolder.getContext().getAuthentication();
						
						Principal principal= request.getUserPrincipal();
						User user = userAdminService.findUserByEmail(auth.getName());
						model.addAttribute("username", user.getUsername());
						model.addAttribute("pending" , bookingRepository.find(principal.getName()));
						List<Integer>iddd=bookingRepository.boo(principal.getName());
						
						for(int i = 0 ; i < iddd.size(); i++)
							
						{
							model.addAttribute("aaa",iddd.get(i));
						}
						model.addAttribute("confirmer" , bookingRepository.find3(principal.getName()));
						model.addAttribute("countnotif" , bookingRepository.countnotif(principal.getName()));
						int a=bookingRepository.countnotif(principal.getName());
						if (a!=0)
						{
							model.addAttribute("msgnoti" , "Confirm Your Reservation");
						} 
						model.addAttribute("msgnoti1" , "Reservation Canceled");
						
		
		
		model.addAttribute("users", avatarRepository.findById(id));
		return "user/ViewAVA";
		
	
	}
	
	/*--------------------------------ProfileUser-------------------------------*/
	@GetMapping(value="user/MyProfile")
    public String UserProfile(@ModelAttribute("booking") Booking booking,HttpServletRequest request ,Model model) {
						
						
			
		/*----------------notification---------------*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Principal principal= request.getUserPrincipal();
		User user = userAdminService.findUserByEmail(auth.getName());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("pending" , bookingRepository.find(principal.getName()));
		List<Integer>iddd=bookingRepository.boo(principal.getName());
		
		for(int i = 0 ; i < iddd.size(); i++)
			
		{
			model.addAttribute("aaa",iddd.get(i));
		}
		model.addAttribute("confirmer" , bookingRepository.find3(principal.getName()));
		model.addAttribute("countnotif" , bookingRepository.countnotif(principal.getName()));
		int a=bookingRepository.countnotif(principal.getName());
		if (a!=0)
		{
			model.addAttribute("msgnoti" , "Confirm Your Reservation");
		} 
		model.addAttribute("msgnoti1" , "Reservation Canceled");
		
		
		
		
		
		
		
		model.addAttribute("user", userRepository.findByEmail(principal.getName()));
		return "user/MyProfile";
    }


	
	/*--------------------------------Settings Password-------------------------------*/
	
	@GetMapping(value="/user/ChangePasse")
	    public String editMotPasse(@ModelAttribute("booking") Booking booking,HttpServletRequest request ,Model model ) {
			
		
		/*----------------notification---------------*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Principal principal= request.getUserPrincipal();
		User user = userAdminService.findUserByEmail(auth.getName());
		model.addAttribute("username", user.getUsername());
		
		model.addAttribute("pending" , bookingRepository.find(principal.getName()));
		List<Integer>iddd=bookingRepository.boo(principal.getName());
		
		for(int i = 0 ; i < iddd.size(); i++)
			
		{
			model.addAttribute("aaa",iddd.get(i));
		}
		model.addAttribute("confirmer" , bookingRepository.find3(principal.getName()));
		model.addAttribute("countnotif" , bookingRepository.countnotif(principal.getName()));
		int a=bookingRepository.countnotif(principal.getName());
		if (a!=0)
		{
			model.addAttribute("msgnoti" , "Confirm Your Reservation");
		} 
		model.addAttribute("msgnoti1" , "Reservation Canceled");
		
			
			
			model.addAttribute("user", userRepository.findByEmail(principal.getName()));
			 return "user/ChangePasse";
	    }


/*
		@PostMapping(value="/update3")
		 public ModelAndView editPasse(@ModelAttribute("user") User p ) {
			

			 User user=userAdminService.getUserById(p.getId());
			 user.setPassword(p.getPassword());
			
			
			userAdminService.savePersone(user);
			return new ModelAndView("redirect:/user/userHome");
		}
	
	
	*/

	/*-----------------------------cancel booking-----------------------*/

	@GetMapping("/deletebooking")
	public String cancelBooking(@RequestParam("id") int id) {
		bookingRepository.deleteById(id);
	    return "redirect:/user/BookingPending";       
	}

}