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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
}
