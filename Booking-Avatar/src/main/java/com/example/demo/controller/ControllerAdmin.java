package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.repository.AppCrudRepo;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.PersoneRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.adminRepository;
import com.example.demo.service.AvatarAdminService;
import com.example.demo.service.PersoneService;
import com.example.demo.service.UserAdminService;
import com.example.demo.service.adminService;

@Controller
public class ControllerAdmin {
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
	
	
	
	
	
	/*-----------------------------addAdmin-----------------------*/

	@GetMapping(value="/admin/addAdmin")
	public ModelAndView addAdmin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/addAdmin");
		//modelAndView.addObject("lists",userRepository.findAll());
		return modelAndView;
		
	}
	
	@PostMapping("/addAdmin")
	public ModelAndView createNewAdmin(@ModelAttribute("admin") Admin admin,/*@Valid Persone persone,*/ BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Admin userExists = adminservice.findAdminByEmail(admin.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addAdmin");
		} else {
			adminservice.saveAdmin(admin);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("admin", new Admin());
			modelAndView.setViewName("admin/HomeAdmin");
			
			
		}
		return modelAndView;
	}
	
	
	/*--------------------------------ProfileAdmin-------------------------------*/
	@GetMapping(value="admin/MyProfile")
    public String edit(HttpServletRequest request ,Model model) {
		Principal principal= request.getUserPrincipal();
		
		model.addAttribute("admin", adminrepository.findByEmail(principal.getName()));
		
        return "admin/MyProfile";
    }
	
	
	

}
