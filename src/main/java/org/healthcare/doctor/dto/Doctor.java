package org.healthcare.doctor.dto;

public class Doctor {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String specialization;
    private String department;
    private String licenseNumber;
    
    public Doctor() {
    	
    }
    
	public Doctor(int id, String firstName, String lastName, String email, String phone, String specialization,
			String department, String licenseNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.specialization = specialization;
		this.department = department;
		this.licenseNumber = licenseNumber;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", specialization=" + specialization + ", department=" + department
				+ ", licenseNumber=" + licenseNumber + "]";
	}
    
    

}
