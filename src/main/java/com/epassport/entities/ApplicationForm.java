package com.epassport.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ApplicationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer applicationFormId;
	// Applicants Details
	private String firstName;
	private String lastName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private String placeOfBirth;
	private String gender;
	private String state;
	private String district;
	private String maritalStatus;
	private String pan;
	private String document;
	private String employmentType;
	private String educationQualification;
	// Family Details
	private String fathersName;
	private String mothersName;
	// Address Details
	private String houseNo;
	private String streetName;
	private String city;
	private Integer pinCode;
	private String telephoneNumber;
	private String emailId;
	// Reference Details
	private String refName;
	private String refAddress;
	private String refTelephoneNumber;
	// Completion status
	private String status;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "office_id")
	private PassportOffice passportOffice;
	
	@ManyToOne
	@JoinColumn(name = "appointment_schedule_id")
	private AppointmentSchedule appointmentSchedule;
	
	public ApplicationForm() {
		
	}

	public ApplicationForm(Integer applicationFormId, String firstName, String lastName, LocalDate dob,
			String placeOfBirth, String gender, String state, String district, String maritalStatus, String pan,
			String document, String employmentType, String educationQualification, String fathersName,
			String mothersName, String houseNo, String streetName, String city, Integer pinCode, String telephoneNumber,
			String emailId, String refName, String refAddress, String refTelephoneNumber, String status, User user,
			PassportOffice passportOffice, AppointmentSchedule appointmentSchedule) {
		super();
		this.applicationFormId = applicationFormId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
		this.state = state;
		this.district = district;
		this.maritalStatus = maritalStatus;
		this.pan = pan;
		this.document = document;
		this.employmentType = employmentType;
		this.educationQualification = educationQualification;
		this.fathersName = fathersName;
		this.mothersName = mothersName;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.pinCode = pinCode;
		this.telephoneNumber = telephoneNumber;
		this.emailId = emailId;
		this.refName = refName;
		this.refAddress = refAddress;
		this.refTelephoneNumber = refTelephoneNumber;
		this.status = status;
		this.user = user;
		this.passportOffice = passportOffice;
		this.appointmentSchedule = appointmentSchedule;
	}

	public Integer getApplicationFormId() {
		return applicationFormId;
	}

	public void setApplicationFormId(Integer applicationFormId) {
		this.applicationFormId = applicationFormId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getEducationQualification() {
		return educationQualification;
	}

	public void setEducationQualification(String educationQualification) {
		this.educationQualification = educationQualification;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public String getRefAddress() {
		return refAddress;
	}

	public void setRefAddress(String refAddress) {
		this.refAddress = refAddress;
	}

	public String getRefTelephoneNumber() {
		return refTelephoneNumber;
	}

	public void setRefTelephoneNumber(String refTelephoneNumber) {
		this.refTelephoneNumber = refTelephoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PassportOffice getPassportOffice() {
		return passportOffice;
	}

	public void setPassportOffice(PassportOffice passportOffice) {
		this.passportOffice = passportOffice;
	}

	public AppointmentSchedule getAppointmentSchedule() {
		return appointmentSchedule;
	}

	public void setAppointmentSchedule(AppointmentSchedule appointmentSchedule) {
		this.appointmentSchedule = appointmentSchedule;
	}

	@Override
	public String toString() {
		return "ApplicationForm [applicationFormId=" + applicationFormId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", placeOfBirth=" + placeOfBirth + ", gender=" + gender + ", state="
				+ state + ", district=" + district + ", maritalStatus=" + maritalStatus + ", pan=" + pan + ", document="
				+ document + ", employmentType=" + employmentType + ", educationQualification=" + educationQualification
				+ ", fathersName=" + fathersName + ", mothersName=" + mothersName + ", houseNo=" + houseNo
				+ ", streetName=" + streetName + ", city=" + city + ", pinCode=" + pinCode + ", telephoneNumber="
				+ telephoneNumber + ", emailId=" + emailId + ", refName=" + refName + ", refAddress=" + refAddress
				+ ", refTelephoneNumber=" + refTelephoneNumber + ", status=" + status + ", user=" + user
				+ ", passportOffice=" + passportOffice + ", appointmentSchedule=" + appointmentSchedule + "]";
	}

}
