package com.epassport.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epassport.entities.User;
import com.epassport.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public ModelAndView getLoginPage() {
		return new ModelAndView("login");
	}
	
	@GetMapping("/")
	public ModelAndView home(Principal principal) {
		if(principal!=null) {
			User loggedInUser=userService.getUserByLoginId(principal.getName());
			if(loggedInUser.getUserType().equals("A")) {
				return new ModelAndView("redirect:/epassport/applicationForm/all");
			}
			else if(loggedInUser.getApplicationForm()!=null) {
				return new ModelAndView("redirect:/epassport/applicationForm/view/"+loggedInUser.getApplicationForm().getApplicationFormId());
			}
			else {
				return new ModelAndView("redirect:/epassport/applicationForm/");
			}
		}
		return new ModelAndView("redirect:/epassport/applicationForm/");
	}
}
