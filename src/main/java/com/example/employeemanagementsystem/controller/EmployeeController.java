package com.example.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.employeemanagementsystem.entities.Employees;
import com.example.employeemanagementsystem.entities.LoginEntity;
import com.example.employeemanagementsystem.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

// Rest - Representational State Transfer - because Data is sent in Json or XML Format.
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@EnableWebMvc
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	@GetMapping("/home")
//	public String home() {
//		return "Welcome To Employee Management System !";
//	}

	// Getting All Employees Data
	@GetMapping("/employees")
	public List<Employees> getEmployees() {
		return this.employeeService.getEmployees();
	}

	// Getting Particualr Employee Data
	@GetMapping("/employees/{employeeId}")
	public Employees getEmployee(@PathVariable long employeeId) throws Exception {

		return this.employeeService.getEmployee(employeeId);
	}

	// Using Post to Add A New Entry
	@PostMapping("/employees/register")
	public Employees addEmployee(@RequestBody Employees employee) {
		return this.employeeService.addEmployee(employee);
	}

	// Put for Updating details of a particular Employee Entry
	@PutMapping("/employees")
	public Employees updateEmployee(@RequestBody Employees employee) {
		return this.employeeService.updateEmployee(employee);
	}

	// For Delete Mapping , we are using ResponseEntity Class used to give different
	// responses using HttpStatus
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

	// So That we can save the login information
	@PostMapping("/employees/login")
	public String login(@RequestBody Employees employee) {

		LoginEntity log = new LoginEntity();

		try {
			System.out.println("In Login Method under Employee Controller !");

			Employees emp = employeeService.findByUsernameandPass(employee.getEmail(), employee.getPassword());

			// condition if Emp is not null then only set the id and message !
			if (emp != null) {

				log.setId(emp.getId());
				log.setMessage("Login Successfull !");
			}
			return Long.toString(log.getId());
		} catch (Exception e) {

			log.setId(0);
			log.setMessage("Invalid Credentials This is from Spring !");
		}
		return Long.toString(log.getId());

	}
}
