package com.epassport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epassport.entities.User;
import com.epassport.services.UserService;

@RestController
public class RegisterController {
		
	@Autowired
	UserService userService;
	
	@GetMapping("register")
	public ModelAndView getRegistrationPage() {
		User user=new User();
		return new ModelAndView("register","user",user);
	}
	
	@PostMapping("register")
	public ModelAndView registerUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return new ModelAndView("redirect:/epassport/login");
	}
	
}
