package com.newAppointmentService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MedicalReports {

	@Id
	@GeneratedValue
	Long id;

	String reportName;
}
