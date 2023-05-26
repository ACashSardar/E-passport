package com.epassport.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PassportOffice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer officeId;
	private String officeName;
	private String jurisdiction;
	private String address;
	private String phoneNumber;
	
	@OneToMany(mappedBy = "passportOffice", cascade = CascadeType.ALL)
	private List<ApplicationForm> applicationForms;
	
	public PassportOffice() {
		
	}

	public PassportOffice(Integer officeId, String officeName, String jurisdiction, String address, String phoneNumber,
			List<ApplicationForm> applicationForms) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.jurisdiction = jurisdiction;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.applicationForms = applicationForms;
	}

	public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<ApplicationForm> getApplicationForms() {
		return applicationForms;
	}

	public void setApplicationForms(List<ApplicationForm> applicationForms) {
		this.applicationForms = applicationForms;
	}

	@Override
	public String toString() {
		return "PassportOffice [officeId=" + officeId + ", officeName=" + officeName + ", jurisdiction=" + jurisdiction
				+ ", address=" + address + ", phoneNumber=" + phoneNumber+"]";
	}
	
}

