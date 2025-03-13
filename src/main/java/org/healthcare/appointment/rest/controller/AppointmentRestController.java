package org.healthcare.appointment.rest.controller;

import java.sql.Date;
import java.util.List;

import org.healthcare.appointment.entity.Appointment;
import org.healthcare.appointment.exception.AppointmentNotFoundException;
import org.healthcare.appointment.openfeign.OpenfeignClientDoctor;
import org.healthcare.appointment.openfeign.OpenfeignClientPatient;
import org.healthcare.appointment.service.impl.AppointmentServiceImpl;
import org.healthcare.doctor.dto.Doctor;
import org.healthcare.patient.dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentRestController {
	
	@Autowired
	private AppointmentServiceImpl service;
	@Value("${app.patient.url}")
	private String patientUrl;
	@Value("${app.doctor.url}")
	private String doctorUrl;
	@Autowired
	private OpenfeignClientDoctor doctorclient;
	@Autowired
	private OpenfeignClientPatient patientClient;
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping
	public List<Appointment> findAll(){
		return service.getAll();
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping("/{id}")
	public Appointment getById(@PathVariable int id) throws AppointmentNotFoundException {
		return service.getById(id);
	}
	
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping
	public Appointment registerNewDoctor(@RequestBody Appointment appointment) {
		return service.create(appointment);
	}
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
//	1.Fetch Patient Details for an Appointment
	@GetMapping(value="/{id}/patient")
	public Patient getPatientDetailsForAppointment(@PathVariable int id) throws AppointmentNotFoundException {
		Appointment a = service.getById(id);
		System.out.println(a);
		int patientId = a.getPatientId();
		
//		-------Using RestClient-----
//		Patient p = RestClient.create(patientUrl+patientId)
//		.get()
//		.retrieve()
//		.body(Patient.class);
		
//		-------Using SpringCloud-----
		Patient p = patientClient.findById(patientId);
		return p;
	}
	
//	2.Fetch Doctor Details for an specific appointment
	@GetMapping(value="/{id}/doctor")
	public Doctor getDoctorDetailsForAppointment(@PathVariable int id) throws AppointmentNotFoundException {
		Appointment a = service.getById(id);
		System.out.println(a);
		int doctorId = a.getDoctorId();
		
//		---Using RestClient---
//		Doctor d = RestClient.create(doctorUrl+doctorId)
//		.get()
//		.retrieve()
//		.body(Doctor.class);
		
//		---Using Spring Cloud---
		Doctor d = doctorclient.getById(doctorId);
		
		return d;
	}	
	
//	3.find all Appointment with patient and Doctor details
	@GetMapping("/patient")
	public List<Appointment> getAllAppointmentWithPatientDetails() {
		List<Appointment> a = service.getAll();
		for(int i=0;i<a.size();i++) {
			Appointment a1 = a.get(i);
			int patientId = a1.getPatientId();
			int doctorId = a1.getDoctorId();
			System.out.println(patientId);
			System.out.println(doctorId);
			
//		---- Using RestClient---
//			Patient p = RestClient.create(patientUrl+patientId)
//			.get()
//			.retrieve()
//			.body(Patient.class);
//			System.out.println(p);
//			Doctor d = RestClient.create(doctorUrl+doctorId)
//					.get()
//					.retrieve()
//					.body(Doctor.class);
//			System.out.println(d);
			
//		---Using Spring cloud----
			Patient p = patientClient.findById(patientId);
			System.out.println(p);
			Doctor d = doctorclient.getById(doctorId);
			System.out.println(d);
		a1.setPatient(p);
		a1.setDoctor(d);
		}
		return a;
	}
	
//	4.find Appointment with its Patient details
	@GetMapping(value = "/patient/{id}",params = "Appointment")
	public Appointment findPatientWithAppointmentDetail(@PathVariable int id) throws AppointmentNotFoundException {
		Appointment a = service.getById(id);
		System.out.println(a);
		 int patientId = a.getPatientId();
		 
//		 ----Using RestClient----
//		 Patient p = RestClient.create(patientUrl+patientId)
//				 .get()
//				 .retrieve()
//				 .body(Patient.class);
		 
//		----Using Spring Cloud---
		 Patient p = patientClient.findById(patientId);
		 
		 a.setPatient(p);
		 System.out.println(a);
		return a;
	}
	
//	4.find Appointment with its Doctor details
	@GetMapping(value = "/doctor/{id}",params = "Appointment")
	public Appointment findDoctorWithAppointmentDetail(@PathVariable int id) throws AppointmentNotFoundException {
		Appointment a = service.getById(id);
		System.out.println(a);
		 int doctorId = a.getDoctorId();
		 
//		 ----Using RestClient----
//		 Doctor d = RestClient.create(doctorUrl+doctorId)
//				 .get()
//				 .retrieve()
//				 .body(Doctor.class);
		 
//		----Using Spring cloud----
		 Doctor d = doctorclient.getById(doctorId);
		 
		 a.setDoctor(d);
		 System.out.println(a);
		return a;
	}
	
	@GetMapping(params = "doctorId")
	public List<Appointment> getByDoctorId(@RequestParam int doctorId){
		return service.getByDoctorId(doctorId);
	}

	@GetMapping(params = "patientId")
	public List<Appointment> getByPatientId(@RequestParam int patientId){
		return service.getByPatientId(patientId);
	}
	
	
	@ExceptionHandler
	public ProblemDetail handleAppointmentNotFoundException(AppointmentNotFoundException e) {
		System.out.println(e.getMessage());
		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		detail.setTitle("Appointment Not Found");
		return detail;
	}

}
