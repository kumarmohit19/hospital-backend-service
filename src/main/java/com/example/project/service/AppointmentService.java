package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Model.Appointment;
import com.example.project.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
	private AppointmentRepository appointmentRepository;

    public void deleteAppointment(String appintId) {
    	appointmentRepository.deleteById(appintId);
    }

    public List<Appointment> getAllAppointments() {
    	return appointmentRepository.findAll();
    }
    
	public Optional<Appointment> getAppointmentById(String id) {

		return appointmentRepository.findById(id);
	}

	public Appointment saveAppointment(Appointment newAppointment) {

		return appointmentRepository.save(newAppointment);
	}

}
