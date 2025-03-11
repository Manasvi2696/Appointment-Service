package org.healthcare.appointment.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.healthcare.appointment.dao.AppointmentDao;
import org.healthcare.appointment.entity.Appointment;
import org.healthcare.appointment.exception.AppointmentNotFoundException;
import org.healthcare.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDao dao;
	
	@Override
	public List<Appointment> getAll() {
		return dao.findAll();
	}

	@Override
	public Appointment getById(int id) throws AppointmentNotFoundException{
		Optional<Appointment> o = dao.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		throw new AppointmentNotFoundException(id);
	}

	@Override
	public Appointment create(Appointment appointment) {
		return dao.save(appointment);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Appointment> getByDoctorId(int doctorId) {
		return dao.getByDoctorId(doctorId);
	}

	public List<Appointment> getByPatientId(int patientId) {
		return dao.getByPatientId(patientId);
	}


}
