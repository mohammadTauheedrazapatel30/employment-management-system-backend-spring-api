package com.example.employeemanagementsystem.service;

import java.util.List;

import com.example.employeemanagementsystem.entities.Employees;

public interface EmployeeService {
   
	public List<Employees> getEmployees();
	
	public Employees getEmployee(long employeeId) throws Exception;

    public Employees addEmployee(Employees employee);
    
    public Employees updateEmployee(Employees employee);
    
    public void deleteEmployee(long employeeId);
    
    public Employees findByUsernameandPass(String email, String password);
}
