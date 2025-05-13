package com.example.employeemanagementsystem.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;
	
	// user
	// FetchType.EAGER - So that If You get user role for this employee, you can get the whole object
	@ManyToOne(fetch = FetchType.EAGER)
	private Employees employee;
	
}
