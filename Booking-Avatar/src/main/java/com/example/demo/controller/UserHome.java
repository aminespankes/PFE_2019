package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserAdminService;


@Controller
public class UserHome {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserAdminService userAdminService;
	
	@RequestMapping(value="/user/userHome", method = RequestMethod.GET)
	public ModelAndView userHome(){
		
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.setViewName("/user/userHome");
		//modelAndView.addObject("lists",userRepository.findAll());
		User user = userAdminService.findUserByEmail(auth.getName());
		//modelAndView.addObject("UserName",userRepository.findAll());
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("lists",userRepository.findAll());
		
		
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/user/bookingUser", method = RequestMethod.GET)
	public ModelAndView bookingUser(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/bookingUser");
		//modelAndView.addObject("lists",userRepository.findAll());
		
		return modelAndView;
		
	}
/*
	@RequestMapping(value="/user/ProfileSettingsUser", method = RequestMethod.GET)
	public ModelAndView ProfileSettingsUser(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/ProfileSettingsUser");
		//modelAndView.addObject("lists",userRepository.findAll());
		
		return modelAndView;
		
	}
	

	
	@RequestMapping("/ProfileSettingsUser")
	public ModelAndView showEditProfileSettingsUser(@RequestParam(value="id",required =   
			true) Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/ProfileSettingsUser");
	   // ModelAndView mav = new ModelAndView("/user/ProfileSettingsUser");
	    User user = userAdminService.getUserById(id);
	   // mav.addObject("user", user);
	    modelAndView.addObject("user",user);
	  //  return mav;
	return modelAndView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		userAdminService.savePersone(user);
	     
	    return "redirect:/user/userHome";
	}
	
*/	
	
	
	
	
	@GetMapping(value="/ProfileSettingsUser/")
    public String edit(HttpServletRequest request ,Model model) {
		Principal principal= request.getUserPrincipal();
		
		model.addAttribute("user", userRepository.findByEmail(principal.getName()));
		
        return "user/ProfileSettingsUser";
    }
	
	
}