package org.healthcare.appointment.service;

import java.sql.Date;
import java.util.List;

import org.healthcare.appointment.entity.Appointment;
import org.healthcare.appointment.exception.AppointmentNotFoundException;

public interface AppointmentService {
	

	public List<Appointment> getAll();
	
	public Appointment getById(int id) throws AppointmentNotFoundException;
	
	public Appointment create(Appointment appointment);
	
	public void deleteById(int id);
	
	public List<Appointment> getByDoctorId(int doctorId);

}
