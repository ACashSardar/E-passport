package com.epassport.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epassport.entities.PassportOffice;
import com.epassport.entities.User;
import com.epassport.services.PassportOfficeService;
import com.epassport.services.UserService;

@RestController
@RequestMapping("/epassport/offices/")
public class PassportOfficeController {
	
	@Autowired
	PassportOfficeService passportOfficeService;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ModelAndView getOfficePage(Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByEmailId(principal.getName());
		PassportOffice passportOffice=new PassportOffice();
		ModelAndView mv=new ModelAndView("offices");
		List<PassportOffice> officeList=passportOfficeService.getAllPassportOffices();
		mv.addObject("passportOffice", passportOffice);
		mv.addObject("officeList", officeList);
		mv.addObject("editing", false);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@PostMapping
	public ModelAndView addOffice(@ModelAttribute PassportOffice passportOffice) {
		passportOfficeService.savePassportOffice(passportOffice);
		return new ModelAndView("redirect:/epassport/offices/");
	}
	
	@GetMapping("delete/{officeId}")
	public ModelAndView deleteOffice(@PathVariable("officeId") Integer officeId) {
		passportOfficeService.deletePassportOffice(officeId);
		return new ModelAndView("redirect:/epassport/offices/");
	}
	
	@GetMapping("edit/{officeId}")
	public ModelAndView editOffice(@PathVariable("officeId") Integer officeId, Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByEmailId(principal.getName());
		ModelAndView mv=new ModelAndView("offices");
		PassportOffice passportOffice=passportOfficeService.getPassportOffice(officeId);
		List<PassportOffice> officeList=passportOfficeService.getAllPassportOffices();
		mv.addObject("passportOffice", passportOffice);
		mv.addObject("officeList", officeList);
		mv.addObject("editing", true);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@PostMapping("update/{officeId}")
	public ModelAndView updateOffice(@PathVariable("officeId") Integer officeId, @ModelAttribute PassportOffice passportOffice) {
		passportOfficeService.updatePassportOffice(officeId, passportOffice);
		return new ModelAndView("redirect:/epassport/offices/");
	}

}

