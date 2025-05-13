package com.example.employeemanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanagementsystem.entities.Employees;

public interface EmployeeDAO extends JpaRepository<Employees, Long>{

}
