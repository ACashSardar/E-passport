package com.epassport.services;

import java.util.List;

import com.epassport.entities.AppointmentSchedule;

public interface AppointmentScheduleService {
	public AppointmentSchedule saveAppointmentSchedule(AppointmentSchedule appointmentSchedule);
	public AppointmentSchedule getAppointmentSchedule(Integer appointmentScheduleId);
	public List<AppointmentSchedule> getAllAppointmentSchedules();
	public AppointmentSchedule updateAppointmentSchedule(Integer appointmentScheduleId, AppointmentSchedule appointmentSchedule);
	public void deleteAppointmentSchedule(Integer appointmentScheduleId);
}
