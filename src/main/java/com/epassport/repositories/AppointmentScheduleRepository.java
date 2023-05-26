package com.epassport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epassport.entities.AppointmentSchedule;

public interface AppointmentScheduleRepository extends JpaRepository<AppointmentSchedule, Integer> {

}
