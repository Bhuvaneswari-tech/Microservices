package com.example.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.appointment.entity.Appointment;
import com.example.appointment.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping
	public Appointment bookAppointment(@RequestBody Appointment appointment) {
		return appointmentService.bookAppointment(appointment);
	}
	
	@GetMapping
	public List<Appointment> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}
	
	@GetMapping("/{id}")
	public Appointment getAppointmentById(@PathVariable int id) {
		return appointmentService.getAppointmentById(id);
	}
}
