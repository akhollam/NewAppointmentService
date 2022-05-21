package com.newAppointmentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newAppointmentService.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
