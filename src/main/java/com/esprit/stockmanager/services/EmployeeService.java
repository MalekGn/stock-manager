package com.esprit.stockmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.stockmanager.entities.Employee;
import com.esprit.stockmanager.repositories.EmployeeRepo;

@Service
public class EmployeeService {
	
	private EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee getEmployeeByCardId(String cardId) {
		return employeeRepo.getReferenceById(cardId);
	}
	
	public List<Employee> getAllEmployees(Boolean isActive){
		if(isActive == null) {
			return employeeRepo.findAll();
		} else {
			return isActive ? null : null; // TODO
		}
		
	}
	
	public List<Employee> addEmployees(List<Employee> employees) {
		return employeeRepo.saveAll(employees);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
}
