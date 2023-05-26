package com.epassport.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AppointmentSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointmentScheduleId;
	private String monthName;
	private LocalDate date;
	private String timeSlot;
	
	@OneToMany(mappedBy = "appointmentSchedule", cascade = CascadeType.ALL)
	private List<ApplicationForm> applicationForms;
	
	public AppointmentSchedule() {
		
	}

	public AppointmentSchedule(Integer appointmentScheduleId, String monthName, LocalDate date, String timeSlot,
			List<ApplicationForm> applicationForms) {
		super();
		this.appointmentScheduleId = appointmentScheduleId;
		this.monthName = monthName;
		this.date = date;
		this.timeSlot = timeSlot;
		this.applicationForms = applicationForms;
	}

	public Integer getAppointmentScheduleId() {
		return appointmentScheduleId;
	}

	public void setAppointmentScheduleId(Integer appointmentScheduleId) {
		this.appointmentScheduleId = appointmentScheduleId;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public List<ApplicationForm> getApplicationForms() {
		return applicationForms;
	}

	public void setApplicationForms(List<ApplicationForm> applicationForms) {
		this.applicationForms = applicationForms;
	}

	@Override
	public String toString() {
		return date.getDayOfMonth()+"th "+date.getMonth()+" "+date.getYear()+ ", " + timeSlot;
	}

}
