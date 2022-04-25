package com.newAppointmentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.newAppointmentService.model.DoctorDto;
import com.newAppointmentService.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WelcomeController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model, @RequestParam(value = "name", required = false) String name) {

		model.addAttribute("doctorList", doctorService.getAllDoctors());
		log.debug("welcome page called. ");
		model.addAttribute("name", name);
		model.addAttribute("doctor", new DoctorDto());
		return "welcome";
	}

	@RequestMapping(value = "/createDoctor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String createDoctor(Model model, @ModelAttribute("doctor") DoctorDto doctorDto) {
		log.debug("doctorDto received as  - {}", doctorDto);
		doctorService.createDoctor(doctorDto);
		return "redirect:/welcome";
	}

}
