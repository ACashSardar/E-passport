package com.epassport.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epassport.entities.PassportOffice;
import com.epassport.repositories.PassportOfficeRepository;
import com.epassport.services.PassportOfficeService;

@Service
public class PassportOfficeServiceImpl implements PassportOfficeService {

	@Autowired
	PassportOfficeRepository passportOfficeRepository;
	
	@Override
	public PassportOffice savePassportOffice(PassportOffice passportOffice) {
		return passportOfficeRepository.save(passportOffice);
	}

	@Override
	public PassportOffice getPassportOffice(Integer officeId) {
		return passportOfficeRepository.findById(officeId).get();
	}

	@Override
	public List<PassportOffice> getAllPassportOffices() {
		return passportOfficeRepository.findAll();
	}

	@Override
	public PassportOffice updatePassportOffice(Integer officeId, PassportOffice passportOffice) {
		PassportOffice passportOffice2=passportOfficeRepository.findById(officeId).get();
		if(passportOffice.getOfficeName()!=null) passportOffice2.setOfficeName(passportOffice.getOfficeName());
		if(passportOffice.getJurisdiction()!=null) passportOffice2.setJurisdiction(passportOffice.getJurisdiction());
		if(passportOffice.getAddress()!=null) passportOffice2.setAddress(passportOffice.getAddress());
		if(passportOffice.getPhoneNumber()!=null) passportOffice2.setPhoneNumber(passportOffice.getPhoneNumber());
		return passportOfficeRepository.save(passportOffice2);
	}

	@Override
	public void deletePassportOffice(Integer officeId) {
		passportOfficeRepository.deleteById(officeId);
	}

}
