package com.example.employeemanagementsystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagementsystem.dao.EmployeeDAO;
import com.example.employeemanagementsystem.entities.Employees;
import com.example.employeemanagementsystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	// Will auto wire the class for us
	// One of the ways for Dependency Injection
	@Autowired
	private EmployeeDAO employeedao;
	
	List<Employees> list;
	
	public EmployeeServiceImpl() {
		
//		list = new ArrayList<Employees>();
//		
//		Date date = new Date();
//		
//		list.add(new Employees(143, "Employee 1", "9988774653", "tauheed@gmail.com", "sadar", date, date));
//		list.add(new Employees(112, "Employee 2", "9988774654", "tauheed1@gmail.com", "Mankapur", date, date));
	}

	@Override
	public List<Employees> getEmployees() {
		// TODO Auto-generated method stub
		return employeedao.findAll();
	}

	@Override
	public Employees getEmployee(long employeeId) {
		Employees e = null;
//		
//		for(Employees oneEmployee : list) {
//			if(oneEmployee.getId() == employeeId) {
//				e = oneEmployee;
//				break;
//			}
//		}
		return employeedao.getReferenceById(employeeId);
	}

	@Override
	public Employees addEmployee(Employees employee) {
//		list.add(employee);
		employeedao.save(employee);
		return employee;
	}

	@Override
	public Employees updateEmployee(Employees employee) {
//		list.forEach(e -> {
//			if(e.getId() == employee.getId()) {
//				e.setName(employee.getName());
//				e.setPhoneNo(employee.getPhoneNo());
//				e.setEmail(employee.getEmail());
//				e.setAddress(employee.getAddress());
//			}
//		});
		// For Updating we are using save() as when it will get add via id it will check the vvalues if new then it
		// update it else it will add it as a new value
		employeedao.save(employee);
		
		return employee;
	}

	@Override
	public void deleteEmployee(long employeeId) {
//	   list=this.list.stream().filter(e -> e.getId() != employeeId).collect(Collectors.toList());
	   Employees entity = employeedao.getReferenceById(employeeId);
	   employeedao.delete(entity);
	}
  
}
