package com.example.employeemanagementsystem.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

// @Entity Annotation used for creating an entity table for the particular object
@Entity
public class Employees {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String phoneNo;
	private String email;
	private String address;
	private Date createdAt;
	private Date modifiedAt;
	
	// user for many roles
	// Set is a Collection used when We dont want duplicate Values
	// To Ignore Json
	
	
	@OneToMany(mappedBy = "employees")
	@JsonIgnore 
	private Set<UserRole> userRole = new HashSet<>();
	
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public Employees(long id, String name, String phoneNo, String email, String address, Date createdAt,
			Date modifiedAt) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + ", address="
				+ address + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
	}
}
