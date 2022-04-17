package com.newAppointmentService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newAppointmentService.entity.Doctor;

@Repository
public class DoctorRepo {

	@Autowired
	private DoctorRepository doctorRepository;

	public void save(Doctor doctor) {

		doctorRepository.save(doctor);
	}

	public List<Doctor> findAllByCity(String string) {
		return null;
	}

	public Optional<Doctor> findById(Integer doctorId) {
		return doctorRepository.findById(doctorId);
	}

	public void deleteDoctor(Integer doctorId) {
		doctorRepository.deleteById(doctorId);
	}

	public List<Doctor> findAllDoctors() {
		return doctorRepository.findAll();
	}

	public void deleteDoctor(Doctor doctor) {
		doctorRepository.delete(doctor);
	}

}
