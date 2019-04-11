package com.example.demo.controller;



import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.model.Avatar;
import com.example.demo.model.Persone;
import com.example.demo.model.User;
import com.example.demo.repository.AppCrudRepo;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.PersoneRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.adminRepository;
import com.example.demo.service.AvatarAdminService;
import com.example.demo.service.PersoneService;
import com.example.demo.service.PersoneServiceImpl;
import com.example.demo.service.UserAdminService;
import com.example.demo.service.adminService;

@Controller
public class AdminHome {
	
	
	
	@Autowired 
	PersoneService personeService;
	@Autowired
	AppCrudRepo appcrudrepo;////////////////////////////
	
	@Autowired
	PersoneRepository personeRepository;
	@Autowired
	AvatarRepository avatarRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AvatarAdminService avatarAdminService;
	@Autowired
	UserAdminService userAdminService;
	@Autowired
	adminRepository adminrepository ;
	@Autowired
	adminService adminservice;
	
	
	@Autowired
    public void setPersoneService(PersoneService personeService) {
        this.personeService = personeService;
    }
	

	
	/*-----------------------------cnx-----------------------*/
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		if (request.isUserInRole("Admin")) {
			return "redirect:/admin/HomeAdmin";
		}
		else
			if(request.isUserInRole("Avatar"))
		return "redirect:/avatar/avatarHome";
			else
				return "redirect:/user/userHome";
}
	
	
	/*-----------------------------Home Admin-----------------------*/
	@RequestMapping(value="/admin/HomeAdmin", method = RequestMethod.GET)
	public ModelAndView HomeAdmin(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Persone persone = personeService.findPersoneByEmail(auth.getName());
		
		modelAndView.addObject("adminName",adminrepository.findAll());
		modelAndView.setViewName("/admin/HomeAdmin");
		modelAndView.addObject("lists",personeRepository.findAll());////////////////////
		
		 
		return modelAndView;
	}
	
	/*-----------------------------avatarAdmin-----------------------*/
	@RequestMapping(value="/admin/avatarAdmin", method = RequestMethod.GET)
	public ModelAndView avatarAdmin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/avatarAdmin");
		modelAndView.addObject("lists",avatarRepository.findAll());
		
		return modelAndView;
		
	}
	
	
	/*-----------------------------userAdmin-----------------------*/

	
	@RequestMapping(value="/admin/userAdmin", method = RequestMethod.GET)
	public ModelAndView userAdmin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/userAdmin");
		modelAndView.addObject("lists",userRepository.findAll());
		
		return modelAndView;
		
	}
	
	/*-----------------------------BookingAdmin-----------------------*/

	
	@RequestMapping(value="/admin/bookingAdmin", method = RequestMethod.GET)
	public ModelAndView bookingAdmin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/bookingAdmin");
		modelAndView.addObject("lists",userRepository.findAll());
		
		return modelAndView;
		
	}
	
	
	
	/*-----------------------------View-----------------------*/

	
	@RequestMapping("/View")
    public String showPersone(@RequestParam("id") int id, Model model) {
        model.addAttribute("lists", personeService.getPersoneById(id));
        return "admin/View";
    }
	
	/*-----------------------------ViewAdminAvatar-----------------------*/

	@RequestMapping("/ViewAvatar")
    public String showAvatar(@RequestParam("id") int id, Model model) {
        model.addAttribute("lists", avatarAdminService.getAvatarById(id));
        return "admin/ViewAvatar";
    }
	
	/*-----------------------------ViewAdminUser-----------------------*/

	@RequestMapping("/ViewUser")
    public String showUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("lists", userAdminService.getUserById(id));
        return "admin/ViewUser";
    }
	
	
	
	/*-----------------------------delete-----------------------*/

	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam("id") int id) {
		personeRepository.deleteById(id);
	    return "redirect:/admin/HomeAdmin";       
	}
	
	
	/*-----------------------------AcceptInscription-----------------------*/

	
	@RequestMapping(value="/add")
	public String edit(@RequestParam("id") int id,ModelMap model)
	{
		Persone persone=(Persone) personeService.getPersoneById(id);
		model.addAttribute("persone", persone);
		if (persone.getRole().equals("Avatar")) {
			Avatar avatar=new Avatar();
			avatar.setImage(persone.getImage());
			avatar.setName(persone.getName());
			avatar.setEmail(persone.getEmail());
			avatar.setCity(persone.getCity());
			avatar.setCountry(persone.getCountry());
			avatar.setNumtel(persone.getNumtel());
			avatar.setGender(persone.getGender());
			avatar.setDate(persone.getDate());
			avatar.setStreet(persone.getStreet());
			avatar.setPassword(persone.getPassword());
			avatar.setUsername(persone.getUsername());
			avatar.setZip(persone.getZip());
			avatar.setRole(persone.getRole());
			
			personeRepository.deleteById(id);
			avatarAdminService.savePersone(avatar);
			
		}else if(persone.getRole().equals("User"))
		{
			User user=new User();
			user.setImage(persone.getImage());
			user.setName(persone.getName());
			user.setEmail(persone.getEmail());
			user.setCity(persone.getCity());
			user.setCountry(persone.getCountry());
			user.setNumtel(persone.getNumtel());
			user.setGender(persone.getGender());
			user.setDate(persone.getDate());
			user.setStreet(persone.getStreet());
			user.setPassword(persone.getPassword());
			user.setUsername(persone.getUsername());
			user.setZip(persone.getZip());
			user.setRole(persone.getRole());
			
			personeRepository.deleteById(id);
			userAdminService.savePersone(user);
			
		}
		
		return"redirect:/admin/HomeAdmin";
	}
	/*
	@RequestMapping(value="/addsave", method = RequestMethod.POST)
	 public ModelAndView editPersone(@ModelAttribute("persone") Persone p) {
		Persone persone=personeService.getPersoneById(p.getId());
		persone.setActive(p.getActive());
		personeService.savePersone(persone);
		return new ModelAndView("redirect:/admin/HomeAdmin");
		
		
	}*/
	
	
	
	
	
	
		
		
		
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	


