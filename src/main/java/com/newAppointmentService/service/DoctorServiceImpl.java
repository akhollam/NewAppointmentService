package com.newAppointmentService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newAppointmentService.entity.Address;
import com.newAppointmentService.entity.Doctor;
import com.newAppointmentService.model.DoctorDto;
import com.newAppointmentService.repository.DoctorRepo;

@Service
// @Component
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	public DoctorRepo doctorRepo;

	@Override
	public void createDoctor(DoctorDto doctorDto) {

		Doctor doctor = new Doctor();
		doctor.setName(doctorDto.getName());
		doctor.setSpeciality(doctorDto.getSpeciality());
		doctor.setDegree(doctorDto.getDegree());
		
		Address add = new Address();
		add.setCity("Pune");
		add.setState("Mh");
		add.setCountry("India");
		
		doctor.setAddress(Arrays.asList(add));
		
		doctorRepo.save(doctor);

	}

	@Override
	public DoctorDto getDoctor(Integer doctorId) {

		Optional<Doctor> doc = doctorRepo.findById(doctorId);
		if (doc.isPresent()) {
			Doctor doctor = doc.get();
			DoctorDto dto = new DoctorDto();
			dto.setName(doctor.getName());
			dto.setSpeciality(doctor.getSpeciality());
			dto.setDegree(doctor.getDegree());
			return dto;
		}
		
		EntityNotFoundException enf = new EntityNotFoundException("doctor not found."); 
		throw enf;
		
	}

	@Override
	public void updateDoctor(Integer doctorId, DoctorDto doctorDto) {
		Optional<Doctor> doc = doctorRepo.findById(doctorId);
		if (doc.isPresent()) {
			Doctor doctor = doc.get();
			doctor.setName(doctorDto.getName());
			doctor.setSpeciality(doctorDto.getSpeciality());
			doctor.setDegree(doctorDto.getDegree());
			doctorRepo.save(doctor);
			return;
		}
		
		throw new EntityNotFoundException("doctor not found.");
	}

	@Override
	public void deleteDoctor(Integer doctorId) {
		
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
		if(doctor.isPresent()) {
			doctorRepo.deleteDoctor(doctor.get());
			return;
		}
		
		throw new EntityNotFoundException("Doctor with id " + doctorId + " not found.");
	}

	@Override
	public List<DoctorDto> getAllDoctors() {

		List<Doctor> allDocs = doctorRepo.findAllDoctors();
		List<DoctorDto> allDocDtos = new ArrayList<>();
		for (Doctor doctor : allDocs) {
			DoctorDto dto = new DoctorDto();
			dto.setName(doctor.getName());
			dto.setSpeciality(doctor.getSpeciality());
			dto.setDegree(doctor.getDegree());
			allDocDtos.add(dto);
		}

		return allDocDtos;
	}

	@Override
	public void createDoctors(List<DoctorDto> doctorDtoList) {
		
		List<Doctor> doctors = new ArrayList<>();
		
		for (DoctorDto doctorDto : doctorDtoList) {
			// createDoctor(doctorDto);
			Doctor doctor = new Doctor();
			doctor.setName(doctorDto.getName());
			doctor.setSpeciality(doctorDto.getSpeciality());
			doctor.setDegree(doctorDto.getDegree());
			doctors.add(doctor);
		}
		
		doctorRepo.saveDoctorList(doctors);
		
	}

}
