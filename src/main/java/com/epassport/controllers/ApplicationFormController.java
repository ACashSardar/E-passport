package com.epassport.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.epassport.entities.ApplicationForm;
import com.epassport.entities.AppointmentSchedule;
import com.epassport.entities.PassportOffice;
import com.epassport.entities.User;
import com.epassport.services.ApplicationFormService;
import com.epassport.services.AppointmentScheduleService;
import com.epassport.services.FileService;
import com.epassport.services.PassportOfficeService;
import com.epassport.services.UserService;


@RestController
@RequestMapping("/epassport/applicationForm/")
public class ApplicationFormController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PassportOfficeService passportOfficeService;
	
	@Autowired
	AppointmentScheduleService appointmentScheduleService;
	
	@Autowired
	ApplicationFormService applicationFormService;
	
	@Autowired
	FileService fileService;
	
	@Value("${project.documents}")
	String path;
	
	
	@GetMapping
	public ModelAndView getApplicationForm(Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		ApplicationForm applicationForm=new ApplicationForm();
		List<PassportOffice> officeList=passportOfficeService.getAllPassportOffices();
		List<AppointmentSchedule> appointmentScheduleList=appointmentScheduleService.getAllAppointmentSchedules();
		ModelAndView mv=new ModelAndView("applicationForm");
		mv.addObject("officeList", officeList);
		mv.addObject("appointmentScheduleList", appointmentScheduleList);
		mv.addObject("applicationForm", applicationForm);
		mv.addObject("editing", false);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@PostMapping
	public ModelAndView submitForm(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("dob") LocalDate dob,
			@RequestParam("placeOfBirth") String placeOfBirth,
			@RequestParam("gender") String gender,
			@RequestParam("state") String state,
			@RequestParam("district") String district,
			@RequestParam("maritalStatus") String maritalStatus,
			@RequestParam("pan") String pan,
			@RequestParam("document") MultipartFile document,
			@RequestParam("employmentType") String employmentType,
			@RequestParam("educationQualification") String educationQualification,
			
			@RequestParam("fathersName") String fathersName,
			@RequestParam("mothersName") String mothersName,
			
			@RequestParam("houseNo") String houseNo,
			@RequestParam("streetName") String streetName,
			@RequestParam("city") String city,
			@RequestParam("pinCode") Integer pinCode,
			@RequestParam("telephoneNumber") String telephoneNumber,
			@RequestParam("emailId") String emailId,
			
			@RequestParam("refName") String refName,
			@RequestParam("refAddress") String refAddress,
			@RequestParam("refTelephoneNumber") String refTelephoneNumber,
			
			@RequestParam("passportOffice") Integer passportOfficeId,
			@RequestParam("appointmentSchedule") Integer appointmentScheduleId,
			Principal principal
			
		) {
		
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		
		ApplicationForm applicationForm=new ApplicationForm();

		applicationForm.setFirstName(firstName);
		applicationForm.setLastName(lastName);
		applicationForm.setDob(dob);
		applicationForm.setPlaceOfBirth(placeOfBirth);
		applicationForm.setGender(gender);
		applicationForm.setState(state);
		applicationForm.setDistrict(district);
		applicationForm.setMaritalStatus(maritalStatus);
		applicationForm.setPan(pan);
		try {
			String docName=fileService.uploadFile(path, document);
			applicationForm.setDocument(docName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		applicationForm.setEmploymentType(employmentType);
		applicationForm.setEducationQualification(educationQualification);
		
		applicationForm.setFathersName(fathersName);
		applicationForm.setMothersName(mothersName);
		
		applicationForm.setHouseNo(houseNo);
		applicationForm.setStreetName(streetName);
		applicationForm.setCity(city);
		applicationForm.setPinCode(pinCode);
		applicationForm.setTelephoneNumber(telephoneNumber);
		applicationForm.setEmailId(emailId);
		applicationForm.setRefName(refName);
		applicationForm.setRefAddress(refAddress);
		applicationForm.setRefTelephoneNumber(refTelephoneNumber);
		
		PassportOffice office=passportOfficeService.getPassportOffice(passportOfficeId);
		AppointmentSchedule schedule=appointmentScheduleService.getAppointmentSchedule(appointmentScheduleId);
		User user=userService.getUserByEmailId(emailId);
		
		applicationForm.setPassportOffice(office);
		applicationForm.setAppointmentSchedule(schedule);
		applicationForm.setUser(user);
		applicationForm.setStatus("Pending");
		applicationFormService.saveApplicationForm(applicationForm);
		
		ModelAndView mv=new ModelAndView("submittedForm");
		mv.addObject("applicationForm", applicationForm);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@GetMapping("all")
	public ModelAndView getAllApplications(Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		List<ApplicationForm> applicationFormList=applicationFormService.getAllApplicationForms();
		ModelAndView mv=new ModelAndView("allApplications");
		mv.addObject("applicationFormList", applicationFormList);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@GetMapping("view/{applicationFormId}")
	public ModelAndView viewSubmittedApplicationForm(@PathVariable("applicationFormId") Integer applicationFormId, Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		ApplicationForm applicationForm=applicationFormService.getApplicationForm(applicationFormId);
		ModelAndView mv=new ModelAndView("submittedForm");
		mv.addObject("applicationForm", applicationForm);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@GetMapping("edit/{applicationFormId}")
	public ModelAndView editApplicationForm(@PathVariable("applicationFormId") Integer applicationFormId, Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		ApplicationForm applicationForm=applicationFormService.getApplicationForm(applicationFormId);
		List<PassportOffice> officeList=passportOfficeService.getAllPassportOffices();
		List<AppointmentSchedule> appointmentScheduleList=appointmentScheduleService.getAllAppointmentSchedules();
		ModelAndView mv=new ModelAndView("applicationForm");
		mv.addObject("officeList", officeList);
		mv.addObject("appointmentScheduleList", appointmentScheduleList);
		mv.addObject("applicationForm", applicationForm);
		mv.addObject("editing", true);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}
	
	@PostMapping("update/{applicationFormId}")
	public ModelAndView updateApplicationForm(
			@PathVariable("applicationFormId") Integer applicationFormId,
			
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("dob") LocalDate dob,
			@RequestParam("placeOfBirth") String placeOfBirth,
			@RequestParam("gender") String gender,
			@RequestParam("state") String state,
			@RequestParam("district") String district,
			@RequestParam("maritalStatus") String maritalStatus,
			@RequestParam("pan") String pan,
			@RequestParam("employmentType") String employmentType,
			@RequestParam("educationQualification") String educationQualification,
			
			@RequestParam("fathersName") String fathersName,
			@RequestParam("mothersName") String mothersName,
			
			@RequestParam("houseNo") String houseNo,
			@RequestParam("streetName") String streetName,
			@RequestParam("city") String city,
			@RequestParam("pinCode") Integer pinCode,
			@RequestParam("telephoneNumber") String telephoneNumber,
			@RequestParam("emailId") String emailId,
			
			@RequestParam("refName") String refName,
			@RequestParam("refAddress") String refAddress,
			@RequestParam("refTelephoneNumber") String refTelephoneNumber,
			
			@RequestParam("passportOffice") Integer passportOfficeId,
			@RequestParam("appointmentSchedule") Integer appointmentScheduleId,
			@RequestParam("status") String status,
			Principal principal
		) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		
		ApplicationForm applicationForm=new ApplicationForm();

		applicationForm.setFirstName(firstName);
		applicationForm.setLastName(lastName);
		applicationForm.setDob(dob);
		applicationForm.setPlaceOfBirth(placeOfBirth);
		applicationForm.setGender(gender);
		applicationForm.setState(state);
		applicationForm.setDistrict(district);
		applicationForm.setMaritalStatus(maritalStatus);
		applicationForm.setPan(pan);
		applicationForm.setEmploymentType(employmentType);
		applicationForm.setEducationQualification(educationQualification);
		
		applicationForm.setFathersName(fathersName);
		applicationForm.setMothersName(mothersName);
		
		applicationForm.setHouseNo(houseNo);
		applicationForm.setStreetName(streetName);
		applicationForm.setCity(city);
		applicationForm.setPinCode(pinCode);
		applicationForm.setTelephoneNumber(telephoneNumber);
		applicationForm.setEmailId(emailId);
		applicationForm.setRefName(refName);
		applicationForm.setRefAddress(refAddress);
		applicationForm.setRefTelephoneNumber(refTelephoneNumber);
		
		applicationForm.setStatus(status);
		
		PassportOffice office=passportOfficeService.getPassportOffice(passportOfficeId);
		AppointmentSchedule schedule=appointmentScheduleService.getAppointmentSchedule(appointmentScheduleId);
		applicationForm.setPassportOffice(office);
		applicationForm.setAppointmentSchedule(schedule);
		ModelAndView mv=new ModelAndView("submittedForm");
		mv.addObject("applicationForm", applicationFormService.updateApplicationForm(applicationFormId, applicationForm));
		mv.addObject("loggedInUser", loggedInUser);
		
		return mv;
	}
	
	@GetMapping("done/{applicationFormId}")
	public ModelAndView markAsDone(@PathVariable("applicationFormId") Integer applicationFormId) {
		ApplicationForm applicationForm=new ApplicationForm();
		applicationForm.setStatus("Done");
		applicationFormService.updateApplicationForm(applicationFormId, applicationForm);
		return new ModelAndView("redirect:/epassport/applicationForm/all");
	}
	
	@GetMapping("delete/{applicationFormId}")
	public ModelAndView deleteApplication(@PathVariable("applicationFormId") Integer applicationFormId) {
		applicationFormService.deleteApplicationForm(applicationFormId);
		return new ModelAndView("redirect:/epassport/applicationForm/all");
	}
	
	@GetMapping(value = "/documents/{docName}", produces = MediaType.APPLICATION_PDF_VALUE)
	public void serveDocument(@PathVariable("docName") String docName, HttpServletResponse response)
			throws IOException {
		InputStream resource = fileService.getResource(path, docName);
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
	
	@GetMapping("pdf/{applicationFormId}")
	public ModelAndView createPdf(@PathVariable("applicationFormId") Integer applicationFormId, Principal principal) {
		User loggedInUser=null;
		if(principal!=null) loggedInUser=userService.getUserByLoginId(principal.getName());
		
		ApplicationForm applicationForm=applicationFormService.getApplicationForm(applicationFormId);
		fileService.createPdf(path, applicationForm);
		ModelAndView mv=new ModelAndView("submittedForm");
		mv.addObject("applicationForm", applicationForm);
		mv.addObject("showPdf", true);
		mv.addObject("loggedInUser", loggedInUser);
		return mv;
	}

}
