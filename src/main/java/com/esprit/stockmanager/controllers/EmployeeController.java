package com.esprit.stockmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.stockmanager.entities.Employee;
import com.esprit.stockmanager.services.EmployeeService;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(path = "/find/cardId")
	public ResponseEntity<Employee> getEmployeeByCardId(@RequestParam(name = "cardId") String cardId) {
		Employee employee = employeeService.getEmployeeByCardId(cardId);

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping(path = "/list/all")
	public ResponseEntity<List<Employee>> listEmployees(
			@RequestParam(name = "isActive", required = false) Boolean isActive) {
		List<Employee> employees = employeeService.getAllEmployees(isActive);

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping(path = "/create")
	public ResponseEntity<List<Employee>> createEmployees(@RequestBody List<Employee> employees) {
		employees = employeeService.addEmployees(employees);

		return new ResponseEntity<>(employees, HttpStatus.CREATED);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		employee = employeeService.updateEmployee(employee);

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
