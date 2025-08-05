package com.example.patient.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.patient.entity.Patient;


@Repository
public class PatientRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Patient mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Patient(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getInt("age"),
				rs.getString("gender")
				);
	}
	
	public int save(Patient patient) {
		String sql = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, patient.getName(),patient.getAge(),patient.getGender());
	}
	
	public List<Patient> findAll(){
		return jdbcTemplate.query("SELECT * FROM patients", this::mapRow);
	}
	
	public Patient findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM patients WHERE id=?", this::mapRow, id);
	}

}
