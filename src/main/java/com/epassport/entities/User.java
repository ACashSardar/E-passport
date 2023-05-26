package com.epassport.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String loginId;
	private String password;
	private String firstName;
	private String lastName;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	private String gender;
	private String emailId;
	private String phoneNo;
	private String userType;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private ApplicationForm applicationForm;
	
	public User() {
		
	}

	public User(Integer userId, String loginId, String password, String firstName, String lastName, LocalDate dob,
			String gender, String emailId, String phoneNo, String userType, ApplicationForm applicationForm) {
		super();
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.userType = userType;
		this.applicationForm = applicationForm;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginId=" + loginId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender + ", emailId=" + emailId
				+ ", phoneNo=" + phoneNo + ", userType=" + userType + "]";
	}
	
}
