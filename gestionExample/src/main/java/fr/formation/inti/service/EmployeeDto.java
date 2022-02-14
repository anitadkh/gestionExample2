package fr.formation.inti.service;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fr.formation.inti.entity.Employee;

public class EmployeeDto extends Employee{
	@NotEmpty(message="Please enter an email")
	@Email
	private String email;
	@NotNull(message="Please choose a gender")
	private String gender;
	private boolean married;
	
	public EmployeeDto() {
		super();
	}

	public EmployeeDto(String firstName, String last_Name, Date startDate, String title) {
		super(firstName, last_Name, startDate, title);
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean getMarried() {
		return married;
	}
}
