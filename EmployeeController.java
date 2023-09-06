package com.example.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagementsystem.entities.Employees;
import com.example.employeemanagementsystem.service.EmployeeService;

// Rest - Representational State Transfer - because Data is sent in Json or XML Format.
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
    
//	@GetMapping("/home")
//	public String home() {
//		return "Welcome To Employee Management System !";
//	}
    
	// Getting All Employees Data
	@GetMapping("/employees")
	public List<Employees> getEmployees(){
		return this.employeeService.getEmployees();		
	}
	
	// Getting Particualr Employee Data
	@GetMapping("/employees/{employeeId}")
	public Employees getEmployee(@PathVariable String employeeId) {
		
        return this.employeeService.getEmployee(Long.parseLong(employeeId));
	}
	
	// Using Post to Add A New Entry 
	@PostMapping("/employees")
	public Employees addEmployee(@RequestBody Employees employee) {
		return this.employeeService.addEmployee(employee);
	}
	
	// Put for Updating details of a particular Employee Entry
	@PutMapping("/employees")
	public Employees updateEmployee(@RequestBody Employees employee) {
		return this.employeeService.updateEmployee(employee);
	}
	
	// For Delete Mapping , we are using ResponseEntity Class used to give different responses using HttpStatus
	// HttpStatus like OK,
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId) {
		try {
			this.employeeService.deleteEmployee(Long.parseLong(employeeId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);	
		} catch (Exception e) {
		    return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
