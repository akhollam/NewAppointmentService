package com.newAppointmentService.service;

import java.util.List;

import com.newAppointmentService.model.DoctorDto;

public interface DoctorService {

	void createDoctor(DoctorDto doctorDto);

	DoctorDto getDoctor(Integer doctorId);

	void updateDoctor(Integer doctorId, DoctorDto doctorDto);

	void deleteDoctor(Integer doctorId);

	List<DoctorDto> getAllDoctors();

	void createDoctors(List<DoctorDto> doctorDtoList);

}
