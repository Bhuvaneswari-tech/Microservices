package com.example.doctor.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.doctor.entity.Doctor;

@Repository
public class DoctorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Doctor mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Doctor(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("specialization")
				);
	}
	
	public int save(Doctor doctor) {
		String sql = "INSERT INTO doctors(name,specialization) VALUES(?,?)";
		return jdbcTemplate.update(sql, doctor.getName(), doctor.getSpecialization());
	}
	
	public List<Doctor> findAll(){
		return jdbcTemplate.query("SELECT * FROM doctors", this::mapRow);
	}
	
	public Doctor findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM doctors WHERE id=?", this::mapRow, id);
	}
}
