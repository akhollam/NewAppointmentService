package com.newAppointmentService.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@ElementCollection
	private List<Address> address;

}
