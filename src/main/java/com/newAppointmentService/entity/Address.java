package com.newAppointmentService.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {

	private String pincode;
	private String city;
	private String state;
	private String country;

}
