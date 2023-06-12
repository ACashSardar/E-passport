package com.epassport.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
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
	
}
