package com.epassport.services;

import java.util.List;

import com.epassport.entities.ApplicationForm;

public interface ApplicationFormService {
	public ApplicationForm saveApplicationForm(ApplicationForm applicationForm);
	public ApplicationForm getApplicationForm(Integer applicationFormId);
	public List<ApplicationForm> getAllApplicationForms();
	public ApplicationForm updateApplicationForm(Integer applicationFormId, ApplicationForm applicationForm);
	public void deleteApplicationForm(Integer applicationFormId);
}
