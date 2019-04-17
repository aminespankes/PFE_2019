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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Avatar;
import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AvatarAdminService;
import com.example.demo.service.BookingService;
import com.example.demo.service.UserAdminService;

@Controller
public class AvatarHome {
	

		@Autowired
		UserRepository userRepository;
		@Autowired
		UserAdminService userAdminService;
		@Autowired
		AvatarAdminService avatarAdminService;
		@Autowired
		AvatarRepository avatarRepository;
		@Autowired
		BookingService bookingService;
		@Autowired
		BookingRepository bookingRepository;
		
		/*--------------------------------Avatar-Home------------------------------*/
		@GetMapping(value="/avatar/avatarHome")
		public ModelAndView avatarHome(@ModelAttribute("booking") Booking booking,HttpServletRequest request){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Principal principal= request.getUserPrincipal();

			ModelAndView modelAndView = new ModelAndView();
			
			modelAndView.setViewName("/avatar/avatarHome");
			Avatar avatar = avatarAdminService.findAvatarByEmail(auth.getName());
			modelAndView.addObject("username", avatar.getUsername());
			modelAndView.addObject("booking" , bookingRepository.find1(principal.getName()));
			return modelAndView;
		}
		

		/*--------------------------------Booking Accepted-------------------------------*/
		@GetMapping(value="/avatar/bookingAccepted")
		public ModelAndView bookingAccepted(HttpServletRequest request){
			ModelAndView modelAndView = new ModelAndView();
			Principal principal= request.getUserPrincipal();
			
			//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			//User user = userAdminService.findUserByEmail(auth.getName());
			//modelAndView.addObject("username", user.getUsername());
			
			modelAndView.addObject("bookingacceptavatar" , bookingRepository.findacceptavatar(principal.getName()));
			modelAndView.setViewName("/avatar/bookingAccepted");
			
			return modelAndView;
			
		}
		
/*-------------------------------------Accept--------------------------*/

			@GetMapping(value="/acceptbookingavatar")
			 public ModelAndView acceptbookingavatar(@ModelAttribute("booking") Booking b ) {
				

				 Booking booking=bookingService.getBookingById(b.getId());
				booking.setActive(1);
				
				
				bookingService.saveBooking(booking);
				return new ModelAndView("redirect:/avatar/avatarHome");
			}
		
		
		
		
		
		
		
		/*--------------------------------Booking pending-------------------------------*/
		@RequestMapping(value="/avatar/bookingPending", method = RequestMethod.GET)
		public ModelAndView bookingpending(@ModelAttribute("booking") Booking booking,HttpServletRequest request){
			Principal principal= request.getUserPrincipal();
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("booking" , bookingRepository.find2(principal.getName()));
			modelAndView.setViewName("/avatar/bookingPending");
			
			
			return modelAndView;
			
		}

		
		/*--------------------------------Booking Historique-------------------------------*/
		@RequestMapping(value="/avatar/bookingHistorique", method = RequestMethod.GET)
		public ModelAndView bookingHistorique(){
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("/avatar/bookingHistorique");
			
			return modelAndView;
			
		}
		
		/*--------------------------------Settings compte-------------------------------*/
		
		@GetMapping(value="/ProfileSettingsAvatar/")
		    public String editCompteAvatar(HttpServletRequest request ,Model model) {
				Principal principal= request.getUserPrincipal();
				
				model.addAttribute("avatar", avatarRepository.findByEmail(principal.getName()));
				
		        return "avatar/ProfileSettingsAvatar";
		    }



			@PostMapping(value="/update1")
			 public ModelAndView editAVatar(@ModelAttribute("avatar") Avatar p ) {
				

				 Avatar avatar=avatarAdminService.getAvatarById(p.getId());
				 avatar.setName(p.getName());
				 avatar.setImage(p.getImage());
				 avatar.setNumtel(p.getNumtel());
				 avatar.setCountry(p.getCountry());
				 avatar.setCity(p.getCity());
				 avatar.setStreet(p.getStreet());
				 avatar.setZip(p.getZip());
				
				
				 avatarAdminService.savePersone(avatar);
				return new ModelAndView("redirect:/avatar/avatarHome");
			}
			
		
			/*--------------------------------Profile avatar-------------------------------*/
			@GetMapping(value="avatar/MyProfile")
		    public String AvatarProfile(HttpServletRequest request ,Model model) {
				Principal principal= request.getUserPrincipal();
				
				model.addAttribute("avatar", avatarRepository.findByEmail(principal.getName()));
				
		        return "avatar/MyProfile";
		    }
		
		
			/*--------------------------------Change Password-------------------------------*/ 
			
			@GetMapping(value="/avatar/ChangePasse") 
			    public String editMotPasseAvatar(HttpServletRequest request ,Model model) {
					Principal principal= request.getUserPrincipal();
					
					model.addAttribute("avatar", userRepository.findByEmail(principal.getName()));
					
			        return "avatar/ChangePasse";
			    }



				@PostMapping(value="/update4")
				 public ModelAndView editPasseAvatar(@ModelAttribute("avatar") Avatar p ) {
					

					Avatar avatar=avatarAdminService.getAvatarById(p.getId());
					avatar.setPassword(p.getPassword());
					
					
					avatarAdminService.savePersone(avatar);
					return new ModelAndView("redirect:/avatar/avatarHome");
				}
		
		             
		
		
		
		
		
}
