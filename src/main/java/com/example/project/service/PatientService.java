package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Model.Patient;
import com.example.project.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}

	public Optional<Patient> getPatientById(String id) {

		return patientRepository.findById(id);
	}

	public Patient savePatient(Patient newProduct) {

		return patientRepository.save(newProduct);
	}

	public void deletePatient(String id) {

		patientRepository.deleteById(id);
	}

}
