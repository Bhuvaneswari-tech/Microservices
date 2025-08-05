package com.example.appointment.repository;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.appointment.entity.Appointment;

@Repository
public class AppointmentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Appointment mapRow(ResultSet rs, int rowNum)throws SQLException{
		return new Appointment(
				rs.getInt("id"),
				rs.getInt("patient_id"),
				rs.getInt("doctor_id"),
				rs.getDate("appointment_date")
				);
	}
	
	public int save(Appointment appointment) {
		String sql = "INSERT INTO appointments(patient_id, doctor_id, appointment_date) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, appointment.getPatientId(), 
				appointment.getDoctorId(), appointment.getAppointmentDate());
	}
	
	public List<Appointment> findAll(){
		String sql = "SELECT * FROM appointments";
		return jdbcTemplate.query(sql, this::mapRow);
	}
	
	public Appointment findById(int id) {
		String sql = "SELECT * FROM appointments WHERE id=?";
		return jdbcTemplate.queryForObject(sql, this::mapRow, id);
	}
	
}

/*
 LightWeight
  JDBC is faster than JPA
  Custom queries
  Bulk operations - batch jobs
 * 
 */
