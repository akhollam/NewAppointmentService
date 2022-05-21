package com.newAppointmentService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.newAppointmentService.entity.Doctor;
import com.newAppointmentService.model.DegreeCount;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	@Query("SELECT degree as degree, COUNT(degree) as count FROM Doctor GROUP BY degree")
	List<DegreeCount> getDoctorDountByDegree();

}
