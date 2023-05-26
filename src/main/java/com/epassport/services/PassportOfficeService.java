package com.epassport.services;

import java.util.List;

import com.epassport.entities.PassportOffice;

public interface PassportOfficeService {
	public PassportOffice savePassportOffice(PassportOffice passportOffice);
	public PassportOffice getPassportOffice(Integer officeId);
	public List<PassportOffice> getAllPassportOffices();
	public PassportOffice updatePassportOffice(Integer officeId, PassportOffice passportOffice);
	public void deletePassportOffice(Integer officeId);
}
