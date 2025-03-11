package org.healthcare.appointment.dto;

import java.sql.Date;
import java.sql.Time;

import org.healthcare.doctor.dto.Doctor;
import org.healthcare.patient.dto.Patient;

public class Appointment {

    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date appointmentDate;
    private Time appointmentTime;
    private String status;
    private String remarks;
    
    public Appointment() {
    	
    }
    
	public Appointment(int id, Patient patient, Doctor doctor, Date appointmentDate, Time appointmentTime,
			String status, String remarks) {
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Time getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", appointmentDate="
				+ appointmentDate + ", appointmentTime=" + appointmentTime + ", status=" + status + ", remarks="
				+ remarks + "]";
	}
    
    
}

