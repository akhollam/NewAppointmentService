package com.newAppointmentService.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "doctor_table")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "doctor_name")
	private String name;

	@Transient
	private String speciality;

	@Column(name = "degree", nullable = false)
	private String degree;
	
	@ElementCollection
	private List<Address> address;
	
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;

}
