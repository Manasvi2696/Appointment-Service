package org.healthcare.appointment.exception;

public class AppointmentNotFoundException extends Exception{

	public AppointmentNotFoundException(int id) {
		super("Appointment with id :"+id+" Not found.");
	}
}
