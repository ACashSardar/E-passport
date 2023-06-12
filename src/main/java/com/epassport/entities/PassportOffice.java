package com.epassport.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
