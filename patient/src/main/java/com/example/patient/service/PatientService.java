package com.example.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient.entity.Patient;
import com.example.patient.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
    private PatientRepository patientRepo;

    public Patient addPatient(Patient patient) {
        patientRepo.save(patient);
        return patient;
    }

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public Patient getPatientById(int id) {
        return patientRepo.findById(id);
    }
}
