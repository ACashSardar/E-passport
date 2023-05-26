package com.epassport.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epassport.entities.ApplicationForm;
import com.epassport.repositories.ApplicationFormRepository;
import com.epassport.services.ApplicationFormService;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService {

	@Autowired
	ApplicationFormRepository applicationFormRepository;
	
	@Override
	public ApplicationForm saveApplicationForm(ApplicationForm applicationForm) {
		return applicationFormRepository.save(applicationForm);
	}

	@Override
	public ApplicationForm getApplicationForm(Integer applicationFormId) {
		return applicationFormRepository.findById(applicationFormId).get();
	}

	@Override
	public List<ApplicationForm> getAllApplicationForms() {
		return applicationFormRepository.findAll();
	}

	@Override
	public ApplicationForm updateApplicationForm(Integer applicationFormId, ApplicationForm applicationForm) {
		ApplicationForm applicationForm2=applicationFormRepository.findById(applicationFormId).get();
		// Applicants Details
		if(applicationForm.getFirstName()!=null) applicationForm2.setFirstName(applicationForm.getFirstName());
		if(applicationForm.getLastName()!=null) applicationForm2.setLastName(applicationForm.getLastName());
		if(applicationForm.getDob()!=null) applicationForm2.setDob(applicationForm.getDob());
		if(applicationForm.getPlaceOfBirth()!=null) applicationForm2.setPlaceOfBirth(applicationForm.getPlaceOfBirth());
		if(applicationForm.getGender()!=null) applicationForm2.setGender(applicationForm.getGender());
		if(applicationForm.getState()!=null) applicationForm2.setState(applicationForm.getState());
		if(applicationForm.getDistrict()!=null) applicationForm2.setDistrict(applicationForm.getDistrict());
		if(applicationForm.getMaritalStatus()!=null) applicationForm2.setMaritalStatus(applicationForm.getMaritalStatus());
		if(applicationForm.getPan()!=null) applicationForm2.setPan(applicationForm.getPan());
		if(applicationForm.getEmploymentType()!=null) applicationForm2.setEmploymentType(applicationForm.getEmploymentType());
		if(applicationForm.getEducationQualification()!=null) applicationForm2.setEducationQualification(applicationForm.getEducationQualification());
		// Family Details
		if(applicationForm.getFathersName()!=null) applicationForm2.setFathersName(applicationForm.getFathersName());
		if(applicationForm.getMothersName()!=null) applicationForm2.setMothersName(applicationForm.getMothersName());
		// Address Details
		if(applicationForm.getHouseNo()!=null) applicationForm2.setHouseNo(applicationForm.getHouseNo());
		if(applicationForm.getStreetName()!=null) applicationForm2.setStreetName(applicationForm.getStreetName());
		if(applicationForm.getCity()!=null) applicationForm2.setCity(applicationForm.getCity());
		if(applicationForm.getPinCode()!=null) applicationForm2.setPinCode(applicationForm.getPinCode());
		if(applicationForm.getTelephoneNumber()!=null) applicationForm2.setTelephoneNumber(applicationForm.getTelephoneNumber());
		if(applicationForm.getEmailId()!=null) applicationForm2.setEmailId(applicationForm.getEmailId());
		// Reference Details
		if(applicationForm.getRefName()!=null) applicationForm2.setRefName(applicationForm.getRefName());
		if(applicationForm.getRefAddress()!=null) applicationForm2.setRefAddress(applicationForm.getRefAddress());
		if(applicationForm.getRefTelephoneNumber()!=null) applicationForm2.setRefTelephoneNumber(applicationForm.getRefTelephoneNumber());
		// Foreign Key Details
		if(applicationForm.getUser()!=null) applicationForm2.setUser(applicationForm.getUser());
		if(applicationForm.getPassportOffice()!=null) applicationForm2.setPassportOffice(applicationForm.getPassportOffice());
		if(applicationForm.getAppointmentSchedule()!=null) applicationForm2.setAppointmentSchedule(applicationForm.getAppointmentSchedule());
		if(applicationForm.getStatus()!=null) applicationForm2.setStatus(applicationForm.getStatus());
		return applicationFormRepository.save(applicationForm2);
	}

	@Override
	public void deleteApplicationForm(Integer applicationFormId) {
		applicationFormRepository.deleteById(applicationFormId);
	}

}
