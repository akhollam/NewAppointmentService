package com.newAppointmentService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.newAppointmentService.entity.Address;
import com.newAppointmentService.entity.Appointment;
import com.newAppointmentService.entity.Doctor;
import com.newAppointmentService.entity.MedicalReports;
import com.newAppointmentService.entity.Patient;
import com.newAppointmentService.model.DegreeCount;
import com.newAppointmentService.repository.AppointmentRepository;
import com.newAppointmentService.repository.DoctorRepository;
import com.newAppointmentService.repository.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class NewAppointmentServiceApplication implements CommandLineRunner {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(NewAppointmentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
//		long count = doctorRepository.count();
//		
//		List<DegreeCount> degreeCount = doctorRepository.getDoctorDountByDegree();
//		
//		log.debug("************************************************");
//		degreeCount.stream().forEach(dc -> {
//			log.debug(dc.getDegree() + " > " + dc.getCount());
//		});
		
		
		Doctor doc = new Doctor();
		doc.setName("Abhijeet K");
		doc.setDegree("MBBS");
		
		Patient patient = new Patient();
		
		Address address = new Address();
		address.setCity("Pune");
		address.setPincode("411027");
		address.setCountry("India");
		address.setState("Maharashtra");
		
		doc.setAddress(Arrays.asList(address, address, address));
		
		patient.setAddress(address);
		
		patient.setName("Pooja");
		
		MedicalReports medicalReports = new MedicalReports();
		medicalReports.setReportName("X-ray");
		patient.setMedicalReports( Arrays.asList(medicalReports) );
		
		doctorRepository.save(doc);
		patientRepository.save(patient);
		
		Appointment appointment = new Appointment();
		appointment.setDoctor(doc);
		appointment.setPatient(patient);
		appointment.setAppointmentTime(LocalDateTime.now());
		
		appointmentRepository.save(appointment);
		
	}

}
