package com.newAppointmentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newAppointmentService.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	

}
