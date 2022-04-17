package com.newAppointmentService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DoctorDto {

	@JsonProperty("doctor_name")
	private String name;
	
	@JsonProperty("doctor_speciality")
	private String speciality;
	
	@JsonProperty("doctor_degree")
	private String degree;
	
}
