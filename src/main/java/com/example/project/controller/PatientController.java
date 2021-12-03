package com.example.project.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.project.Model.Patient;
import com.example.project.exception.PatientNotFoundException;
import com.example.project.service.PatientService;


@RestController
@RequestMapping(value="/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping(value = "/list")
	List<Patient> findAll() {
		return patientService.getAllPatients();
	}

	@GetMapping(value = "/view/{id}")
	ResponseEntity<Patient> findById(@PathVariable("id") String id) {
		Patient emp = patientService.getPatientById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient with ID :" + id));
		return ResponseEntity.ok().body(emp);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> createPatient(@RequestBody Patient newPatient) {
		Patient addedPatient = patientService.savePatient(newPatient);

//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedPatient.getPatient_Id())
//				.toUri();
//		return ResponseEntity.created(location).build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/delete/{id}")
	ResponseEntity<String> deletePatient(@PathVariable("id") String id) {
		Patient patient = patientService.getPatientById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient Not Found with ID :" + id));
		patientService.deletePatient(patient.getPatient_Id());
		return ResponseEntity.ok().body("Patient deleted with success!");
	}
}
