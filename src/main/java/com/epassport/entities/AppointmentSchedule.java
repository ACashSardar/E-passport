package com.epassport.entities;

import java.time.LocalDate;
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
public class AppointmentSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointmentScheduleId;
	private String monthName;
	private LocalDate date;
	private String timeSlot;

	@OneToMany(mappedBy = "appointmentSchedule", cascade = CascadeType.ALL)
	private List<ApplicationForm> applicationForms;

}
