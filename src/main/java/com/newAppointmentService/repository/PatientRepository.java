package com.newAppointmentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newAppointmentService.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {


}
