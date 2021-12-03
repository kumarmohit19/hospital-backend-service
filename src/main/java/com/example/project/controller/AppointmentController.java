package com.example.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.project.Model.Appointment;
import com.example.project.exception.AppointmentNotFoundException;
import com.example.project.service.AppointmentService;

@RestController
@RequestMapping(value= "/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping(value = "/list")
	List<Appointment> findAll() {
		return appointmentService.getAllAppointments();
	}

	@GetMapping(value = "/view/{id}")
	ResponseEntity<Appointment> findById(@PathVariable("id") String id) {
		Appointment emp = appointmentService.getAppointmentById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment with ID :" + id));
		return ResponseEntity.ok().body(emp);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> createAppointment(@RequestBody Appointment newAppointment) {
		Appointment addedAppointment = appointmentService.saveAppointment(newAppointment);

//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedAppointment.getBooking_id())
//				.toUri();
//		return ResponseEntity.created(location).build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/delete/{id}")
	ResponseEntity<String> deleteAppointment(@PathVariable("id") String id) {
		Appointment appointment = appointmentService.getAppointmentById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment Not Found with ID :" + id));
		appointmentService.deleteAppointment(appointment.getBooking_id());
		return ResponseEntity.ok().body("Appointment deleted with success!");
	}
}
