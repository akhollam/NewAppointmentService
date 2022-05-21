package com.newAppointmentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.newAppointmentService.model.DoctorDto;
import com.newAppointmentService.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

// @Controller
@RestController
@Slf4j
public class DoctorController {
	
	@Value("${doctor.clinic.name}")
	private String clinicName; 
	
	@Value("${spring.application.name}")
	private String applicationName; 

	@Autowired
	private DoctorService doctorService;

	// C R U D

	// @ResponseBody
	// @RequestMapping(value = "/doctor", method = RequestMethod.GET)
	@GetMapping(value = "/doctor", produces = { "application/json", "application/xml" })
	private List<DoctorDto> getAllDoctor() {
		
		log.debug("clinicName - {} ", clinicName);
		
		return doctorService.getAllDoctors();
	}

	// @RequestMapping(value = "/doctor", method = RequestMethod.POST)
	@PostMapping(value = "/doctor", consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	private void createDoctor(@RequestBody DoctorDto doctorDto) {

		log.debug("doctorDto - {}", doctorDto);
		doctorService.createDoctor(doctorDto);
	}

	@RequestMapping(value = "/doctor/{doctor_id}", method = RequestMethod.GET, produces = "application/json")
	// @GetMapping
	private ResponseEntity<DoctorDto> getDoctor(@PathVariable("doctor_id") Integer doctorId) {

		DoctorDto dto = doctorService.getDoctor(doctorId);

		log.debug("dtodtodtodtodto - {}", dto);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	// @RequestMapping(value = "/doctor/{doctor_id}", method = RequestMethod.PUT)
	@PutMapping("/doctor/{doctor_id}")
	private void updateDoctor(@PathVariable("doctor_id") Integer doctorId, @RequestBody DoctorDto doctorDto) {
		log.debug("doctorDto - {}", doctorDto);
		doctorService.updateDoctor(doctorId, doctorDto);
	}

	// @RequestMapping(value = "/doctor/{doctor_id}", method = RequestMethod.DELETE)
	@DeleteMapping("/doctor/{doctor_id}")
	private void deleteDoctor(@PathVariable("doctor_id") Integer doctorId) {
		doctorService.deleteDoctor(doctorId);
	}

	
	@PostMapping(value = "/doctors", consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	private void createAllDoctor(@RequestBody List<DoctorDto> doctorDtoList) {

		log.debug("doctorDto - {}", doctorDtoList);
		doctorService.createDoctors(doctorDtoList);
	}
	
}
