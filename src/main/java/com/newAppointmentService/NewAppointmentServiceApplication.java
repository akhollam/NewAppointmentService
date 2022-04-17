package com.newAppointmentService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Controller
@Slf4j
public class NewAppointmentServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		
		log.debug("NewAppointmentServiceApplication started");
		
		SpringApplication.run(NewAppointmentServiceApplication.class, args);
	}
	
	@ResponseBody
	@RequestMapping("/welcome")
	public String welcome(@RequestParam(value = "name", required = false) String name) {
		return "welcome " + name + " to the world of spring boot. ";
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.debug("running some stufff....");
		
	}

}
