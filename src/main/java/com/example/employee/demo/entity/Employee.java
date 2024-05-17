package com.example.employee.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue
private Integer eId;
	
	@Column(name="firstName", nullable=false)
	private String firstName;
	
	@Column(name="lastName", nullable=true)
	private String lastName;
	
	@Column(name="Age", nullable=false)
	private Integer age;
	
	@Column(name="Address", nullable=true)
	private String address;
	
	@Column(name="City", nullable=false)
	private String city;
	
	@Column(name="ZipCode", nullable=false)
	private String zipcode;
	
	@Column(name="Personal_Email", nullable=false)
	private String pEmail;
	
	@Column(name="Office_Email", nullable=false)
	private String oEmail;
	
	@Column(name="Phone_No", nullable=false)
	private String phoneNo;
	
	@Column(name="Total_Salary", nullable=false)
	private Long salary;
	

}
