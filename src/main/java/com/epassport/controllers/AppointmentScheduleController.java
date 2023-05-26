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

import com.epassport.entities.AppointmentSchedule;
import com.epassport.entities.User;
import com.epassport.services.AppointmentScheduleService;
import com.epassport.services.UserService;

@RestController
@RequestMapping("/epassport/appointmentSchedules/")
public class AppointmentScheduleController {
	
	
	@Autowired
	AppointmentScheduleService appointmentScheduleService;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ModelAndView getAppointmentSchedulePage(Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		AppointmentSchedule appointmentSchedule=new AppointmentSchedule();
		ModelAndView mv=new ModelAndView("appointmentSchedules");
		List<AppointmentSchedule> appointmentScheduleList=appointmentScheduleService.getAllAppointmentSchedules();
		mv.addObject("appointmentSchedule", appointmentSchedule);
		mv.addObject("appointmentScheduleList", appointmentScheduleList);
		mv.addObject("editing", false);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@PostMapping
	public ModelAndView addAppointmentSchedule(@ModelAttribute AppointmentSchedule appointmentSchedule) {
		appointmentScheduleService.saveAppointmentSchedule(appointmentSchedule);
		return new ModelAndView("redirect:/epassport/appointmentSchedules/");
	}
	
	@GetMapping("delete/{appointmentScheduleId}")
	public ModelAndView deleteAppointmentSchedule(@PathVariable("appointmentScheduleId") Integer appointmentScheduleId) {
		appointmentScheduleService.deleteAppointmentSchedule(appointmentScheduleId);
		return new ModelAndView("redirect:/epassport/appointmentSchedules/");
	}
	
	@GetMapping("edit/{appointmentScheduleId}")
	public ModelAndView editAppointmentSchedule(@PathVariable("appointmentScheduleId") Integer appointmentScheduleId, Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		AppointmentSchedule appointmentSchedule=appointmentScheduleService.getAppointmentSchedule(appointmentScheduleId);
		ModelAndView mv=new ModelAndView("appointmentSchedules");
		List<AppointmentSchedule> appointmentScheduleList=appointmentScheduleService.getAllAppointmentSchedules();
		mv.addObject("appointmentSchedule", appointmentSchedule);
		mv.addObject("appointmentScheduleList", appointmentScheduleList);
		mv.addObject("editing", true);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@PostMapping("update/{appointmentScheduleId}")
	public ModelAndView updateAppointmentSchedule(@PathVariable("appointmentScheduleId") Integer appointmentScheduleId, @ModelAttribute AppointmentSchedule appointmentSchedule) {
		appointmentScheduleService.updateAppointmentSchedule(appointmentScheduleId, appointmentSchedule);
		return new ModelAndView("redirect:/epassport/appointmentSchedules/");
	}
	
}
