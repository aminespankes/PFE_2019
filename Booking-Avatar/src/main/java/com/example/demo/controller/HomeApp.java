package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeApp {
	
	@RequestMapping(value= {"/HomeApp"}, method = RequestMethod.GET)
	public ModelAndView HomeApplication(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("HomeApp");
		return modelAndView;
	}
	
	
	

}
