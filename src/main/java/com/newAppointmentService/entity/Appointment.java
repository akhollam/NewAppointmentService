package com.newAppointmentService.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Appointment {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Doctor doctor;

	@ManyToOne
	private Patient patient;

	private LocalDateTime appointmentTime;
	
	private boolean cancelled;
}
