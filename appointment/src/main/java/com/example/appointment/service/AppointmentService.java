package com.example.appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.entity.Appointment;
import com.example.appointment.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	public Appointment bookAppointment(Appointment appointment) {
		appointmentRepo.save(appointment);
		return appointment;
	}
	
	public List<Appointment> getAllAppointments(){
		return appointmentRepo.findAll();
	}
	
	public Appointment getAppointmentById(int id) {
		return appointmentRepo.findById(id);
	}
	
}
