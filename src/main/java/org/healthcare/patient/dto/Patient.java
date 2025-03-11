package org.healthcare.patient.dto;

public class Patient {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String phone;
	private String email;
	private String address;
	
	public Patient() {
		
	}
	
	public Patient(int id, String firstName, String lastName, int age, String gender, String phone, String email,
			String address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
	}
	
	

}
