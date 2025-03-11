package org.healthcare.appointment.dao;

import java.sql.Date;
import java.util.List;

import org.healthcare.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer>{

	List<Appointment> getByDoctorId(int doctorId);

	List<Appointment> getByPatientId(int patientId);
}
