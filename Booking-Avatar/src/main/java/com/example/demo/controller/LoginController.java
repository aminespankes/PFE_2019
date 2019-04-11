package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Persone;
import com.example.demo.repository.AppCrudRepo;
import com.example.demo.service.PersoneService;
import com.example.demo.service.PersoneServiceImpl;

@Controller
public class LoginController {
	
	
	
	@Autowired
	private PersoneService personeService;
	
	

	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Persone persone = new Persone();
		modelAndView.addObject("persone", persone);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	
	
	@PostMapping("/registration")
	public ModelAndView createNewPersone(@ModelAttribute("persone") Persone persone,/*@Valid Persone persone,*/ BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Persone userExists = personeService.findPersoneByEmail(persone.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			 personeService.savePersone(persone);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("persone", new Persone());
			modelAndView.setViewName("registration");
			//System.out.println("name="+persone.getName());
			//System.out.println("email="+persone.getEmail());

			
		}
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
