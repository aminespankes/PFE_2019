package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.model.User;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserAdminService;


@Controller
public class UserHome {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserAdminService userAdminService;
	
	@Autowired
	AvatarRepository avatarRepository;
	
	/*--------------------------------User-Home------------------------------*/
	@RequestMapping(value="/user/userHome", method = RequestMethod.GET)
	public ModelAndView userHome(){
		
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.setViewName("/user/userHome");
		
		User user = userAdminService.findUserByEmail(auth.getName());
	
		modelAndView.addObject("username", user.getUsername());
		
		modelAndView.addObject("lists",userRepository.findAll());
		
		
		
		return modelAndView;
		
	}
	
	/*--------------------------------Booking Accepted-------------------------------*/
	@RequestMapping(value="/user/bookingUser", method = RequestMethod.GET)
	public ModelAndView bookingUser(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/bookingUser");
		//modelAndView.addObject("lists",userRepository.findAll());
		
		return modelAndView;
		
	}
	
	/*--------------------------------Booking pending User-------------------------------*/
	@GetMapping(value="/user/BookingPending")
	public ModelAndView bookingpendinguser(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/BookingPending");
		
		return modelAndView;
		
	}

	
	/*--------------------------------Booking Historique-------------------------------*/
	@RequestMapping(value="/user/Bookinghistorical", method = RequestMethod.GET)
	public ModelAndView bookingHistoriqueUser(){
		ModelAndView modelAndView = new ModelAndView();
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
    public String edit(HttpServletRequest request ,Model model) {
		Principal principal= request.getUserPrincipal();
		
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
	public String AVView(@RequestParam("id") int id,Model model){
		
		model.addAttribute("users", avatarRepository.findById(id));
		
		
		return "user/ViewAVA";
		
	
	}
	
	/*--------------------------------ProfileUser-------------------------------*/
	@GetMapping(value="user/MyProfile")
    public String UserProfile(HttpServletRequest request ,Model model) {
		Principal principal= request.getUserPrincipal();
		
		model.addAttribute("user", userRepository.findByEmail(principal.getName()));
		
        return "user/MyProfile";
    }


	/*--------------------------------Formulaire reservation-------------------------------*/
	@GetMapping(value="/user/FormulaireRes")
	public ModelAndView FormulaireRes(){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/user/FormulaireRes");
		
		return modelAndView;
	}
	
	/*--------------------------------Settings compte-------------------------------*/
	
	@GetMapping(value="/ChangePasse/")
	    public String editMotPasse(HttpServletRequest request ,Model model) {
			Principal principal= request.getUserPrincipal();
			
			model.addAttribute("user", userRepository.findByEmail(principal.getName()));
			
	        return "user/ChangePasse";
	    }



		@PostMapping(value="/update3")
		 public ModelAndView editPasse(@ModelAttribute("user") User p ) {
			

			 User user=userAdminService.getUserById(p.getId());
			 user.setPassword(p.getPassword());
			
			
			userAdminService.savePersone(user);
			return new ModelAndView("redirect:/user/userHome");
		}
	
	
	



}