package com.epassport.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epassport.entities.AppointmentSchedule;
import com.epassport.repositories.AppointmentScheduleRepository;
import com.epassport.services.AppointmentScheduleService;

@Service
public class AppointmentScheduleServiceImpl implements AppointmentScheduleService {

	@Autowired
	AppointmentScheduleRepository appointmentScheduleRepository;
	
	@Override
	public AppointmentSchedule saveAppointmentSchedule(AppointmentSchedule appointmentSchedule) {
		return appointmentScheduleRepository.save(appointmentSchedule);
	}

	@Override
	public AppointmentSchedule getAppointmentSchedule(Integer appointmentScheduleId) {
		return appointmentScheduleRepository.findById(appointmentScheduleId).get();
	}

	@Override
	public List<AppointmentSchedule> getAllAppointmentSchedules() {
		return appointmentScheduleRepository.findAll();
	}

	@Override
	public AppointmentSchedule updateAppointmentSchedule(Integer appointmentScheduleId,
			AppointmentSchedule appointmentSchedule) {
		AppointmentSchedule appointmentSchedule2=appointmentScheduleRepository.findById(appointmentScheduleId).get();
		if(appointmentSchedule.getMonthName()!=null) appointmentSchedule2.setMonthName(appointmentSchedule.getMonthName());
		if(appointmentSchedule.getDate()!=null) appointmentSchedule2.setDate(appointmentSchedule.getDate());
		if(appointmentSchedule.getTimeSlot()!=null) appointmentSchedule2.setTimeSlot(appointmentSchedule.getTimeSlot());
		return appointmentScheduleRepository.save(appointmentSchedule2);
	}

	@Override
	public void deleteAppointmentSchedule(Integer appointmentScheduleId) {
		appointmentScheduleRepository.deleteById(appointmentScheduleId);
	}
}
